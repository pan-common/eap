package com.taiji.eap.common.query.bean;

public class TabColumn {

    private String tableName;//表名
    private String columnName;//列名
    private String dataType;//数据类型
    private String dataLength;//数据长度
    private String nullAble;//是否为空
    private String columnId;//列ID

    public TabColumn(String tableName, String columnName, String dataType, String dataLength, String nullAble, String columnId) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.dataType = dataType;
        this.dataLength = dataLength;
        this.nullAble = nullAble;
        this.columnId = columnId;
    }

    public TabColumn() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataLength() {
        return dataLength;
    }

    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    @Override
    public String toString() {
        return "TabColumn{" +
                "tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataLength='" + dataLength + '\'' +
                ", nullAble='" + nullAble + '\'' +
                ", columnId='" + columnId + '\'' +
                '}';
    }
}
