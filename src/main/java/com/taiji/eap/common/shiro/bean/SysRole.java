package com.taiji.eap.common.shiro.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
/**
 * 角色表实体类
 * @author panho
 *
 */
public class SysRole extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2294044850805480737L;

	private Long roleId;//角色 ID
	
	private String name;//角色名称
	
	private Integer seq;//排序
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date createTime;//创建时间
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date updateTime;//修改时间
	
	private String valid;//是否有效
	
	private Long creater;//创建人

	public SysRole(Long roleId, String name, Integer seq, Date createTime,
			Date updateTime, String valid, Long creater) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.seq = seq;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.valid = valid;
		this.creater = creater;
	}

	public SysRole() {
		super();
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", name=" + name + ", seq=" + seq
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", valid=" + valid + ", creater=" + creater + "]";
	}
	
	
	
}
