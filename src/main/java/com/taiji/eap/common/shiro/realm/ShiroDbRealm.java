package com.taiji.eap.common.shiro.realm;

import com.taiji.eap.common.redis.dao.impl.RedisFactoryDao;
import com.taiji.eap.common.shiro.bean.SysPurview;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.bean.SysUserToken;
import com.taiji.eap.common.shiro.exception.HaveLandedException;
import com.taiji.eap.common.shiro.service.*;
import com.taiji.eap.common.shiro.token.DeviceToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	private SysPurviewService sysPurviewService;

	@Autowired
	private RedisFactoryDao<String> redisFactoryDao;
	/**
	 * 验证当前登陆用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		DeviceToken token = (DeviceToken) authcToken;
		SysUser sysUser = userService.getUserByName(token.getUsername());
		if(sysUser==null) {
			throw new UnknownAccountException("账号不存在");
		}
		if(sysUser.getValid().equals("2")) {
			throw new DisabledAccountException("账号未启用");
		}

		//验证账号是否已经登陆
		SysUserToken userToken = userService.selectUserTokenByUserName(token.getUsername(),token.getDeviceType());
		if(userToken!=null){
			//用户已登陆
			throw new HaveLandedException("用户已登陆");
		}

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
		List<String> permissions = null;
		try {
			permissions = redisFactoryDao.getDatas("user:puriew",String.valueOf(sysUser.getUserId()), new RedisFactoryDao.OnRedisSelectListener() {
                @Override
                public List fruitless() {
                	List<String> permissions = new ArrayList<>();
					List<Long> roleIdList = sysRoleService.getRoleIdsByUserId(sysUser.getUserId());
					List<Long> organIdList = sysOrganService.getOrganIdsByUserId(sysUser.getUserId());
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
					List<SysPurview> sysPurviews = sysPurviewService.getPuriewByResourceIds(resourceIds);
					for (SysPurview sysPurview : sysPurviews) {
						if(!StringUtils.isEmpty(sysPurview.getExpression().trim())) {
							permissions.add(sysPurview.getExpression());
						}
					}
                    return permissions;
                }
            });
		} catch (Exception e) {
			e.printStackTrace();
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
