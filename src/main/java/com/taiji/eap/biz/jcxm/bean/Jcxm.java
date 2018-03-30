
package com.taiji.eap.biz.jcxm.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Jcxm extends BaseModel{
    private Long jcxmId;//监测项目ID
    private String qybh;//企业编号
    private String jcdbh;//监测点编号
    private String jcxmmc;//监测项目名称
    private String jcxmbh;//监测项目编号
    private String wrwbm;//污染物编号

    public Long getJcxmId() {
        return jcxmId;
    }

    public void setJcxmId(Long jcxmId) {
        this.jcxmId = jcxmId;
    }


    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }


    public String getJcdbh() {
        return jcdbh;
    }

    public void setJcdbh(String jcdbh) {
        this.jcdbh = jcdbh;
    }


    public String getJcxmmc() {
        return jcxmmc;
    }

    public void setJcxmmc(String jcxmmc) {
        this.jcxmmc = jcxmmc;
    }


    public String getJcxmbh() {
        return jcxmbh;
    }

    public void setJcxmbh(String jcxmbh) {
        this.jcxmbh = jcxmbh;
    }


    public String getWrwbm() {
        return wrwbm;
    }

    public void setWrwbm(String wrwbm) {
        this.wrwbm = wrwbm;
    }


}
