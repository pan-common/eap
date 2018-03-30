
package com.taiji.eap.biz.jcxmjg.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Jcxmjg extends BaseModel{
    private Long id;//主键
    private Long zxjgId;//在线结果ID
    private String wrwbm;//污染物编码
    private String nd;//浓度
    private String zsnd;//折算浓度
    private String zl;//总量
    private String jcxmbh;//监测项目编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getZxjgId() {
        return zxjgId;
    }

    public void setZxjgId(Long zxjgId) {
        this.zxjgId = zxjgId;
    }


    public String getWrwbm() {
        return wrwbm;
    }

    public void setWrwbm(String wrwbm) {
        this.wrwbm = wrwbm;
    }


    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }


    public String getZsnd() {
        return zsnd;
    }

    public void setZsnd(String zsnd) {
        this.zsnd = zsnd;
    }


    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getJcxmbh() {
        return jcxmbh;
    }

    public void setJcxmbh(String jcxmbh) {
        this.jcxmbh = jcxmbh;
    }
}
