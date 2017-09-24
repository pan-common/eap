package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
/**
 * 用户角色实体类
 * @author panho
 *
 */
public class SysUserRole extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -76274252822863383L;

	private Long id;//主键ID
	
	private Long userId;//用户ID
	
	private Long roleId;//角色Id

	public SysUserRole(Long id, Long userId, Long roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public SysUserRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole [id=" + id + ", userId=" + userId + ", roleId="
				+ roleId + "]";
	}
	
	
}
