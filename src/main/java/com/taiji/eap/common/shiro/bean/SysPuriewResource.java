package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
/**
 * 权限资源关系表
 * @author panho
 *
 */
public class SysPuriewResource extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7953135050005302806L;

	private Long id;//主键ID
	
	private Long puriewId;//权限ID
	
	private Long resourceId;//资源ID

	public SysPuriewResource(Long id, Long puriewId, Long resourceId) {
		super();
		this.id = id;
		this.puriewId = puriewId;
		this.resourceId = resourceId;
	}

	public SysPuriewResource() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPuriewId() {
		return puriewId;
	}

	public void setPuriewId(Long puriewId) {
		this.puriewId = puriewId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return "SysPuriewResource [id=" + id + ", puriewId=" + puriewId
				+ ", resourceId=" + resourceId + "]";
	}
	
	
	
}
