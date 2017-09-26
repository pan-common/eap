package com.taiji.eap.common.generator.service.impl;

import com.taiji.eap.common.datasource.base.DataSourceBeanBuilder;
import com.taiji.eap.common.generator.bean.DataSource;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.service.DataSourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSourceServiceImpl implements DataSourceService{

    @Override
    public List<LayuiTree> getDataSources() {
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
