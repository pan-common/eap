package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.bean.SysUserToken;
import com.taiji.eap.common.shiro.exception.HaveLandedException;
import com.taiji.eap.common.shiro.service.SysUserService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.shiro.token.DeviceToken;
import com.taiji.eap.common.utils.UUIDUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<SysUser> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<SysUser> pageInfo = null;
        try {
            pageInfo = sysUserService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @GetMapping("selectAll")
    @ResponseBody
    public List<SysUser> selectAll(){
        List<SysUser> sysUsers = null;
        try {
            sysUsers = sysUserService.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sysUsers;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysUser sysUser){
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setValid("1");
        sysUser.setCreater(1L);
        try {
            int k = sysUserService.insert(sysUser);
            if(k>0){
                return renderSuccess("添加成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Response<String> edit(SysUser sysUser){
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setValid("1");
        sysUser.setCreater(1L);
        try {
            int k = sysUserService.updateByPrimaryKey(sysUser);
            if(k>0){
                return renderSuccess("修改成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Response<String> delete(Long userId){
        try {
            int k = sysUserService.deleteByPrimaryKey(userId);
            if(k>0){
                return renderSuccess("删除成功");
            }else {
                return renderError("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @GetMapping(value = "selectOne")
    @ResponseBody
    public Response<SysUser> selectOne(Long userId){
         try {
            return renderSuccess(sysUserService.selectByPrimaryKey(userId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @PostMapping(value = "easyuiSubmitData")
    @ResponseBody
    public Response<String> easyuiSubmitData(@RequestBody EasyUISubmitData<SysUser> easyUISubmitData){
        int i = sysUserService.easyuiSubmitData(easyUISubmitData);
        if(i>0) {
            return renderSuccess("提交成功");
        } else {
            return renderError("提交失败");
        }
    }

    @PostMapping("doLogin")
    @ResponseBody
    public Response<String> doLogin(String userName,String password,String deviceType){
        DeviceToken token = new DeviceToken(userName,password,deviceType);
        Subject currentUser = SecurityUtils.getSubject();
        boolean isLogin = false;
        try {
            if(!currentUser.isAuthenticated()){
                token.setRememberMe(false);
                //验证角色和权限
                currentUser.login(token);
                isLogin = false;
            }else {
                isLogin = true;
            }
        }catch (UnknownAccountException e) {
            return renderError("未找到用户");
        }catch (IncorrectCredentialsException e){
            return renderError("用户名或密码不正确");
        }catch (LockedAccountException e){
            return renderError("用户被禁止登陆");
        } catch (DisabledAccountException e){
            return renderError("账号未启用");
        } catch (ExcessiveAttemptsException e){
            return renderError("登陆失败超过5次账号已被锁住");
        } catch (HaveLandedException e){
            return renderError("用户已登陆");
        } catch (AuthenticationException e){
            e.printStackTrace();
            return renderError(e.getMessage());
        }
        String tokenId = UUIDUtils.getGUID();
        if(!isLogin){
            SysUserToken sysUserToken = new SysUserToken();
            sysUserToken.setTokenId(tokenId);
            sysUserToken.setUserName(userName);
            sysUserToken.setCreateTime(new Date());
            sysUserToken.setDeviceType(deviceType);
            sysUserService.insertToken(sysUserToken);
        }
        return renderSuccess(tokenId);
    }

    /**
     * 退出登陆
     * @return
     */
    @PostMapping(value = "logout")
    @ResponseBody
    public Response<String> logout(String deviceType){
        Subject subject = SecurityUtils.getSubject();
        //删除用户token
        sysUserService.deleteTokenByUserId(getCurrentUser().getUserName(),deviceType);
        subject.logout();
        return renderSuccess("注销成功");
    }

    /**
     * 强制退出并重新登陆
     * @return
     */
    @PostMapping("forceQuitLoginAgain")
    @ResponseBody
    public Response<String> forceQuitLoginAgain(String userName,String password,String deviceType){
        //删除之前用户的token
        sysUserService.deleteTokenByUserId(userName,deviceType);
        DeviceToken token = new DeviceToken(userName,password,deviceType);
        Subject currentUser = SecurityUtils.getSubject();
        boolean isLogin = false;
        try {
            if(!currentUser.isAuthenticated()){
                token.setRememberMe(false);
                //验证角色和权限
                currentUser.login(token);
                isLogin = false;
            }else {
                isLogin = true;
            }
        }catch (UnknownAccountException e) {
            return renderError("未找到用户");
        }catch (IncorrectCredentialsException e){
            return renderError("用户名或密码不正确");
        }catch (LockedAccountException e){
            return renderError("用户被禁止登陆");
        } catch (DisabledAccountException e){
            return renderError("账号未启用");
        } catch (ExcessiveAttemptsException e){
            return renderError("登陆失败超过5次账号已被锁住");
        } catch (AuthenticationException e){
            e.printStackTrace();
            return renderError(e.getMessage());
        }
        String tokenId = UUIDUtils.getGUID();
        if(!isLogin){
            SysUserToken sysUserToken = new SysUserToken();
            sysUserToken.setTokenId(tokenId);
            sysUserToken.setUserName(userName);
            sysUserToken.setCreateTime(new Date());
            sysUserToken.setDeviceType(deviceType);
            sysUserService.insertToken(sysUserToken);
        }
        return renderSuccess(tokenId);
    }

}