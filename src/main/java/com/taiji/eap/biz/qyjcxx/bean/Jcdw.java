package com.taiji.eap.biz.qyjcxx.bean;

import com.taiji.eap.common.easypoi.excel.annotation.Excel;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelId;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelList;

import java.util.ArrayList;
import java.util.List;

public class Jcdw {

    private String SJID;
    private String JCBID;//上级表ID
    @ExcelId
    @Excel(name = "监测点位",column = "M")
    private String JCDW;//监测点位
    @Excel(name = "是否开展监测",column = "N")
    private String SFKZJC;//是否开展监测
    private String SFKZJCMS;//是否展开监测描述
    private String SFAQ;//检测平台是否安全
    private String SFAQMS;//检测平台是否安全描述
    @Excel(name = "监测点位是否规范",column = "P")
    private String SFGF;//监测点位是否规范
    private String SFGFMS;//监测点位是否规范描述
    @ExcelList
    private List<Jcyz> jcyzs = new ArrayList<>();

    public Jcdw() {
    }

    public String getSJID() {
        return SJID;
    }

    public void setSJID(String SJID) {
        this.SJID = SJID;
    }

    public String getJCBID() {
        return JCBID;
    }

    public void setJCBID(String JCBID) {
        this.JCBID = JCBID;
    }

    public String getJCDW() {
        return JCDW;
    }

    public void setJCDW(String JCDW) {
        this.JCDW = JCDW;
    }

    public String getSFKZJC() {
        return SFKZJC;
    }

    public void setSFKZJC(String SFKZJC) {
        this.SFKZJC = SFKZJC;
    }

    public String getSFKZJCMS() {
        return SFKZJCMS;
    }

    public void setSFKZJCMS(String SFKZJCMS) {
        this.SFKZJCMS = SFKZJCMS;
    }

    public String getSFAQ() {
        return SFAQ;
    }

    public void setSFAQ(String SFAQ) {
        this.SFAQ = SFAQ;
    }

    public String getSFAQMS() {
        return SFAQMS;
    }

    public void setSFAQMS(String SFAQMS) {
        this.SFAQMS = SFAQMS;
    }

    public String getSFGF() {
        return SFGF;
    }

    public void setSFGF(String SFGF) {
        this.SFGF = SFGF;
    }

    public String getSFGFMS() {
        return SFGFMS;
    }

    public void setSFGFMS(String SFGFMS) {
        this.SFGFMS = SFGFMS;
    }

    public List<Jcyz> getJcyzs() {
        return jcyzs;
    }

    public void setJcyzs(List<Jcyz> jcyzs) {
        this.jcyzs = jcyzs;
    }
}
