package com.taiji.eap.common.shiro.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
/**
 * 用户基本信息
 * @author panho
 *
 */
public class SysUser extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7008352968196968744L;

	private Long userId;//用户ID
	
	private String userName;//用户名称
	
	private String password;//密码
	
	private String salt;//盐值
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
	private Date updateTime;
	
	private String valid;//是否有效
	
	private Long creater;//创建人
	
	private String remember;//记住我
	
	private Integer locked;//是否锁住

	public SysUser(Long userId, String userName, String password, String salt,
			Date createTime, Date updateTime, String valid, Long creater,
			String remember, Integer locked) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.valid = valid;
		this.creater = creater;
		this.remember = remember;
		this.locked = locked;
	}

	public SysUser() {
		super();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	
	public String getCredentialsSalt(){
		return userName+salt;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", salt=" + salt + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", valid="
				+ valid + ", creater=" + creater + ", remember=" + remember
				+ ", locked=" + locked + "]";
	}

}
