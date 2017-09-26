package com.taiji.eap.common.generator.bean;

public class Param {

    private String schema;//数据库名
    private String tableName;//表名
    private String alias;//别名

    public Param(String schema, String tableName, String alias) {
        this.schema = schema;
        this.tableName = tableName;
        this.alias = alias;
    }

    public Param() {
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Param{" +
                "schema='" + schema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
