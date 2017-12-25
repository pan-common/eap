package com.taiji.eap.common.datasource.service.impl;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.datasource.base.DataSourceHolder;
import com.taiji.eap.common.datasource.base.DynamicDataSource;
import com.taiji.eap.common.datasource.dao.DataSourceDao;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.datasource.bean.Table;
import com.taiji.eap.common.generator.bean.TableType;
import com.taiji.eap.common.redis.dao.impl.RedisFactoryDao;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    private RedisFactoryDao<DataSource> redisFactoryDao;

    @Override
    public Map<Object, Object> getDataSources() throws NoSuchFieldException, IllegalAccessException {
        return dynamicDataSource.getTargetDataSources();
    }

    @Override
    public List<DataSource> getAllDataSources() throws Exception {
        Map<Object,Object> datasources = getDataSources();
        List<DataSource> dataSources = new ArrayList<>();
        for (Map.Entry entry: datasources.entrySet()) {
            String key = (String) entry.getKey();
            DruidDataSource value = (DruidDataSource) entry.getValue();
            DataSource dataSource = new DataSource();
            dataSource.setBeanName(key);
            dataSource.setConnectName(key);
            dataSource.setDriverClassName(value.getDriverClassName());
            dataSource.setUrl(value.getUrl());
            dataSource.setUsername(value.getUsername());
            dataSource.setPassword(value.getPassword());
            dataSource.setName(dataSource.getConnectName()+"@"+parseUrl(value.getUrl())[0]);
            dataSource.setSpread(false);
            dataSource.setType(BaseTree.CONNECT);
            dataSources.add(dataSource);
        }
        List<DataSource> list = redisFactoryDao.getDatas("datasource", "", new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                return new ArrayList();
            }
        });
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                if(!datasources.containsKey(list.get(i).getBeanName())) {
                    list.get(i).setName(list.get(i).getConnectName() + "@" + parseUrl(list.get(i).getUrl())[0]);
                    list.get(i).setType(BaseTree.CONNECT);
                    dataSources.add(list.get(i));
                }
            }
        }
        return dataSources;
    }

    @Override
    public List<BaseTree> getDataSourceTree() {
        List<BaseTree> dataSources = new ArrayList<BaseTree>();
        DataSource dataSource = new DataSource();
        dataSource.setBeanName("dataSource");
        dataSource.setConnectName("eap");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/eap?useUnicode=true&characterEncoding=utf8&serverTimezone=Hongkong&autoReconnect=true");
        dataSource.setUsername("eap");
        dataSource.setPassword("123456");
        dataSource.setName(dataSource.getConnectName()+"@"+parseUrl(dataSource.getUrl())[0]);
        dataSource.setSpread(true);
        dataSource.setType(BaseTree.CONNECT);
        dataSources.add(dataSource);
        return dataSources;

    }

    @Override
    public List<BaseTree> dataSourceTree() throws Exception {
        Map<Object,Object> datasources = getDataSources();
        List<BaseTree> dataSources = new ArrayList<BaseTree>();

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
            dataSource.setType(BaseTree.CONNECT);
            dataSources.add(dataSource);
        }

        List<DataSource> list = dataSourceDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if(!datasources.containsKey(list.get(i).getBeanName())) {
                list.get(i).setName(list.get(i).getConnectName() + "@" + parseUrl(list.get(i).getUrl())[0]);
                list.get(i).setType(BaseTree.CONNECT);
                dataSources.add(list.get(i));
            }
        }

        return dataSources;
    }

    @Override
    public List<BaseTree> tableTree(String datasource) throws Exception {
        Map<Object,Object> datasources = getDataSources();
        List<BaseTree> dataSources = new ArrayList<BaseTree>();
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
            dataSource.setType(BaseTree.CONNECT);
            dataSources.add(dataSource);
        }
        List<DataSource> list = dataSourceDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if(!datasources.containsKey(list.get(i).getBeanName())) {
                list.get(i).setName(list.get(i).getConnectName() + "@" + parseUrl(list.get(i).getUrl())[0]);
                list.get(i).setType(BaseTree.CONNECT);
                dataSources.add(list.get(i));
            }
        }
        for (int i = 0; i < dataSources.size(); i++) {
            if(!((DataSource)dataSources.get(i)).getBeanName().equals(datasource)){
                dataSources.remove(dataSources.get(i));
                i--;
            }
        }
        if(dataSources.size()==1) {
            BaseTree tableTree = new TableType();
            tableTree.setType(BaseTree.OTHER);
            tableTree.setSpread(true);
            tableTree.setName("表");
            DataSource dataSource = (DataSource) dataSources.get(0);
            //获取数据库表
            List<Table> tables = dataSourceDao.selectTables(parseUrl(dataSource.getUrl())[2], "TABLE");
            for (int i = 0; i < tables.size(); i++) {
                String name = tables.get(i).gettComment() == null || tables.get(i).gettComment().equals("") ? tables.get(i).gettName() : tables.get(i).gettName() + "(" + tables.get(i).gettComment() + ")";
                tables.get(i).setName(name);
                tables.get(i).setSpread(true);
                tables.get(i).setType(BaseTree.TABLE);
                tables.get(i).setDriverClass(dataSource.getDriverClassName());
                tables.get(i).setConnectionURL(dataSource.getUrl());
                tables.get(i).setUserId(dataSource.getUsername());
                tables.get(i).setPassword(dataSource.getPassword());
                tableTree.addChildren(tables.get(i));
            }
            BaseTree viewTree = new TableType();
            viewTree.setType(BaseTree.OTHER);
            viewTree.setSpread(true);
            viewTree.setName("视图");
            //获取数据库视图
            List<Table> views = dataSourceDao.selectTables(parseUrl(dataSource.getUrl())[2], "VIEW");
            for (int i = 0; i < views.size(); i++) {
                String name = views.get(i).gettComment() == null ? views.get(i).gettName() : views.get(i).gettName() + "(" + views.get(i).gettComment() + ")";
                views.get(i).setName(name);
                views.get(i).setSpread(true);
                views.get(i).setType(BaseTree.TABLE);
                views.get(i).setDriverClass(dataSource.getDriverClassName());
                views.get(i).setConnectionURL(dataSource.getUrl());
                views.get(i).setUserId(dataSource.getUsername());
                views.get(i).setPassword(dataSource.getPassword());
                viewTree.addChildren(views.get(i));
            }
            dataSources.add(tableTree);
            dataSources.add(viewTree);
        }
