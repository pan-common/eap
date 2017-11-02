package com.taiji.eap.common.shiro.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taiji.eap.common.shiro.bean.SysUser;

@Service
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	@Value("${algorithmName}")
	private String algorithmName;
	@Value("${hashIterations}")
	private int hashIterations;
	
	public void encryptPassword(SysUser sysUser){
		sysUser.setSalt(randomNumberGenerator.nextBytes().toHex());
		String password = new SimpleHash(
				algorithmName,
				sysUser.getPassword(), 
				ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
				hashIterations).toHex();
		sysUser.setPassword(password);
	}

}
