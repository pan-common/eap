package com.taiji.eap.common.generator.bean;

import com.taiji.eap.common.shiro.bean.SysUser;

import java.io.Serializable;
import java.util.List;

public class EasyUISubmitData implements Serializable{

    private static final long serialVersionUID = -4118655686279452970L;

    private List<SysUser> inserted;//新增数据

    private List<SysUser> deleted;//删除数据

    private List<SysUser> updated;//编辑数据

    public EasyUISubmitData(List<SysUser> inserted, List<SysUser> deleted, List<SysUser> updated) {
        this.inserted = inserted;
        this.deleted = deleted;
        this.updated = updated;
    }

    public EasyUISubmitData() {
    }

    public List<SysUser> getInserted() {
        return inserted;
    }

    public void setInserted(List<SysUser> inserted) {
        this.inserted = inserted;
    }

    public List<SysUser> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<SysUser> deleted) {
        this.deleted = deleted;
    }

    public List<SysUser> getUpdated() {
        return updated;
    }

    public void setUpdated(List<SysUser> updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "EasyUISubmitData{" +
                "inserted=" + inserted +
                ", deleted=" + deleted +
                ", updated=" + updated +
                '}';
    }
}
