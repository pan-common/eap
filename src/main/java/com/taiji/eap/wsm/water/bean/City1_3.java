package com.taiji.eap.wsm.water.bean;

import java.util.Date;

/**
 * 城市饮用水源管理信息
 * @author 潘宏智
 * @date
 */
public class City1_3 {

    private String id;//主键
    private String sydmc;//水源名称
    private String sydbm;//水源编码
    private String sydlx;//水源类型
    private String glcsSydbmgf;//水源地编码规范（是/否）
    private String glcsDaglzd;//档案管理制度（有/无）
    private String glcsDqxj;//定期巡查（有/无）
    private String glcsDqpg;//定期评估（是/否）
    private String glcsXxhglpt;//信息化管理平台（有/无）
    private String glcsXxgkSzsj;//水质数据(是/否)
    private String glcsXxgkGlsj;//管理数据(是/否)
    private String bhqjsqkBhqhfBhqhf;//保护区划分（是/否）
    private Date bhqjsqkBhqhfBhqphsj;//保护区批复时间（年-月）
    private String bhqjsqkBhqhfPfwh;//省政府保护区批复文件（文号）
    private String bhqjsqkBhqmjYj;//一级保护区面积
    private String bhqjsqkBhqmjEj;//二级保护区面积
    private String bhqjsqkBhqmjZhun;//准保护区面积
    private String bhqjsqkWcbhqbzsz;//完成保护区标志设置（是/否）
    private String bhqjsqkYjgfwcbhqbzsz;//是否依据规范完成保护区标志设置（是/否）
    private String bhqjsqkYwcglfhgcl;//应完成的隔离防护工程量（米）
    private String bhqjsqkSjwcglfhgcl;//实际完成的隔离防护工程量（米）
    private String jcjknlWcjczbmc;//完成监测指标名称
    private String jcjknlWcjczbsl;//完成监测指标数量（个）
    private String jcjknlSfykzyjjk;//是否应开展预警监控
    private String jcjknlYwcyjjksl;//应完成的预警监控监测断面数量
    private String jcjknlSjwcjksl;//实际完成预警监控监测断面数量
    private String jcjknlYjjkzbmc;//预警监控指标名称
    private String jcjknlYjjkzbsl;//预警监控指标数量（个）
    private String jcjknlSfykzspjk;//是否应开展视频监控
    private String jcjknlYwcspjksl;//应完成的视频监控监测断面数量
    private String jcjknlSjwcspjksl;//实际完成视频监控监测断面数量
    private String bz;//备注
    private String scs;//上传省份
    private String scd;//上传地市
    private String excelrow;//excel中行
    private String nd;//年度
    private String uploadFileName;//数据对应的上传文件
    private String syszsdm;//水源所在省代码
    private String syszshdm;//水源所在市代码
    private String syszxdm;//水源所在县代码
    private String syszxmc;//水源所在县名称
    private String dataState;//数据状态（1、县2、市3、省、4国）
    private String dataType;//数据类型（地级上、地级下）
    private String bhqjsqkBhqhfPfdw;//批复单位
    private String year;//年

    public City1_3() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSydmc() {
        return sydmc;
    }

    public void setSydmc(String sydmc) {
        this.sydmc = sydmc;
    }

    public String getSydbm() {
        return sydbm;
    }

    public void setSydbm(String sydbm) {
        this.sydbm = sydbm;
    }

    public String getSydlx() {
        return sydlx;
    }

    public void setSydlx(String sydlx) {
        this.sydlx = sydlx;
    }

    public String getGlcsSydbmgf() {
        return glcsSydbmgf;
    }

    public void setGlcsSydbmgf(String glcsSydbmgf) {
        this.glcsSydbmgf = glcsSydbmgf;
    }

    public String getGlcsDaglzd() {
        return glcsDaglzd;
    }

    public void setGlcsDaglzd(String glcsDaglzd) {
        this.glcsDaglzd = glcsDaglzd;
    }

