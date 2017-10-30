package com.taiji.eap.common.datasource.service.impl;


import com.taiji.eap.common.datasource.base.DataSourceBeanBuilder;
import com.taiji.eap.common.datasource.base.DynamicDataSource;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.generator.bean.DataSource;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Override
    public Map<Object, Object> getDataSources() throws NoSuchFieldException, IllegalAccessException {
        DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringContextUtil.getBean("dynamicDataSource");
        return dynamicDataSource.getTargetDataSources();

    }

    @Override
    public List<LayuiTree> getDataSourceTree() {
        List<LayuiTree> dataSources = new ArrayList<LayuiTree>();
        DataSourceBeanBuilder beanBuilder = new DataSourceBeanBuilder(
                "默认数据库连接",
                "dataSource",
                "127.0.0.1",
                "3306",
                "eap",
                "eap",
                "123456"
        );
        DataSource dataSource = new DataSource(beanBuilder);
        dataSource.setName(beanBuilder.getDatabaseName()+"("+beanBuilder.getDatabaseIP()+")");
        dataSource.setSpread(true);
        dataSource.setType(LayuiTree.CONNECT);
        dataSources.add(dataSource);
        return dataSources;

    }

}
