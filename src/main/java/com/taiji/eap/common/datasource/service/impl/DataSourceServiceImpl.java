package com.taiji.eap.common.datasource.service.impl;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.datasource.base.DataSourceContext;
import com.taiji.eap.common.datasource.base.DataSourceHolder;
import com.taiji.eap.common.datasource.base.DynamicDataSource;
import com.taiji.eap.common.datasource.dao.DataSourceDao;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.datasource.bean.Table;
import com.taiji.eap.common.generator.bean.TableType;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataSourceServiceImpl extends BaseServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceDao dataSourceDao;

    @Autowired
    private VendorDatabaseIdProvider databaseIdProvider;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Override
    public Map<Object, Object> getDataSources() throws NoSuchFieldException, IllegalAccessException {
        return dynamicDataSource.getTargetDataSources();
    }

    @Override
    public List<LayuiTree> getDataSourceTree() {
        List<LayuiTree> dataSources = new ArrayList<LayuiTree>();
        DataSource dataSource = new DataSource();
        dataSource.setBeanName("dataSource");
        dataSource.setConnectName("eap");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/eap?useUnicode=true&characterEncoding=utf8&serverTimezone=Hongkong&autoReconnect=true");
        dataSource.setUsername("eap");
        dataSource.setPassword("123456");
        dataSource.setName(dataSource.getConnectName()+"@"+parseUrl(dataSource.getUrl())[0]);
        dataSource.setSpread(true);
        dataSource.setType(LayuiTree.CONNECT);
        dataSources.add(dataSource);
        return dataSources;

    }

    @Override
    public List<LayuiTree> dataSourceTree() throws NoSuchFieldException, IllegalAccessException {
        Map<Object,Object> datasources = getDataSources();
        List<LayuiTree> dataSources = new ArrayList<LayuiTree>();

        List<DataSource> list = dataSourceDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setName(list.get(i).getConnectName()+"@"+parseUrl(list.get(i).getUrl())[0]);
            list.get(i).setType(LayuiTree.CONNECT);
            dataSources.add(list.get(i));
        }
        for (Map.Entry entry: datasources.entrySet()) {
            String key = (String) entry.getKey();
            DruidDataSource value = (DruidDataSource) entry.getValue();
            DataSource dataSource = new DataSource();
            dataSource.setBeanName(key);
            dataSource.setConnectName(parseUrl(value.getUrl())[2]);
            dataSource.setDriverClassName(value.getDriverClassName());
            dataSource.setUrl(value.getUrl());
            dataSource.setUsername(value.getUsername());
            dataSource.setPassword(value.getPassword());
            dataSource.setName(dataSource.getConnectName()+"@"+parseUrl(value.getUrl())[0]);
            dataSource.setSpread(false);
            dataSource.setType(LayuiTree.CONNECT);
            dataSources.add(dataSource);
        }
        return dataSources;
    }

    @Override
    @Transactional
    public List<LayuiTree> tableTree(String beanName,String driverClassName,String url,String username,String password) {
        DataSource dataSource = new DataSource();
        dataSource.setBeanName(beanName);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url.replaceAll("amp;",""));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //切换数据源
        DataSourceHolder.setDataSource(dataSource);

        List<LayuiTree> dataSources = new ArrayList<LayuiTree>();
        LayuiTree tableTree = new TableType();
        tableTree.setType(LayuiTree.OTHER);
        tableTree.setSpread(true);
        tableTree.setName("表");
        //获取数据库表
        List<Table> tables = dataSourceDao.selectTables(parseUrl(url)[2],"TABLE");
        for (int i = 0; i < tables.size(); i++) {
            String name = tables.get(i).gettComment()==null||tables.get(i).gettComment().equals("")?tables.get(i).gettName():tables.get(i).gettName()+"("+tables.get(i).gettComment()+")";
            tables.get(i).setName(name);
            tables.get(i).setSpread(true);
            tables.get(i).setType(LayuiTree.TABLE);
            tables.get(i).setDriverClass(driverClassName);
            tables.get(i).setConnectionURL(url);
            tables.get(i).setUserId(username);
            tables.get(i).setPassword(password);
            tableTree.addChildren(tables.get(i));
        }
        LayuiTree viewTree = new TableType();
        viewTree.setType(LayuiTree.OTHER);
        viewTree.setSpread(true);
        viewTree.setName("视图");
        //获取数据库视图
        List<Table> views = dataSourceDao.selectTables(parseUrl(url)[2],"VIEW");
        for (int i = 0; i < views.size(); i++) {
            String name = views.get(i).gettComment()==null?views.get(i).gettName():views.get(i).gettName()+"("+views.get(i).gettComment()+")";
            views.get(i).setName(name);
            views.get(i).setSpread(true);
            views.get(i).setType(LayuiTree.TABLE);
            views.get(i).setDriverClass(driverClassName);
            views.get(i).setConnectionURL(url);
            views.get(i).setUserId(username);
            views.get(i).setPassword(password);
            viewTree.addChildren(views.get(i));
        }
        dataSources.add(tableTree);
        dataSources.add(viewTree);

        DataSourceHolder.clearDataSource();
        resetDatabaseId();
        return dataSources;
    }

    @Override
    public void updateDatabaseId(String beanName) {
        DruidDataSource druidDataSource = null;
        try {
            Map<Object,Object> dataSources = dynamicDataSource.getTargetDataSources();
            druidDataSource = (DruidDataSource) dataSources.get(beanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        try {
            sqlSessionFactoryBean.getObject().getConfiguration().setDatabaseId(databaseIdProvider.getDatabaseId(druidDataSource));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetDatabaseId() {
        DruidDataSource druidDataSource = null;
        druidDataSource = dynamicDataSource.getDefaultDataSource();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        try {
            sqlSessionFactoryBean.getObject().getConfiguration().setDatabaseId(databaseIdProvider.getDatabaseId(druidDataSource));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] parseUrl(String url){
        String[] result = new String[3];
        if(url.contains("mysql")){
            String baseUrl = url.split("[?]")[0].split("://")[1];
            String dbname = baseUrl.split("/")[1];
            String ip = baseUrl.split("/")[0].split(":")[0];
            String port = baseUrl.split("/")[0].split(":")[1];
            result[0] = ip;
            result[1] = port;
            result[2] = dbname;
        }else if(url.contains("oracle")){
            String dbname = url.split("@")[1].split("/")[1];
            String ip = url.split("@")[1].split("/")[0].split(":")[0];
            String port = url.split("@")[1].split("/")[0].split(":")[1];
            result[0] = ip;
            result[1] = port;
            result[2] = dbname;
        }
        return result;
    }

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return dataSourceDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(DataSource dataSource) {
        return dataSourceDao.insert(dataSource);
    }

    @Override
    public DataSource selectByPrimaryKey(Long primaryKey) {
        return dataSourceDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(DataSource dataSource) {
        return dataSourceDao.updateByPrimaryKey(dataSource);
    }

    @Override
    public List<DataSource> list(String searchText) {
        return dataSourceDao.list(searchText);
    }

    @Override
    public PageInfo<DataSource> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<DataSource> dataSources = dataSourceDao.list(searchText);
        PageInfo<DataSource> pageInfo = new PageInfo<DataSource>(dataSources);
        return pageInfo;
    }

    @Override
    public String connectTest(DataSource dataSource) throws Exception {
        Map<Object,Object> hashMap = new HashMap<>();
        hashMap.put("driverClassName",dataSource.getDriverClassName());
        hashMap.put("url",dataSource.getUrl().replaceAll("amp;",""));
        hashMap.put("username",dataSource.getUsername());
        hashMap.put("password",dataSource.getPassword());
        hashMap.put("removeAbandoned","true");
        hashMap.put("removeAbandonedTimeout","120");
        hashMap.put("logAbandoned","true");
        javax.sql.DataSource ds = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String result = null;
        try {
            ds = DruidDataSourceFactory.createDataSource(hashMap);
            connection =  ds.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT 'x' FROM dual");
            result = "";
            while (resultSet.next()){
                result = (String) resultSet.getObject("x");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if(connection!=null) {
                connection.close();
            }
            if(statement!=null) {
                statement.close();
            }
            if(resultSet!=null) {
                resultSet.close();
            }
        }
        return result.equals("x")?"连接成功":"连接失败";
    }
}
