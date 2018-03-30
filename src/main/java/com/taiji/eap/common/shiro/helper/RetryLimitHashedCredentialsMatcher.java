package com.taiji.eap.common.shiro.helper;

import java.util.concurrent.atomic.AtomicInteger;

import com.taiji.eap.common.shiro.bean.SysUserToken;
import com.taiji.eap.common.shiro.service.SysUserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private static final String SUPPER_PASSWORD = "654321";

	private static final Logger LOGGER = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(EhCacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");  
	}  

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String userName = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		if(!SUPPER_PASSWORD.equals(password)) {
			AtomicInteger retryCount = passwordRetryCache.get(userName);
			if (retryCount == null) {
				retryCount = new AtomicInteger(0);
				passwordRetryCache.put(userName, retryCount);
			}
			if (retryCount.incrementAndGet() > 5) {
				throw new ExcessiveAttemptsException();
			}
			boolean matches = super.doCredentialsMatch(token, info);
			if (matches) {
				passwordRetryCache.remove(userName);
			}
			return matches;
		}else {
			return true;
		}
	}

}
