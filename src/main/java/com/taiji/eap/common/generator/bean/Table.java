package com.taiji.eap.common.generator.bean;
/**
 * ���ݿ���Ӧʵ����
 * @author panho
 *
 */
public class Table extends DataSourceTree{
	private String tSchema;//��������
	private String tName;//����
	private String tType;//������
	private String tComment;//��ע��

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
