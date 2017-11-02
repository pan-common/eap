package com.taiji.eap.common.shiro.bean;

import java.util.List;

import com.taiji.eap.common.base.BaseModel;

public class ShiroUser extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662003069095823814L;

	private Long userId;

	private String userName;

	private String fullName;

	private List<String> resources;//资源列表

	private List<Long> roles;//角色列表

	private List<Long> organs;//部门列表

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public List<Long> getRoles() {
		return roles;
	}

	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}

	public List<Long> getOrgans() {
		return organs;
	}

	public void setOrgans(List<Long> organs) {
		this.organs = organs;
	}

	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		String name = userName;
		if(fullName!=null&&!fullName.equals(""))
			name = fullName;
		return name;
	}



}
