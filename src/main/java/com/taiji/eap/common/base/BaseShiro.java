package com.taiji.eap.common.base;

import com.taiji.eap.common.shiro.bean.ShiroUser;
import com.taiji.eap.common.shiro.bean.SysUser;
import org.apache.shiro.SecurityUtils;

public class BaseShiro {

    /**
     * 获取当前登录用户信息
     * @return
     */
    protected SysUser getCurrentUser(){
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return sysUser;
    }

}
