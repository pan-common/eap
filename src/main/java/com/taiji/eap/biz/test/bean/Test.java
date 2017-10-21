
package com.taiji.eap.biz.test.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Test extends BaseModel{
    private Long id;//主键
    private String jcdw;//监测点位
    private String sfkzjc;//是否开展监测
    private String jcptsfaq;//监测平台是否安全
    private String jcdwsfgf;//监测点位是否规范
    private String jcyz;//监测因子
    private String sgjcsj;//手工监测时间
    private String sgjcjg;//手工监测结果
    private String bzbh;//标准编号
    private String bzxz;//标准限值
    private String sfcb;//是否超标
    private String sfazzxjc;//是否安装在线监测
    private String sflw;//是否联网
    private String tbzxjcjg;//同步在线监测结果

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getJcdw() {
        return jcdw;
    }

    public void setJcdw(String jcdw) {
        this.jcdw = jcdw;
    }


    public String getSfkzjc() {
        return sfkzjc;
    }

    public void setSfkzjc(String sfkzjc) {
        this.sfkzjc = sfkzjc;
    }


    public String getJcptsfaq() {
        return jcptsfaq;
    }

    public void setJcptsfaq(String jcptsfaq) {
        this.jcptsfaq = jcptsfaq;
    }


    public String getJcdwsfgf() {
        return jcdwsfgf;
    }

    public void setJcdwsfgf(String jcdwsfgf) {
        this.jcdwsfgf = jcdwsfgf;
    }


    public String getJcyz() {
        return jcyz;
    }

    public void setJcyz(String jcyz) {
        this.jcyz = jcyz;
    }


    public String getSgjcsj() {
        return sgjcsj;
    }

    public void setSgjcsj(String sgjcsj) {
        this.sgjcsj = sgjcsj;
    }


    public String getSgjcjg() {
        return sgjcjg;
    }

    public void setSgjcjg(String sgjcjg) {
        this.sgjcjg = sgjcjg;
    }


    public String getBzbh() {
        return bzbh;
    }

    public void setBzbh(String bzbh) {
        this.bzbh = bzbh;
    }


    public String getBzxz() {
        return bzxz;
    }

    public void setBzxz(String bzxz) {
        this.bzxz = bzxz;
    }


    public String getSfcb() {
        return sfcb;
    }

    public void setSfcb(String sfcb) {
        this.sfcb = sfcb;
    }


    public String getSfazzxjc() {
        return sfazzxjc;
    }

    public void setSfazzxjc(String sfazzxjc) {
        this.sfazzxjc = sfazzxjc;
    }


    public String getSflw() {
        return sflw;
    }

    public void setSflw(String sflw) {
        this.sflw = sflw;
    }


    public String getTbzxjcjg() {
        return tbzxjcjg;
    }

    public void setTbzxjcjg(String tbzxjcjg) {
        this.tbzxjcjg = tbzxjcjg;
    }


}
