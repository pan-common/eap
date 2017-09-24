package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
/**
 * 角色权限关系表
 * @author panho
 *
 */
public class SysRolePuriew extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2577917709920216238L;

	private Long id;//主键ID
	
	private Long roleId;//角色Id
	
	private Long puriewId;//权限ID

	public SysRolePuriew(Long id, Long roleId, Long puriewId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.puriewId = puriewId;
	}

	public SysRolePuriew() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPuriewId() {
		return puriewId;
	}

	public void setPuriewId(Long puriewId) {
		this.puriewId = puriewId;
	}

	@Override
	public String toString() {
		return "SysRolePuriew [id=" + id + ", roleId=" + roleId + ", puriewId="
				+ puriewId + "]";
	}
	
	
	
}
