
package com.taiji.eap.biz.qyjbxx.bean;

import java.util.Date;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Qyjbxx extends BaseModel{
    private Long id;//主键
    private String qybh;//企业编号
    private String qymc;//企业名称
    private Long spiderId;//调用爬虫模块ID
    private String loginName;//登陆名
    private String loginPw;//密码
    private String vId;//当前在用方案ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }


    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }


    public Long getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Long spiderId) {
        this.spiderId = spiderId;
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }
}
