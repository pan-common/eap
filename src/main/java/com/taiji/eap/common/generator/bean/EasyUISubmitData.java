package com.taiji.eap.common.generator.bean;

import com.taiji.eap.common.shiro.bean.SysUser;

import java.io.Serializable;
import java.util.List;

public class EasyUISubmitData<T> implements Serializable{

    private static final long serialVersionUID = -4118655686279452970L;

    private List<T> inserted;//新增数据

    private List<T> deleted;//删除数据

    private List<T> updated;//编辑数据

    public EasyUISubmitData(List<T> inserted, List<T> deleted, List<T> updated) {
        this.inserted = inserted;
        this.deleted = deleted;
        this.updated = updated;
    }

    public EasyUISubmitData() {
    }

    public List<T> getInserted() {
        return inserted;
    }

    public void setInserted(List<T> inserted) {
        this.inserted = inserted;
    }

    public List<T> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<T> deleted) {
        this.deleted = deleted;
    }

    public List<T> getUpdated() {
        return updated;
    }

    public void setUpdated(List<T> updated) {
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
