package com.taiji.eap.common.shiro.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
/**
 * 权限表实体类
 * @author panho
 *
 */
public class SysPuriew extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2368522756954799300L;

	private Long puriewId;//权限ID
	
	private String name;//权限名称
	
	private Integer seq;//排序
	
	private String expression;//权限表达式
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date createTime;//创建时间
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date updateTime;//修改时间
	
	private String valid;//是否有效
	
	private Long creater;//创建人

	public SysPuriew(Long puriewId, String name, Integer seq,
			String expression, Date createTime, Date updateTime, String valid,
			Long creater) {
		super();
		this.puriewId = puriewId;
		this.name = name;
		this.seq = seq;
		this.expression = expression;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.valid = valid;
		this.creater = creater;
	}

	public SysPuriew() {
		super();
	}

	public Long getPuriewId() {
		return puriewId;
	}

	public void setPuriewId(Long puriewId) {
		this.puriewId = puriewId;
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

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
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
		return "SysPuriew [puriewId=" + puriewId + ", name=" + name + ", seq="
				+ seq + ", expression=" + expression + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", valid="
				+ valid + ", creater=" + creater + "]";
	}
	
	
}
