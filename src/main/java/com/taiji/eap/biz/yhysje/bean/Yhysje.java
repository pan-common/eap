
package com.taiji.eap.biz.yhysje.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Yhysje extends BaseModel{
    private Long id;//主键
    private String hm;//户名
    private String zh;//账号
    private String bz;//币种
    private String kmh;//科目号
    private String dw;//单位
    private String rq;//日期
    private String sj;//时间
    private String zy;//摘要
    private String pzpc;//凭证批次
    private String pzhm;//凭证号码
    private Double jffse;//借方发生额
    private Double dffse;//贷方发生额
    private Double ye;//余额
    private String cph;//传票号
    private String czyh;//操作员
    private String dbbz;//对比标识

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }


    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }


    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


    public String getKmh() {
        return kmh;
    }

    public void setKmh(String kmh) {
        this.kmh = kmh;
    }


    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }


    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }


    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }


    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }


    public String getPzpc() {
        return pzpc;
    }

    public void setPzpc(String pzpc) {
        this.pzpc = pzpc;
    }


    public String getPzhm() {
        return pzhm;
    }

    public void setPzhm(String pzhm) {
        this.pzhm = pzhm;
    }


    public Double getJffse() {
        return jffse;
    }

    public void setJffse(Double jffse) {
        this.jffse = jffse;
    }


    public Double getDffse() {
        return dffse;
    }

    public void setDffse(Double dffse) {
        this.dffse = dffse;
    }


    public Double getYe() {
        return ye;
    }

    public void setYe(Double ye) {
        this.ye = ye;
    }


    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }


    public String getCzyh() {
        return czyh;
    }

    public void setCzyh(String czyh) {
        this.czyh = czyh;
    }


    public String getDbbz() {
        return dbbz;
    }

    public void setDbbz(String dbbz) {
        this.dbbz = dbbz;
    }


}
