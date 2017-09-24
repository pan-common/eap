package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
/**
 * 用户部门实体类
 * @author panho
 *
 */
public class SysUserOrgan extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4483206562653678994L;

	private Long id;//主键Id
	
	private Long userId;//用户ID
	
	private Long organId;//部门Id

	public SysUserOrgan(Long id, Long userId, Long organId) {
		super();
		this.id = id;
		this.userId = userId;
		this.organId = organId;
	}

	public SysUserOrgan() {
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

	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Override
	public String toString() {
		return "SysUserOrgan [id=" + id + ", userId=" + userId + ", organId="
				+ organId + "]";
	}
	
	
	
}
