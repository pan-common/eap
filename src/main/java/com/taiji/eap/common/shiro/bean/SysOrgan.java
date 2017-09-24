package com.taiji.eap.common.shiro.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
/**
 * 部门表
 * @author panho
 *
 */
public class SysOrgan extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3805340509337916458L;

	private Long organId;//部门ID
	
	private String name;//部门名称
	
	private String icon;//部门图标
	
	private Long parentId;//上级部门ID
	
	private Integer seq;//排序
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date createTime;//创建时间
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date updateTime;//修改时间
	
	private String valid;//是否有效
	
	private Long creater;//创建人

	public SysOrgan(Long organId, String name, String icon, Long parentId,
			Integer seq, Date createTime, Date updateTime, String valid,
			Long creater) {
		super();
		this.organId = organId;
		this.name = name;
		this.icon = icon;
		this.parentId = parentId;
		this.seq = seq;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.valid = valid;
		this.creater = creater;
	}

	public SysOrgan() {
		super();
	}

	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
		return "SysOrgan [organId=" + organId + ", name=" + name + ", icon="
				+ icon + ", parentId=" + parentId + ", seq=" + seq
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", valid=" + valid + ", creater=" + creater + "]";
	}
	
}
