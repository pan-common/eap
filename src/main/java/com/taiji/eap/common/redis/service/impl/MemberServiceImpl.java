package com.taiji.eap.common.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.eap.common.redis.bean.Member;
import com.taiji.eap.common.redis.dao.impl.MemberDaoImpl;
import com.taiji.eap.common.redis.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDaoImpl memberDao;
	
	@Override
	public void add(Member member) {
		memberDao.add(member);
	}

	@Override
	public void delete(String id) {
		memberDao.delete(id);
	}

	@Override
	public Member get(String id) {
		return memberDao.get(id);
	}

}
