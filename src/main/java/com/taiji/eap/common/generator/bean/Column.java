package com.taiji.eap.common.generator.bean;
/**
 * ���ݿ�����е�ʵ����
 * @author panho
 *
 */
public class Column {
	
	private String tableSchema;//��ռ�
	private String tableName;//����
	private String columnName;//����
	private String isNullAble;//�Ƿ����Ϊ��
	private String dateType;//��������
	private String columnKey;//�Ƿ�Ϊ ��PRI����Լ����UNIΨһԼ����MUL�����ظ���
	
	public Column(String tableSchema, String tableName, String columnName,
			String isNullAble, String dateType, String columnKey) {
		super();
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.columnName = columnName;
		this.isNullAble = isNullAble;
		this.dateType = dateType;
		this.columnKey = columnKey;
	}
	public Column() {
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
	@Override
	public String toString() {
		return "Column [tableSchema=" + tableSchema + ", tableName="
				+ tableName + ", columnName=" + columnName + ", isNullAble="
				+ isNullAble + ", dateType=" + dateType + ", columnKey="
				+ columnKey + "]";
	}
	
}
