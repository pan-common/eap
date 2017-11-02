package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.service.SysUserService;
import com.taiji.eap.common.http.entity.Response;
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
        if(i>0)
            return renderSuccess("提交成功");
        else
            return renderError("提交失败");
    }

    @PostMapping("doLogin")
    @ResponseBody
    public Response<String> doLogin(String userName,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            if(!currentUser.isAuthenticated()){
                token.setRememberMe(false);
                currentUser.login(token);//验证角色和权限
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
            return renderError("未知异常");
        }
        return renderSuccess("登陆成功");
    }

}