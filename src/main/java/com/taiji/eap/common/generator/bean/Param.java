package com.taiji.eap.common.generator.bean;

public class Param {

    private String driverClass;
    private String connectionURL;
    private String userId;
    private String password;

    private String schema;//数据库名
    private String tableName;//表名
    private String alias;//别名
    private String aliasUse;//别名启用
    private String packageName;//包名
    private String projectPath;//项目源码路径
    private String filePath;//文件保存路径
    private String deleteWay;//删除方式
    private String pagePath;//页面路径
    private String pageFilePath;//页面文件路径

    private String generateItems;//生成项

    public Param() {
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAliasUse() {
        return aliasUse;
    }

    public void setAliasUse(String aliasUse) {
        this.aliasUse = aliasUse;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDeleteWay() {
        return deleteWay;
    }

    public void setDeleteWay(String deleteWay) {
        this.deleteWay = deleteWay;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getPageFilePath() {
        return pageFilePath;
    }

    public void setPageFilePath(String pageFilePath) {
        this.pageFilePath = pageFilePath;
    }

    public String getGenerateItems() {
        return generateItems;
    }

    public void setGenerateItems(String generateItems) {
        this.generateItems = generateItems;
    }

    @Override
    public String toString() {
        return "Param{" +
                "driverClass='" + driverClass + '\'' +
                ", connectionURL='" + connectionURL + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", schema='" + schema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", alias='" + alias + '\'' +
                ", aliasUse='" + aliasUse + '\'' +
                ", packageName='" + packageName + '\'' +
                ", projectPath='" + projectPath + '\'' +
                ", filePath='" + filePath + '\'' +
                ", deleteWay='" + deleteWay + '\'' +
                ", pagePath='" + pagePath + '\'' +
                ", pageFilePath='" + pageFilePath + '\'' +
                '}';
    }
}
