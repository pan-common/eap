package com.taiji.eap.biz.qyjcxx.bean;

import com.taiji.eap.common.easypoi.excel.annotation.Excel;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelId;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelList;
import com.taiji.eap.common.excle.annotation.ExcelAttribute;
import com.taiji.eap.common.excle.annotation.ExcelElement;
import com.taiji.eap.common.excle.annotation.ExcelID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZfjcJcqk implements Serializable{

    private static final long serialVersionUID = 7978348086575199998L;

    private String SJID;
    @ExcelId
    @Excel(name = "检查日期",column = "A")
    private String JCRQ;//检查日期
    private String TBRID;//填报人ID
    private String TBRNAME;//填报人名称
    private String TBSJ;//填报时间
    private String SHENG;//省
    private String SHI;//市
    private String XIAN;//县
    @Excel(name = "省（市）",column = "B")
    private String SHENGNAME;//省名称
    @Excel(name = "市",column = "C")
    private String SHINAME;//市名称
    @Excel(name = "县（区）",column = "D")
    private String XIANNAME;//县名称
    private String QYID;//企业ID
    @Excel(name = "企业名称",column = "E")
    private String QYMC;//企业名称
    @Excel(name = "行业类型",column = "F")
    private String HYLX;//行业类型
    @Excel(name = "污染防治设施是否正常运行",column = "G")
    private String FZSSSFZC;//污染防治设施是否正常运行
    @Excel(name = "运行问题描述",column = "H")
    private String FZSSSWTMS;//运行问题描述
    @Excel(name = "是否存在数据造假行为",column = "I")
    private String SFZJ;//是否存在数据造假行为
    @Excel(name = "造假问题描述",column = "J")
    private String SFZJMS;//造假问题描述
    @Excel(name = "是否存在严重跑冒滴漏",column = "K")
    private String SFPMDL;//是否存在严重跑冒滴漏
    @Excel(name = "跑冒滴漏问题描述",column = "L")
    private String SFPMDLMS;//跑冒滴漏问题描述
    private String SFYCB;//是否超标
    private String SFBD;//是否对比数据
    private String SFTC;//是否停产
    private String PCID;
    @ExcelList
    private List<Jcdw> jcdws = new ArrayList<>();

    public ZfjcJcqk() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSJID() {
        return SJID;
    }

    public void setSJID(String SJID) {
        this.SJID = SJID;
    }

    public String getJCRQ() {
        return JCRQ;
    }

    public void setJCRQ(String JCRQ) {
        this.JCRQ = JCRQ;
    }

    public String getTBRID() {
        return TBRID;
    }

    public void setTBRID(String TBRID) {
        this.TBRID = TBRID;
    }

    public String getTBRNAME() {
        return TBRNAME;
    }

    public void setTBRNAME(String TBRNAME) {
        this.TBRNAME = TBRNAME;
    }

    public String getTBSJ() {
        return TBSJ;
    }

    public void setTBSJ(String TBSJ) {
        this.TBSJ = TBSJ;
    }

    public String getSHENG() {
        return SHENG;
    }

    public void setSHENG(String SHENG) {
        this.SHENG = SHENG;
    }

    public String getSHI() {
        return SHI;
    }

    public void setSHI(String SHI) {
        this.SHI = SHI;
    }

    public String getXIAN() {
        return XIAN;
    }

    public void setXIAN(String XIAN) {
        this.XIAN = XIAN;
    }

    public String getSHENGNAME() {
        return SHENGNAME;
    }

    public void setSHENGNAME(String SHENGNAME) {
        this.SHENGNAME = SHENGNAME;
    }

    public String getSHINAME() {
        return SHINAME;
    }

    public void setSHINAME(String SHINAME) {
        this.SHINAME = SHINAME;
    }

    public String getXIANNAME() {
        return XIANNAME;
    }

    public void setXIANNAME(String XIANNAME) {
        this.XIANNAME = XIANNAME;
    }

    public String getQYID() {
        return QYID;
    }

    public void setQYID(String QYID) {
        this.QYID = QYID;
    }

    public String getQYMC() {
        return QYMC;
    }

    public void setQYMC(String QYMC) {
        this.QYMC = QYMC;
    }

    public String getHYLX() {
        return HYLX;
    }

    public void setHYLX(String HYLX) {
        this.HYLX = HYLX;
    }

    public String getFZSSSFZC() {
        return FZSSSFZC;
    }

    public void setFZSSSFZC(String FZSSSFZC) {
        this.FZSSSFZC = FZSSSFZC;
    }

    public String getFZSSSWTMS() {
        return FZSSSWTMS;
    }

    public void setFZSSSWTMS(String FZSSSWTMS) {
        this.FZSSSWTMS = FZSSSWTMS;
    }

    public String getSFZJ() {
        return SFZJ;
    }

    public void setSFZJ(String SFZJ) {
        this.SFZJ = SFZJ;
    }

    public String getSFZJMS() {
        return SFZJMS;
    }

    public void setSFZJMS(String SFZJMS) {
        this.SFZJMS = SFZJMS;
    }

    public String getSFPMDL() {
        return SFPMDL;
    }

    public void setSFPMDL(String SFPMDL) {
        this.SFPMDL = SFPMDL;
    }

    public String getSFPMDLMS() {
        return SFPMDLMS;
    }

    public void setSFPMDLMS(String SFPMDLMS) {
        this.SFPMDLMS = SFPMDLMS;
    }

    public String getSFYCB() {
        return SFYCB;
    }

    public void setSFYCB(String SFYCB) {
        this.SFYCB = SFYCB;
    }

    public String getSFBD() {
        return SFBD;
    }

    public void setSFBD(String SFBD) {
        this.SFBD = SFBD;
    }

    public String getSFTC() {
        return SFTC;
    }

    public void setSFTC(String SFTC) {
        this.SFTC = SFTC;
    }

    public String getPCID() {
        return PCID;
    }

    public void setPCID(String PCID) {
        this.PCID = PCID;
    }

    public List<Jcdw> getJcdws() {
        return jcdws;
    }

    public void setJcdws(List<Jcdw> jcdws) {
        this.jcdws = jcdws;
    }
}
