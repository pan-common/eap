package com.taiji.eap.common.mybatis.bean;

import java.util.Date;

/**
 * @author 潘宏智
 * @date 2017年12月18日
 */
public class Log {

    private Date createTime;

    private Date modifyTime;

    private String type;

    private String newContent;

    private String oldContent;

    public Log(Date createTime, Date modifyTime, String type, String newContent, String oldContent) {
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.type = type;
        this.newContent = newContent;
        this.oldContent = oldContent;
    }

    public Log() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    @Override
    public String toString() {
        return "Log{" +
                "createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", type='" + type + '\'' +
                ", newContent='" + newContent + '\'' +
                ", oldContent='" + oldContent + '\'' +
                '}';
    }
}
