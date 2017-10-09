package com.taiji.eap.common.generator.bean;
/**
 * 数据库表对应实体类
 * @author panho
 *
 */
public class Table extends DataSourceTree{
	private String tSchema;//表所属库
	private String tName;//表名
	private String tType;//表类型
	private String tComment;//表注释

	public Table(String tSchema, String tName, String tType, String tComment) {
		this.tSchema = tSchema;
		this.tName = tName;
		this.tType = tType;
		this.tComment = tComment;
	}

	public Table() {
	}

	public String gettSchema() {
		return tSchema;
	}

	public void settSchema(String tSchema) {
		this.tSchema = tSchema;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public String gettComment() {
		return tComment;
	}

	public void settComment(String tComment) {
		this.tComment = tComment;
	}

	@Override
	public String toString() {
		return "Table{" +
				"tSchema='" + tSchema + '\'' +
				", tName='" + tName + '\'' +
				", tType='" + tType + '\'' +
				", tComment='" + tComment + '\'' +
				'}';
	}
}
