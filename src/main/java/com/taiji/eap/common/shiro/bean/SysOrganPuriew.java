package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
/**
 * 部门权限关系实体类
 * @author panho
 *
 */
public class SysOrganPuriew extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8337044181367753318L;

	private Long id;//主键
	
	private Long organId;//部门Id
	
	private Long puriewId;//权限ID

	public SysOrganPuriew(Long id, Long organId, Long puriewId) {
		super();
		this.id = id;
		this.organId = organId;
		this.puriewId = puriewId;
	}

	public SysOrganPuriew() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	public Long getPuriewId() {
		return puriewId;
	}

	public void setPuriewId(Long puriewId) {
		this.puriewId = puriewId;
	}

	@Override
	public String toString() {
		return "SysOrganPuriew [id=" + id + ", organId=" + organId
				+ ", puriewId=" + puriewId + "]";
	}
	
	
}
