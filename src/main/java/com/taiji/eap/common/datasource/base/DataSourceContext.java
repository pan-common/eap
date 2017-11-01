package com.taiji.eap.common.datasource.base;

import com.taiji.eap.common.datasource.bean.DataSource;

public class DataSourceContext {
    //使用该方法设置数据源
    public static void setDataSource(DataSource dataSource){
        DataSourceHolder.setDataSource(dataSource);
    }
    //使用该方法清除数据源，清除后将使用默认数据源
    public static void clearDataSource(){
        DataSourceHolder.clearDataSource();
    }

}