//        DataSourceHolder.clearDataSource();
//        resetDatabaseId();
        return dataSources;
    }

    @Override
    public void changeDataSource(String datasource) throws NoSuchFieldException, IllegalAccessException {
        Map<Object,Object> datasources = getDataSources();
        List<BaseTree> dataSources = new ArrayList<BaseTree>();
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
            dataSource.setType(BaseTree.CONNECT);
            dataSources.add(dataSource);
        }
        List<DataSource> list = dataSourceDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if(!datasources.containsKey(list.get(i).getBeanName())) {
                list.get(i).setName(list.get(i).getConnectName() + "@" + parseUrl(list.get(i).getUrl())[0]);
                list.get(i).setType(BaseTree.CONNECT);
                dataSources.add(list.get(i));
            }
        }
        for (int i = 0; i < dataSources.size(); i++) {
            if(!((DataSource)dataSources.get(i)).getBeanName().equals(datasource)){
                dataSources.remove(dataSources.get(i));
                i--;
            }
        }
        if(dataSources.size()==1) {
            DataSourceHolder.setDataSource((DataSource) dataSources.get(0));
        }
    }

    @Override
    @Transactional
    public List<BaseTree> tableTree(String beanName, String driverClassName, String url, String username, String password) {
        DataSource dataSource = new DataSource();
        dataSource.setBeanName(beanName);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url.replaceAll("amp;",""));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //切换数据源
        DataSourceHolder.setDataSource(dataSource);

        List<BaseTree> dataSources = new ArrayList<BaseTree>();
        BaseTree tableTree = new TableType();
        tableTree.setType(BaseTree.OTHER);
        tableTree.setSpread(true);
        tableTree.setName("表");
        //获取数据库表
        List<Table> tables = dataSourceDao.selectTables(parseUrl(url)[2],"TABLE");
        for (int i = 0; i < tables.size(); i++) {
            String name = tables.get(i).gettComment()==null||tables.get(i).gettComment().equals("")?tables.get(i).gettName():tables.get(i).gettName()+"("+tables.get(i).gettComment()+")";
            tables.get(i).setName(name);
            tables.get(i).setSpread(true);
            tables.get(i).setType(BaseTree.TABLE);
            tables.get(i).setDriverClass(driverClassName);
            tables.get(i).setConnectionURL(url);
            tables.get(i).setUserId(username);
            tables.get(i).setPassword(password);
            tableTree.addChildren(tables.get(i));
        }
        BaseTree viewTree = new TableType();
        viewTree.setType(BaseTree.OTHER);
        viewTree.setSpread(true);
        viewTree.setName("视图");
        //获取数据库视图
        List<Table> views = dataSourceDao.selectTables(parseUrl(url)[2],"VIEW");
        for (int i = 0; i < views.size(); i++) {
            String name = views.get(i).gettComment()==null?views.get(i).gettName():views.get(i).gettName()+"("+views.get(i).gettComment()+")";
            views.get(i).setName(name);
            views.get(i).setSpread(true);
            views.get(i).setType(BaseTree.TABLE);
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
