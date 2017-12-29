package com.taiji.eap.common.datasource.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.SqlSessionFactoryBean;

public class DataSourceHolder {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();

    public static String getDataSource(){
        return threadLocal.get();
    }

    public static void setDataSource(String dataSource){
        threadLocal.set(dataSource);
    }

    public static void clearDataSource(){
        threadLocal.remove();
    }

}
