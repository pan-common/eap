package com.taiji.eap.common.shiro.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;

public class SysResource extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -937666477864845684L;

	private Long resourceId;//资源ID
	
	private String name;//资源名称
	
	private Long parentId;//上级ID
	
	private String typeCode;//资源类型编码
	
	private String typeDesc;//资源类型描述
	
	private String icon;//图标
	
	private String link;//链接
	
	private Integer seq;//排序
	
	private String note;//备注
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date createTime;//创建时间
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date updateTime;//修改时间
	
	private String valid;//是否有效
	
	private Long creater;//创建人
	
	private boolean spread = false;
	
	private List<SysResource> children = new ArrayList<SysResource>();
	

	public SysResource(Long resourceId, String name) {
		super();
		this.resourceId = resourceId;
		this.name = name;
	}

	public SysResource(Long resourceId, String name, Long parentId,
			String typeCode, String typeDesc, String icon, String link,
			Integer seq, String note, Date createTime, Date updateTime,
			String valid, Long creater) {
		super();
		this.resourceId = resourceId;
		this.name = name;
		this.parentId = parentId;
		this.typeCode = typeCode;
		this.typeDesc = typeDesc;
		this.icon = icon;
		this.link = link;
		this.seq = seq;
		this.note = note;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.valid = valid;
		this.creater = creater;
	}

	public SysResource() {
		super();
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	
	public List<SysResource> getChildren() {
		return children;
	}

	public void setChildren(List<SysResource> children) {
		this.children = children;
	}
	
	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	@Override
	public String toString() {
		return "SysResource [resourceId=" + resourceId + ", name=" + name
				+ ", parentId=" + parentId + ", typeCode=" + typeCode
				+ ", typeDesc=" + typeDesc + ", icon=" + icon + ", link="
				+ link + ", seq=" + seq + ", note=" + note + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", valid="
				+ valid + ", creater=" + creater + "]";
	}
	
	
}
