package com.taiji.eap.common.redis.bean;

import com.taiji.eap.common.base.BaseModel;

public class Member extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5911604419377884873L;

	
	private String id;
	private String nickname;
	public Member(String id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
	}
	public Member() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + "]";
	}
	
}
