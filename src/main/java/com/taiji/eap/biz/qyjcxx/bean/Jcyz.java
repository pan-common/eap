package com.taiji.eap.biz.qyjcxx.bean;

import com.taiji.eap.common.easypoi.excel.annotation.Excel;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelId;

public class Jcyz {

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

    private String JCDWID;//监测点位ID
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

    @ExcelId
    @Excel(name = "监测因子",column = "R")
    private String JCYZ;//监测因子
    @Excel(name = "含氧量（%）",column = "V")
    private String HYL;//含氧量
    @Excel(name = "监测起始时间",column = "S")
    private String SGJCSJ_QS;//手工采集时间 起始
    @Excel(name = "监测结束时间",column = "T")
    private String SGJCSJ_JS;//手工采集时间 结束
    @Excel(name = "标干监测结果（mg/m3）",column = "U")
    private String SGJCJG;//手工检测结果
    @Excel(name = "标准编号",column = "X")
    private String BZBH;//标准编号
    @Excel(name = "标准限值（mg/m3）",column = "Z")
    private String BZXZ;//标准限值
    private String BZXZ_SX;//标准上限
    private String BZXZ_XX;//标准下限
    @Excel(name = "是否超标",column = "AA")
    private String SFCB;//是否超标
    @Excel(name = "是否安装在线监测",column = "AB")
    private String SFAZZX;//是否安装在线监测
    @Excel(name = "未安装说明",column = "AC")
    private String SFAZZXBZ;//是否安装在线监测设备
    @Excel(name = "是否联网",column = "AD")
    private String SFLW;//是否联网
    @Excel(name = "未联网说明",column = "AE")
    private String SFLWBZ;//是否联网备注
    private String PCID;
    private String ROCK;//锁定标识
    private String GXSJ;//最后更新时间
    @Excel(name = "折算监测结果（mg/m3)",column = "W")
    private String SGJCJG_ZS;//手工折算结果
    @Excel(name = "同步在线监测含氧量（%）",column = "AG")
    private String ZXHYL;//同步在线含氧量
    @Excel(name = "同步在线监测标干浓度（mg/m3）",column = "AF")
    private String ZXJG;//同步在线结果
    @Excel(name = "同步在线监测折算浓度（mg/m3）",column = "AH")
    private String ZXJG_ZS;//同步在线折算结果
    @Excel(name = "标准名称",column = "Y")
    private String BZMC;//标准名称

