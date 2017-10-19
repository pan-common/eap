package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.shiro.bean.SysRole;
import com.taiji.eap.common.shiro.service.SysRoleService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectRoleHandler extends SelectCommonDataSourceHandler<SysRole>{

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("role"))
            return true;
        else
            return false;
    }

    @Override
    public String getKeyName() {
        return "roleId";
    }

    @Override
    public String getValueName() {
        return "name";
    }

    @Override
    public List<SysRole> getDataSource(String... params) throws Exception {
        return sysRoleService.listByPid(Long.valueOf(params[0]));
    }

    @Override
    public Class<SysRole> getDataSourceClass() {
        return SysRole.class;
    }
}
