

package com.taiji.eap.biz.puriew.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;

public class Puriew extends BaseModel{
    private Long puriewId;//权限ID
    private String name;//权限名称
    private Integer seq;//序号
    private String expression;//权限表达式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private String valid;//是否有效
    private Long creater;//创建人

    public Long getPuriewId() {
        return puriewId;
    }

    public void setPuriewId(Long puriewId) {
        this.puriewId = puriewId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
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
