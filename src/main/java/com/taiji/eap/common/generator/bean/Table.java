package com.taiji.eap.common.generator.bean;
/**
 * 数据库表对应实体类
 * @author panho
 *
 */
public class Table {
	private String tableSchema;//表所属库
	private String tableName;//表名
	private String tableType;//表类型
	private String tableComment;//表注释
	public Table(String tableSchema, String tableName, String tableType,
			String tableComment) {
		super();
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.tableType = tableType;
		this.tableComment = tableComment;
	}
	public Table() {
		super();
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	@Override
	public String toString() {
		return "Table [tableSchema=" + tableSchema + ", tableName=" + tableName
				+ ", tableType=" + tableType + ", tableComment=" + tableComment
				+ "]";
	}
}
