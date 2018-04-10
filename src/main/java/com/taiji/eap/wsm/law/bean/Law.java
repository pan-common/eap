
package com.taiji.eap.wsm.law.bean;

import java.util.Date;
import java.util.List;

import com.taiji.eap.common.file.bean.CommonFileInfo;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Law extends BaseModel{
    private String lawId;//主键
    private String lawTitle;//标题
    private String lawDescribe;//描述
    private String fileId;//文件ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private Long createUser;//创建人

    private CommonFileInfo fileInfo;

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }


    public String getLawTitle() {
        return lawTitle;
    }

    public void setLawTitle(String lawTitle) {
        this.lawTitle = lawTitle;
    }


    public String getLawDescribe() {
        return lawDescribe;
    }

    public void setLawDescribe(String lawDescribe) {
        this.lawDescribe = lawDescribe;
    }


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public CommonFileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(CommonFileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }
}