    public Jcyz() {
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

    public String getJCDWID() {
        return JCDWID;
    }

    public void setJCDWID(String JCDWID) {
        this.JCDWID = JCDWID;
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

    public String getSFAQ() {
        return SFAQ;
    }

    public void setSFAQ(String SFAQ) {
        this.SFAQ = SFAQ;
    }

    public String getSFGF() {
        return SFGF;
    }

    public void setSFGF(String SFGF) {
        this.SFGF = SFGF;
    }

    public String getJCYZ() {
        return JCYZ;
    }

    public void setJCYZ(String JCYZ) {
        this.JCYZ = JCYZ;
    }

    public String getHYL() {
        return HYL;
    }

    public void setHYL(String HYL) {
        this.HYL = HYL;
    }

    public String getSGJCSJ_QS() {
        return SGJCSJ_QS;
    }

    public void setSGJCSJ_QS(String SGJCSJ_QS) {
        this.SGJCSJ_QS = SGJCSJ_QS;
    }

    public String getSGJCSJ_JS() {
        return SGJCSJ_JS;
    }

    public void setSGJCSJ_JS(String SGJCSJ_JS) {
        this.SGJCSJ_JS = SGJCSJ_JS;
    }

    public String getSGJCJG() {
        return SGJCJG;
    }

    public void setSGJCJG(String SGJCJG) {
        this.SGJCJG = SGJCJG;
    }

    public String getBZBH() {
        return BZBH;
    }

    public void setBZBH(String BZBH) {
        this.BZBH = BZBH;
    }

    public String getBZXZ() {
        return BZXZ;
    }

    public void setBZXZ(String BZXZ) {
        this.BZXZ = BZXZ;
    }

    public String getBZXZ_SX() {
        return BZXZ_SX;
    }

    public void setBZXZ_SX(String BZXZ_SX) {
        this.BZXZ_SX = BZXZ_SX;
    }

    public String getBZXZ_XX() {
        return BZXZ_XX;
    }

    public void setBZXZ_XX(String BZXZ_XX) {
        this.BZXZ_XX = BZXZ_XX;
    }

    public String getSFCB() {
        return SFCB;
    }

    public void setSFCB(String SFCB) {
        this.SFCB = SFCB;
    }

    public String getSFAZZX() {
        return SFAZZX;
    }

    public void setSFAZZX(String SFAZZX) {
        this.SFAZZX = SFAZZX;
    }

    public String getSFAZZXBZ() {
        return SFAZZXBZ;
    }

    public void setSFAZZXBZ(String SFAZZXBZ) {
        this.SFAZZXBZ = SFAZZXBZ;
    }

    public String getSFLW() {
        return SFLW;
    }

    public void setSFLW(String SFLW) {
        this.SFLW = SFLW;
    }

    public String getSFLWBZ() {
        return SFLWBZ;
    }

    public void setSFLWBZ(String SFLWBZ) {
        this.SFLWBZ = SFLWBZ;
    }

    public String getPCID() {
        return PCID;
    }

    public void setPCID(String PCID) {
        this.PCID = PCID;
    }

    public String getROCK() {
        return ROCK;
    }

    public void setROCK(String ROCK) {
        this.ROCK = ROCK;
    }

    public String getGXSJ() {
        return GXSJ;
    }

    public void setGXSJ(String GXSJ) {
        this.GXSJ = GXSJ;
    }

    public String getSFKZJCMS() {
        return SFKZJCMS;
    }

    public void setSFKZJCMS(String SFKZJCMS) {
        this.SFKZJCMS = SFKZJCMS;
    }

    public String getSFAQMS() {
        return SFAQMS;
    }

    public void setSFAQMS(String SFAQMS) {
        this.SFAQMS = SFAQMS;
    }

    public String getSFGFMS() {
        return SFGFMS;
    }

    public void setSFGFMS(String SFGFMS) {
        this.SFGFMS = SFGFMS;
    }

    public String getSGJCJG_ZS() {
        return SGJCJG_ZS;
    }

    public void setSGJCJG_ZS(String SGJCJG_ZS) {
        this.SGJCJG_ZS = SGJCJG_ZS;
    }

    public String getZXHYL() {
        return ZXHYL;
    }

    public void setZXHYL(String ZXHYL) {
        this.ZXHYL = ZXHYL;
    }

    public String getZXJG() {
        return ZXJG;
    }

    public void setZXJG(String ZXJG) {
        this.ZXJG = ZXJG;
    }

    public String getZXJG_ZS() {
        return ZXJG_ZS;
    }

    public void setZXJG_ZS(String ZXJG_ZS) {
        this.ZXJG_ZS = ZXJG_ZS;
    }

    public String getBZMC() {
        return BZMC;
    }

    public void setBZMC(String BZMC) {
        this.BZMC = BZMC;
    }

    @Override
    public String toString() {
        return "Jcyz{" +
                "SJID='" + SJID + '\'' +
                ", JCRQ='" + JCRQ + '\'' +
                ", TBRID='" + TBRID + '\'' +
                ", TBRNAME='" + TBRNAME + '\'' +
                ", TBSJ='" + TBSJ + '\'' +
                ", SHENG='" + SHENG + '\'' +
                ", SHI='" + SHI + '\'' +
                ", XIAN='" + XIAN + '\'' +
                ", SHENGNAME='" + SHENGNAME + '\'' +
                ", SHINAME='" + SHINAME + '\'' +
                ", XIANNAME='" + XIANNAME + '\'' +
                ", QYID='" + QYID + '\'' +
                ", QYMC='" + QYMC + '\'' +
                ", HYLX='" + HYLX + '\'' +
                ", FZSSSFZC='" + FZSSSFZC + '\'' +
                ", FZSSSWTMS='" + FZSSSWTMS + '\'' +
                ", SFZJ='" + SFZJ + '\'' +
                ", SFZJMS='" + SFZJMS + '\'' +
                ", SFPMDL='" + SFPMDL + '\'' +
                ", SFPMDLMS='" + SFPMDLMS + '\'' +
                ", SFYCB='" + SFYCB + '\'' +
                ", SFBD='" + SFBD + '\'' +
                ", SFTC='" + SFTC + '\'' +
                ", JCDWID='" + JCDWID + '\'' +
                ", JCDW='" + JCDW + '\'' +
                ", SFKZJC='" + SFKZJC + '\'' +
                ", SFAQ='" + SFAQ + '\'' +
                ", SFGF='" + SFGF + '\'' +
                ", JCYZ='" + JCYZ + '\'' +
                ", HYL='" + HYL + '\'' +
                ", SGJCSJ_QS='" + SGJCSJ_QS + '\'' +
                ", SGJCSJ_JS='" + SGJCSJ_JS + '\'' +
                ", SGJCJG='" + SGJCJG + '\'' +
                ", BZBH='" + BZBH + '\'' +
                ", BZXZ='" + BZXZ + '\'' +
                ", BZXZ_SX='" + BZXZ_SX + '\'' +
                ", BZXZ_XX='" + BZXZ_XX + '\'' +
                ", SFCB='" + SFCB + '\'' +
                ", SFAZZX='" + SFAZZX + '\'' +
                ", SFAZZXBZ='" + SFAZZXBZ + '\'' +
                ", SFLW='" + SFLW + '\'' +
                ", SFLWBZ='" + SFLWBZ + '\'' +
                ", PCID='" + PCID + '\'' +
                ", ROCK='" + ROCK + '\'' +
                ", GXSJ='" + GXSJ + '\'' +
                ", SFKZJCMS='" + SFKZJCMS + '\'' +
                ", SFAQMS='" + SFAQMS + '\'' +
                ", SFGFMS='" + SFGFMS + '\'' +
                ", SGJCJG_ZS='" + SGJCJG_ZS + '\'' +
                ", ZXHYL='" + ZXHYL + '\'' +
                ", ZXJG='" + ZXJG + '\'' +
                ", ZXJG_ZS='" + ZXJG_ZS + '\'' +
                ", BZMC='" + BZMC + '\'' +
                '}';
    }
}