    public String getGlcsDqxj() {
        return glcsDqxj;
    }

    public void setGlcsDqxj(String glcsDqxj) {
        this.glcsDqxj = glcsDqxj;
    }

    public String getGlcsDqpg() {
        return glcsDqpg;
    }

    public void setGlcsDqpg(String glcsDqpg) {
        this.glcsDqpg = glcsDqpg;
    }

    public String getGlcsXxhglpt() {
        return glcsXxhglpt;
    }

    public void setGlcsXxhglpt(String glcsXxhglpt) {
        this.glcsXxhglpt = glcsXxhglpt;
    }

    public String getGlcsXxgkSzsj() {
        return glcsXxgkSzsj;
    }

    public void setGlcsXxgkSzsj(String glcsXxgkSzsj) {
        this.glcsXxgkSzsj = glcsXxgkSzsj;
    }

    public String getGlcsXxgkGlsj() {
        return glcsXxgkGlsj;
    }

    public void setGlcsXxgkGlsj(String glcsXxgkGlsj) {
        this.glcsXxgkGlsj = glcsXxgkGlsj;
    }

    public String getBhqjsqkBhqhfBhqhf() {
        return bhqjsqkBhqhfBhqhf;
    }

    public void setBhqjsqkBhqhfBhqhf(String bhqjsqkBhqhfBhqhf) {
        this.bhqjsqkBhqhfBhqhf = bhqjsqkBhqhfBhqhf;
    }

    public Date getBhqjsqkBhqhfBhqphsj() {
        return bhqjsqkBhqhfBhqphsj;
    }

    public void setBhqjsqkBhqhfBhqphsj(Date bhqjsqkBhqhfBhqphsj) {
        this.bhqjsqkBhqhfBhqphsj = bhqjsqkBhqhfBhqphsj;
    }

    public String getBhqjsqkBhqhfPfwh() {
        return bhqjsqkBhqhfPfwh;
    }

    public void setBhqjsqkBhqhfPfwh(String bhqjsqkBhqhfPfwh) {
        this.bhqjsqkBhqhfPfwh = bhqjsqkBhqhfPfwh;
    }

    public String getBhqjsqkBhqmjYj() {
        return bhqjsqkBhqmjYj;
    }

    public void setBhqjsqkBhqmjYj(String bhqjsqkBhqmjYj) {
        this.bhqjsqkBhqmjYj = bhqjsqkBhqmjYj;
    }

    public String getBhqjsqkBhqmjEj() {
        return bhqjsqkBhqmjEj;
    }

    public void setBhqjsqkBhqmjEj(String bhqjsqkBhqmjEj) {
        this.bhqjsqkBhqmjEj = bhqjsqkBhqmjEj;
    }

    public String getBhqjsqkBhqmjZhun() {
        return bhqjsqkBhqmjZhun;
    }

    public void setBhqjsqkBhqmjZhun(String bhqjsqkBhqmjZhun) {
        this.bhqjsqkBhqmjZhun = bhqjsqkBhqmjZhun;
    }

    public String getBhqjsqkWcbhqbzsz() {
        return bhqjsqkWcbhqbzsz;
    }

    public void setBhqjsqkWcbhqbzsz(String bhqjsqkWcbhqbzsz) {
        this.bhqjsqkWcbhqbzsz = bhqjsqkWcbhqbzsz;
    }

    public String getBhqjsqkYjgfwcbhqbzsz() {
        return bhqjsqkYjgfwcbhqbzsz;
    }

    public void setBhqjsqkYjgfwcbhqbzsz(String bhqjsqkYjgfwcbhqbzsz) {
        this.bhqjsqkYjgfwcbhqbzsz = bhqjsqkYjgfwcbhqbzsz;
    }

    public String getBhqjsqkYwcglfhgcl() {
        return bhqjsqkYwcglfhgcl;
    }

    public void setBhqjsqkYwcglfhgcl(String bhqjsqkYwcglfhgcl) {
        this.bhqjsqkYwcglfhgcl = bhqjsqkYwcglfhgcl;
    }

