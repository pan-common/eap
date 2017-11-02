package com.taiji.eap.common.shiro.realm;

import com.taiji.eap.common.shiro.bean.ShiroUser;
import com.taiji.eap.common.shiro.bean.SysPuriew;
import com.taiji.eap.common.shiro.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taiji.eap.common.shiro.bean.SysUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component(value="realm")
public class ShiroDbRealm extends AuthorizingRealm{

	@Autowired
	private SysUserService userService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysOrganService sysOrganService;

	@Autowired
	private SysResourceService sysResourceService;

	@Autowired
	private SysPuriewService sysPuriewService;

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
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
				sysUser,
				sysUser.getPassword(),
				ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
				getName());
		return authcInfo;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
		List<Long> roleIdList = sysRoleService.getRoleIdsByUserId(sysUser.getUserId());
		List<Long> organIdList = sysOrganService.getOrganIdsByUserId(sysUser.getUserId());
		ShiroUser shiroUser = new ShiroUser();
		shiroUser.setUserId(sysUser.getUserId());
		shiroUser.setFullName(sysUser.getUserName());
		shiroUser.setUserName(sysUser.getUserName());
		shiroUser.setOrgans(organIdList);
		shiroUser.setRoles(roleIdList);
		List<Long> tempResourceIds = new ArrayList<>();
		Set<Long> set = new HashSet<>();
		List<Long> resourceIds = new ArrayList<>();
		tempResourceIds.addAll(sysResourceService.getResourceIdsByOrganIds(organIdList));
		tempResourceIds.addAll(sysResourceService.getResourceIdsByRoleIds(roleIdList));
		for (Long resourceId: tempResourceIds) {
			if(set.add(resourceId)){
				resourceIds.add(resourceId);
			}
		}
		List<SysPuriew> sysPuriews = sysPuriewService.getPuriewByResourceIds(resourceIds);
		Set<String> permissions = new HashSet<>();
		for (SysPuriew sysPuriew: sysPuriews) {
			permissions.add(sysPuriew.getExpression());
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissions);
		return authorizationInfo;
	}

	/**
	 * 清空权限
	 * @param username
	 */
	public void removeUserAuthorizationInfoCache(String username) {
		SysUser sysUser = userService.getUserByName(username);
		SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
		principalCollection.add(sysUser,super.getName());
		super.clearCachedAuthenticationInfo(principalCollection);
	}

}
