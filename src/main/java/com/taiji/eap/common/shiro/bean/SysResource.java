
package com.taiji.eap.common.shiro.bean;

import java.util.Date;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseTree;
public class SysResource extends BaseTree {
    private Long resourceId;//主键
    private String resourceName;//资源名称
    private Long parentId;//上级资源ID
    @Dictionary(dataSource = "dictionary",params = "23")
    private String typeCode;//资源类型代码
    private String typeDesc;//资源类型描述
    private String resIcon;//资源图标
    private String link;//资源链接
    private Integer seq;//排序
    private String note;//备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private String valid;//删除标识
    private Long creater;//创建人
    public SysResource(Long resourceId,String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public SysResource() {

    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }


    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }


    public String getResIcon() {
        return resIcon;
    }

    public void setResIcon(String resIcon) {
        this.resIcon = resIcon;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }


    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }


}