    public String getBhqjsqkSjwcglfhgcl() {
        return bhqjsqkSjwcglfhgcl;
    }

    public void setBhqjsqkSjwcglfhgcl(String bhqjsqkSjwcglfhgcl) {
        this.bhqjsqkSjwcglfhgcl = bhqjsqkSjwcglfhgcl;
    }

    public String getJcjknlWcjczbmc() {
        return jcjknlWcjczbmc;
    }

    public void setJcjknlWcjczbmc(String jcjknlWcjczbmc) {
        this.jcjknlWcjczbmc = jcjknlWcjczbmc;
    }

    public String getJcjknlWcjczbsl() {
        return jcjknlWcjczbsl;
    }

    public void setJcjknlWcjczbsl(String jcjknlWcjczbsl) {
        this.jcjknlWcjczbsl = jcjknlWcjczbsl;
    }

    public String getJcjknlSfykzyjjk() {
        return jcjknlSfykzyjjk;
    }

    public void setJcjknlSfykzyjjk(String jcjknlSfykzyjjk) {
        this.jcjknlSfykzyjjk = jcjknlSfykzyjjk;
    }

    public String getJcjknlYwcyjjksl() {
        return jcjknlYwcyjjksl;
    }

    public void setJcjknlYwcyjjksl(String jcjknlYwcyjjksl) {
        this.jcjknlYwcyjjksl = jcjknlYwcyjjksl;
    }

    public String getJcjknlSjwcjksl() {
        return jcjknlSjwcjksl;
    }

    public void setJcjknlSjwcjksl(String jcjknlSjwcjksl) {
        this.jcjknlSjwcjksl = jcjknlSjwcjksl;
    }

    public String getJcjknlYjjkzbmc() {
        return jcjknlYjjkzbmc;
    }

    public void setJcjknlYjjkzbmc(String jcjknlYjjkzbmc) {
        this.jcjknlYjjkzbmc = jcjknlYjjkzbmc;
    }

    public String getJcjknlYjjkzbsl() {
        return jcjknlYjjkzbsl;
    }

    public void setJcjknlYjjkzbsl(String jcjknlYjjkzbsl) {
        this.jcjknlYjjkzbsl = jcjknlYjjkzbsl;
    }

    public String getJcjknlSfykzspjk() {
        return jcjknlSfykzspjk;
    }

    public void setJcjknlSfykzspjk(String jcjknlSfykzspjk) {
        this.jcjknlSfykzspjk = jcjknlSfykzspjk;
    }

    public String getJcjknlYwcspjksl() {
        return jcjknlYwcspjksl;
    }

    public void setJcjknlYwcspjksl(String jcjknlYwcspjksl) {
        this.jcjknlYwcspjksl = jcjknlYwcspjksl;
    }

    public String getJcjknlSjwcspjksl() {
        return jcjknlSjwcspjksl;
    }

