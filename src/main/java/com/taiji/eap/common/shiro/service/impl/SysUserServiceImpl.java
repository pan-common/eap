package com.taiji.eap.common.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.dao.SysUserDao;
import com.taiji.eap.common.shiro.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao; 
	
	@Override
	public SysUser getUserByName(String userName) {
		return sysUserDao.getSysUserByName(userName);
	}

}
