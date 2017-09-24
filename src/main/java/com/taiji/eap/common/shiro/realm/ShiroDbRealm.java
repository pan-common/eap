package com.taiji.eap.common.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.service.SysUserService;

@Component(value="realm")
public class ShiroDbRealm extends AuthorizingRealm{
	
	@Autowired
	private SysUserService userService;

	/**
	 * 验证当前登陆用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser sysUser = userService.getUserByName(token.getUsername());
		if(sysUser==null)
			throw new UnknownAccountException("账号不存在");
		if(sysUser.getValid().equals("2"))
			throw new DisabledAccountException("账号未启用");
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(sysUser.getUserName(), sysUser.getPassword(), getName());
		return authcInfo;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}



}
