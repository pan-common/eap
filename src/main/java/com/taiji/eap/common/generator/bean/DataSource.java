package com.taiji.eap.common.generator.bean;

import com.taiji.eap.common.datasource.base.DataSourceBeanBuilder;

public class DataSource extends LayuiTree{

    private final String beanName;
    private final String connectName;
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;
    private final String validationQuery;
    private final String databaseName;
    private final boolean testOnBorrow;

    public DataSource(DataSourceBeanBuilder beanBuilder){
        this.beanName=beanBuilder.getBeanName();
        this.connectName = beanBuilder.getConnectName();
        this.driverClassName=beanBuilder.getDriverClassName();
        this.url=beanBuilder.getUrl();
        this.password=beanBuilder.getPassword();
        this.testOnBorrow=beanBuilder.isTestOnBorrow();
        this.username=beanBuilder.getUsername();
        this.validationQuery=beanBuilder.getValidationQuery();
        this.databaseName = beanBuilder.getDatabaseName();
    }

    public String getBeanName() {
        return beanName;
    }

    public String getConnectName() {
        return connectName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }


    @Override
    public String toString() {
        return "DataSourceBean{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                ", testOnBorrow=" + testOnBorrow +
                '}';
    }
}
