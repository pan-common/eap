
package com.taiji.eap.biz.qyjcxx.bean;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;
import com.taiji.eap.common.base.BaseTree;

@ExcelTarget("qyjcxx")
public class Qyjcxx extends BaseTree {
    @Excel(name = "编号",orderNum = "1",isImportField = "id",width = 20)
    private Long id;//主键ID
    private Long parentId;//
    @Excel(name = "监测日期",orderNum = "2",isImportField = "jcrq",width = 20,mergeVertical = true)
    private String jcrq;//监测日期
    @Excel(name = "省",orderNum = "3",isImportField = "shen",width = 20)
    private String shen;//省
    @Excel(name = "市",orderNum = "4",isImportField = "shi",width = 20)
    private String shi;//市
    @Excel(name = "县",orderNum = "5",isImportField = "xian",width = 20)
    private String xian;//县
    @Excel(name = "企业名称",orderNum = "6",isImportField = "qymc",width = 20)
    private String qymc;//企业名称
    @Excel(name = "行业类型",orderNum = "7",isImportField = "hylx",width = 20)
    private String hylx;//行业类型
    @Dictionary(dataSource = "dictionary",params = "34")
    @Excel(name = "污染防治设施是否正常运行",orderNum = "8",isImportField = "wrfzss",width = 20,replace = {"是_01","否_02"})
    private String wrfzss;//污染防治设施是否正常运行
    @Excel(name = "运行问题描述",orderNum = "9",isImportField = "yxwtms",width = 20)
    private String yxwtms;//运行问题描述
    @Dictionary(dataSource = "dictionary",params = "34")
    @Excel(name = "是否存在数据造假行为",orderNum = "10",isImportField = "sfczsjzj",width = 20,replace = {"是_01","否_02"})
    private String sfczsjzj;//是否存在数据造假行为
    @Excel(name = "造假问题描述",orderNum = "11",isImportField = "zjwtms",width = 20)
    private String zjwtms;//造假问题描述
    @Dictionary(dataSource = "dictionary",params = "34")
    @Excel(name = "是否存在严重跑冒滴漏",orderNum = "12",isImportField = "sfczyzpmdl",width = 20,replace = {"是_01","否_02"})
    private String sfczyzpmdl;//是否存在严重跑冒滴漏
    @Excel(name = "跑冒滴漏问题描述",orderNum = "13",isImportField = "pmdlwtms",width = 20)
    private String pmdlwtms;//跑冒滴漏问题描述
    public Qyjcxx(Long id,String qymc) {
        this.id = id;
        this.qymc = qymc;
    }

    public Qyjcxx() {

    }

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
