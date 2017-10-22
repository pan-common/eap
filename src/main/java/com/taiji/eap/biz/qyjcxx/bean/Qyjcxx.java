
package com.taiji.eap.biz.qyjcxx.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Qyjcxx extends BaseModel{
    private Long id;//主键ID
    private Long parentId;//
    private String jcrq;//监测日期
    private String shen;//省
    private String shi;//市
    private String xian;//县
    private String qymc;//企业名称
    private String hylx;//行业类型
    private String wrfzss;//污染防治设施是否正常运行
    private String yxwtms;//运行问题描述
    private String sfczsjzj;//是否存在数据造假行为
    private String zjwtms;//造假问题描述
    private String sfczyzpmdl;//是否存在严重跑冒滴漏
    private String pmdlwtms;//跑冒滴漏问题描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getJcrq() {
        return jcrq;
    }

    public void setJcrq(String jcrq) {
        this.jcrq = jcrq;
    }


    public String getShen() {
        return shen;
    }

    public void setShen(String shen) {
        this.shen = shen;
    }


    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }


    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }


    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }


    public String getHylx() {
        return hylx;
    }

    public void setHylx(String hylx) {
        this.hylx = hylx;
    }


    public String getWrfzss() {
        return wrfzss;
    }

    public void setWrfzss(String wrfzss) {
        this.wrfzss = wrfzss;
    }


    public String getYxwtms() {
        return yxwtms;
    }

    public void setYxwtms(String yxwtms) {
        this.yxwtms = yxwtms;
    }


    public String getSfczsjzj() {
        return sfczsjzj;
    }

    public void setSfczsjzj(String sfczsjzj) {
        this.sfczsjzj = sfczsjzj;
    }


    public String getZjwtms() {
        return zjwtms;
    }

    public void setZjwtms(String zjwtms) {
        this.zjwtms = zjwtms;
    }


    public String getSfczyzpmdl() {
        return sfczyzpmdl;
    }

    public void setSfczyzpmdl(String sfczyzpmdl) {
        this.sfczyzpmdl = sfczyzpmdl;
    }


    public String getPmdlwtms() {
        return pmdlwtms;
    }

    public void setPmdlwtms(String pmdlwtms) {
        this.pmdlwtms = pmdlwtms;
    }


}
