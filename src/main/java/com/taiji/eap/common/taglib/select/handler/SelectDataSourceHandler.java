package com.taiji.eap.common.taglib.select.handler;

import com.alibaba.druid.pool.DruidDataSource;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取数据源下拉列表
 */
public class SelectDataSourceHandler extends SelectCommonDataSourceHandler<DataSource>{

    @Autowired
    DataSourceService dataSourceService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("datasource"))
            return true;
        else
            return false;
    }

    @Override
    public String getKeyName() {
        return "beanName";
    }

    @Override
    public String getValueName() {
        return "connectName";
    }

    @Override
    public List<DataSource> getDataSource(String... params) throws Exception {
        List<DataSource> dataSources = dataSourceService.getAllDataSources();
        return dataSources;
    }

    @Override
    public Class<DataSource> getDataSourceClass() {
        return DataSource.class;
    }
}
