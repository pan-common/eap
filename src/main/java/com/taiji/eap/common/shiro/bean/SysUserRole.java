
package com.taiji.eap.common.shiro.bean;

import com.taiji.eap.common.base.BaseModel;
public class SysUserRole extends BaseModel{
    private static final long serialVersionUID = 8136995355919290660L;
    private Long id;//主键
    private Long userId;//用户ID
    private Long roleId;//角色ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


}
