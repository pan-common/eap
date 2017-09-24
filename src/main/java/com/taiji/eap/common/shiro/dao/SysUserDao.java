package com.taiji.eap.common.shiro.dao;

import org.apache.ibatis.annotations.Param;

import com.taiji.eap.common.shiro.bean.SysUser;

public interface SysUserDao {
	
	public SysUser getSysUserByName(@Param("userName")String userName);

}