    public void setJcjknlSjwcspjksl(String jcjknlSjwcspjksl) {
        this.jcjknlSjwcspjksl = jcjknlSjwcspjksl;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getScs() {
        return scs;
    }

    public void setScs(String scs) {
        this.scs = scs;
    }

    public String getScd() {
        return scd;
    }

    public void setScd(String scd) {
        this.scd = scd;
    }

    public String getExcelrow() {
        return excelrow;
    }

    public void setExcelrow(String excelrow) {
        this.excelrow = excelrow;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSyszsdm() {
        return syszsdm;
    }

    public void setSyszsdm(String syszsdm) {
        this.syszsdm = syszsdm;
    }

    public String getSyszshdm() {
        return syszshdm;
    }

    public void setSyszshdm(String syszshdm) {
        this.syszshdm = syszshdm;
    }

    public String getSyszxdm() {
        return syszxdm;
    }

    public void setSyszxdm(String syszxdm) {
        this.syszxdm = syszxdm;
    }

    public String getSyszxmc() {
        return syszxmc;
    }

    public void setSyszxmc(String syszxmc) {
        this.syszxmc = syszxmc;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getBhqjsqkBhqhfPfdw() {
        return bhqjsqkBhqhfPfdw;
    }

    public void setBhqjsqkBhqhfPfdw(String bhqjsqkBhqhfPfdw) {
        this.bhqjsqkBhqhfPfdw = bhqjsqkBhqhfPfdw;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "City1_3{" +
                "id='" + id + '\'' +
                ", sydmc='" + sydmc + '\'' +
                ", sydbm='" + sydbm + '\'' +
                ", sydlx='" + sydlx + '\'' +
                ", glcsSydbmgf='" + glcsSydbmgf + '\'' +
                ", glcsDaglzd='" + glcsDaglzd + '\'' +
                ", glcsDqxj='" + glcsDqxj + '\'' +
                ", glcsDqpg='" + glcsDqpg + '\'' +
                ", glcsXxhglpt='" + glcsXxhglpt + '\'' +
                ", glcsXxgkSzsj='" + glcsXxgkSzsj + '\'' +
                ", glcsXxgkGlsj='" + glcsXxgkGlsj + '\'' +
                ", bhqjsqkBhqhfBhqhf='" + bhqjsqkBhqhfBhqhf + '\'' +
                ", bhqjsqkBhqhfBhqphsj=" + bhqjsqkBhqhfBhqphsj +
                ", bhqjsqkBhqhfPfwh='" + bhqjsqkBhqhfPfwh + '\'' +
                ", bhqjsqkBhqmjYj='" + bhqjsqkBhqmjYj + '\'' +
                ", bhqjsqkBhqmjEj='" + bhqjsqkBhqmjEj + '\'' +
                ", bhqjsqkBhqmjZhun='" + bhqjsqkBhqmjZhun + '\'' +
                ", bhqjsqkWcbhqbzsz='" + bhqjsqkWcbhqbzsz + '\'' +
                ", bhqjsqkYjgfwcbhqbzsz='" + bhqjsqkYjgfwcbhqbzsz + '\'' +
                ", bhqjsqkYwcglfhgcl='" + bhqjsqkYwcglfhgcl + '\'' +
                ", bhqjsqkSjwcglfhgcl='" + bhqjsqkSjwcglfhgcl + '\'' +
                ", jcjknlWcjczbmc='" + jcjknlWcjczbmc + '\'' +
                ", jcjknlWcjczbsl='" + jcjknlWcjczbsl + '\'' +
                ", jcjknlSfykzyjjk='" + jcjknlSfykzyjjk + '\'' +
                ", jcjknlYwcyjjksl='" + jcjknlYwcyjjksl + '\'' +
                ", jcjknlSjwcjksl='" + jcjknlSjwcjksl + '\'' +
                ", jcjknlYjjkzbmc='" + jcjknlYjjkzbmc + '\'' +
                ", jcjknlYjjkzbsl='" + jcjknlYjjkzbsl + '\'' +
                ", jcjknlSfykzspjk='" + jcjknlSfykzspjk + '\'' +
                ", jcjknlYwcspjksl='" + jcjknlYwcspjksl + '\'' +
                ", jcjknlSjwcspjksl='" + jcjknlSjwcspjksl + '\'' +
                ", bz='" + bz + '\'' +
                ", scs='" + scs + '\'' +
                ", scd='" + scd + '\'' +
                ", excelrow='" + excelrow + '\'' +
                ", nd='" + nd + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", syszsdm='" + syszsdm + '\'' +
                ", syszshdm='" + syszshdm + '\'' +
                ", syszxdm='" + syszxdm + '\'' +
                ", syszxmc='" + syszxmc + '\'' +
                ", dataState='" + dataState + '\'' +
                ", dataType='" + dataType + '\'' +
                ", bhqjsqkBhqhfPfdw='" + bhqjsqkBhqhfPfdw + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
