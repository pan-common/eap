package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.service.SysUserService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectUserHandler extends SelectCommonDataSourceHandler<SysUser>{

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected boolean isType(String type) {
        if(type.equals("user"))
            return true;
        else
            return false;
    }

    @Override
    public String getKeyName() {
        return "userId";
    }

    @Override
    public String getValueName() {
        return "userName";
    }

    @Override
    public List<SysUser> getDataSource(String... params) throws Exception {
        return sysUserService.list("");
    }

    @Override
    public Class<SysUser> getDataSourceClass() {
        return SysUser.class;
    }

}
