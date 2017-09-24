package com.taiji.eap.common.generator.bean;

public class Test {

	private String savePath;
	private String basePackage;
	private String moduleName;
	private String tableName;
	private String anotherName;
	private String dao;
	private String service;
	private String action;
	private String list;
	private String add;
	private String update;
	private String detail;
	private String js;
	private String css;
	public Test(String savePath, String basePackage, String moduleName,
			String tableName, String anotherName, String dao, String service,
			String action, String list, String add, String update,
			String detail, String js, String css) {
		super();
		this.savePath = savePath;
		this.basePackage = basePackage;
		this.moduleName = moduleName;
		this.tableName = tableName;
		this.anotherName = anotherName;
		this.dao = dao;
		this.service = service;
		this.action = action;
		this.list = list;
		this.add = add;
		this.update = update;
		this.detail = detail;
		this.js = js;
		this.css = css;
	}
	public Test() {
		super();
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAnotherName() {
		return anotherName;
	}
	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName;
	}
	public String getDao() {
		return dao;
	}
	public void setDao(String dao) {
		this.dao = dao;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	@Override
	public String toString() {
		return "Test [savePath=" + savePath + ", basePackage=" + basePackage
				+ ", moduleName=" + moduleName + ", tableName=" + tableName
				+ ", anotherName=" + anotherName + ", dao=" + dao
				+ ", service=" + service + ", action=" + action + ", list="
				+ list + ", add=" + add + ", update=" + update + ", detail="
				+ detail + ", js=" + js + ", css=" + css + "]";
	}
	
	
}
