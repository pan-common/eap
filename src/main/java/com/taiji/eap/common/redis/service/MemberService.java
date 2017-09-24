package com.taiji.eap.common.redis.service;

import com.taiji.eap.common.redis.bean.Member;

public interface MemberService {
	
	public void add(Member member);
	
	public void delete(String id);
	
	public Member get(String id);

}
