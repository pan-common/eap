package com.taiji.eap.common.generator.bean;
/**
 * @author panho
 *
 */
public class Column {
	
	private String tableSchema;//数据库名
	private String tableName;//表名
	private String columnName;//列名
	private String isNullAble;//是否为空
	private String ordinalPosition;//排序
	private String dateType;//数据类型
	private String columnKey;//主键
	private String columnComment;//注释

	public Column(String tableSchema, String tableName, String columnName, String isNullAble, String ordinalPosition, String dateType, String columnKey, String columnComment) {
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.columnName = columnName;
		this.isNullAble = isNullAble;
		this.ordinalPosition = ordinalPosition;
		this.dateType = dateType;
		this.columnKey = columnKey;
		this.columnComment = columnComment;
	}

	public Column() {
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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getIsNullAble() {
		return isNullAble;
	}

	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	@Override
	public String toString() {
		return "Column{" +
				"tableSchema='" + tableSchema + '\'' +
				", tableName='" + tableName + '\'' +
				", columnName='" + columnName + '\'' +
				", isNullAble='" + isNullAble + '\'' +
				", ordinalPosition='" + ordinalPosition + '\'' +
				", dateType='" + dateType + '\'' +
				", columnKey='" + columnKey + '\'' +
				", columnComment='" + columnComment + '\'' +
				'}';
	}
}
