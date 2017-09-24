package com.taiji.eap.common.dictionary.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 字典表
 */
public class Dictionary extends BaseModel{

    private Long dicId;
    private String keystone;
    private String value;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;
    private String param7;
    private Long parentId;
    private Integer seq;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private String valid;
    private String creater;

    public Dictionary(String keystone, String value) {
        this.keystone = keystone;
        this.value = value;
    }

    public Dictionary(Long dicId, String keystone, String value, String param1, String param2, String param3, String param4, String param5, String param6, String param7, Long parentId, Integer seq, Date createTime, Date updateTime, String valid, String creater) {
        this.dicId = dicId;
        this.keystone = keystone;
        this.value = value;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
        this.param6 = param6;
        this.param7 = param7;
        this.parentId = parentId;
        this.seq = seq;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.valid = valid;
        this.creater = creater;
    }

    public Dictionary() {
    }

    public Long getDicId() {
        return dicId;
    }

    public void setDicId(Long dicId) {
        this.dicId = dicId;
    }

    public String getKeystone() {
        return keystone;
    }

    public void setKeystone(String keystone) {
        this.keystone = keystone;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }

    public String getParam7() {
        return param7;
    }

    public void setParam7(String param7) {
        this.param7 = param7;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dicId=" + dicId +
                ", keystone='" + keystone + '\'' +
                ", value='" + value + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", param3='" + param3 + '\'' +
                ", param4='" + param4 + '\'' +
                ", param5='" + param5 + '\'' +
                ", param6='" + param6 + '\'' +
                ", param7='" + param7 + '\'' +
                ", parentId=" + parentId +
                ", seq=" + seq +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", valid='" + valid + '\'' +
                ", creater='" + creater + '\'' +
                '}';
    }
}
