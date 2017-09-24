package com.taiji.eap.common.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.helper.PasswordHelper;

@Controller
@RequestMapping("sysuser")
public class SysUserController extends BaseController{
	
	@Autowired
	private PasswordHelper passwordHelper;
	
	@PostMapping(value="login")
	@ResponseBody
	public Response<String> login(SysUser sysUser){
		
		passwordHelper.encryptPassword(sysUser);
		UsernamePasswordToken token = new UsernamePasswordToken(
				sysUser.getUserName(),
				sysUser.getPassword());
		Subject subject = SecurityUtils.getSubject();
		try {
			if(!subject.isAuthenticated()){
				if(sysUser.getRemember()!=null&&sysUser.getRemember().equals("1")){
					token.setRememberMe(true);
				}
				subject.login(token);
			}
		} catch (UnknownAccountException e) {
			return renderError(e.getMessage());
		} catch (DisabledAccountException e) {
			return renderError(e.getMessage());
		} catch(AuthenticationException e){
			return renderError("用户名或密码错误");
		}
		return renderSuccess("登陆成功");
	}

}
