package com.taiji.eap.wsm.water.bean;

/**
 * 城市饮用水源风险管理能力调查表-地下水
 * @author 潘宏智
 * @date
 */
public class City3_3 {

    private String id;//主键
    private String sydmc;//水源名称
    private String sydbm;//水源代码
    private String sydlx;//地下水类型
    private String czfxy;//存在风险源（是/否）
    private String jlfxyml;//建立风险源名录（是/否）
    private String czsycyYj;//风险管理-一级保护区-存在输油管道（是/否）
    private String czwsgdYj;//风险管理-一级保护区-存在污水管道（是/否）
    private String czjtcyYj;//风险管理-一级保护区-存在交通穿越（是/否）
    private String fxlssYj;//风险管理-一级保护区-防护设施设置-防泄露设施（是/否）
    private String JTJSPYj;//风险管理-一级保护区-防护设施设置-交通警示牌（是/否）
    private String qtYj;//风险管理-一级保护区-防护设施设置-其他
    private String czsygdEj;//风险管理-二级保护区-存在输油管道（是/否）
    private String sygdEj;//风险管理-二级保护区-存在污水管道（是/否）
    private String jtcyEj;//风险管理-二级保护区-存在交通穿越（是/否）
    private String fxlssEj;//风险管理-二级保护区-防护设施设置-防泄露设施（是/否）
    private String jtjspEj;//风险管理-二级保护区-防护设施设置-交通警示牌   （是/否）
    private String qtEj;//风险管理-二级保护区-防护设施设置-其他
    private String hxpyszd;//风险管理-建立危险化学品运输管理制度（是/否）
    private String zjbjqnrbhq;//风险管理-直接补给区纳入保护区（是/否）
    private String yjyabz;//应急能力-突发环境事件应急预案编制、修订与备案（有/无）
    private String yjyl;//应急能力-应急演练（有/无）
    private String ydtfsj;//应急能力-应对重大突发污染事故的物资和技术储备（有/无）
    private String yjfhgc;//应急能力-应急防护工程设施建设（有/无）
    private String yjzjk;//应急能力-应急专家库（有/无）
    private String yjjcnl;//应急能力-应急监测能力（有/无）
    private String bz;//备注
    private String scs;//上传省份
    private String scd;//上传地市
    private String excelrow;//excel中行
    private String nd;//年度
    private String uploadDileName;//数据对应的上传文件
    private String syszsdm;//水源所在省代码
    private String syszshdm;//水源所在市代码
    private String syszxdm;//水源所在县代码
    private String syszxmc;//水源所在县名称
    private String dataState;//数据状态（1、县2、市3、省、4国）
    private String dataType;//数据类型（地级上、地级下）
    private String year;//年
    private String czjtcyYjcyx;//风险管理-一级保护区-存在交通穿越条数
    private String jtcyEjcyx;//风险管理-二级保护区-存在交通穿越条数


    public City3_3() {
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

    public String getCzfxy() {
        return czfxy;
    }

    public void setCzfxy(String czfxy) {
        this.czfxy = czfxy;
    }

    public String getJlfxyml() {
        return jlfxyml;
    }

    public void setJlfxyml(String jlfxyml) {
        this.jlfxyml = jlfxyml;
    }

    public String getCzsycyYj() {
        return czsycyYj;
    }

    public void setCzsycyYj(String czsycyYj) {
        this.czsycyYj = czsycyYj;
    }

    public String getCzwsgdYj() {
        return czwsgdYj;
    }

    public void setCzwsgdYj(String czwsgdYj) {
        this.czwsgdYj = czwsgdYj;
    }

    public String getCzjtcyYj() {
        return czjtcyYj;
    }

    public void setCzjtcyYj(String czjtcyYj) {
        this.czjtcyYj = czjtcyYj;
    }

    public String getFxlssYj() {
        return fxlssYj;
    }

    public void setFxlssYj(String fxlssYj) {
        this.fxlssYj = fxlssYj;
    }

    public String getJTJSPYj() {
        return JTJSPYj;
    }

    public void setJTJSPYj(String JTJSPYj) {
        this.JTJSPYj = JTJSPYj;
    }

    public String getQtYj() {
        return qtYj;
    }

    public void setQtYj(String qtYj) {
        this.qtYj = qtYj;
    }

    public String getCzsygdEj() {
        return czsygdEj;
    }

    public void setCzsygdEj(String czsygdEj) {
        this.czsygdEj = czsygdEj;
    }

    public String getSygdEj() {
        return sygdEj;
    }

    public void setSygdEj(String sygdEj) {
        this.sygdEj = sygdEj;
    }

    public String getJtcyEj() {
        return jtcyEj;
    }

    public void setJtcyEj(String jtcyEj) {
        this.jtcyEj = jtcyEj;
    }

    public String getFxlssEj() {
        return fxlssEj;
    }

    public void setFxlssEj(String fxlssEj) {
        this.fxlssEj = fxlssEj;
    }

    public String getJtjspEj() {
        return jtjspEj;
    }

    public void setJtjspEj(String jtjspEj) {
        this.jtjspEj = jtjspEj;
    }

    public String getQtEj() {
        return qtEj;
    }

    public void setQtEj(String qtEj) {
        this.qtEj = qtEj;
    }

    public String getHxpyszd() {
        return hxpyszd;
    }

    public void setHxpyszd(String hxpyszd) {
        this.hxpyszd = hxpyszd;
    }

    public String getZjbjqnrbhq() {
        return zjbjqnrbhq;
    }

    public void setZjbjqnrbhq(String zjbjqnrbhq) {
        this.zjbjqnrbhq = zjbjqnrbhq;
    }

    public String getYjyabz() {
        return yjyabz;
    }

    public void setYjyabz(String yjyabz) {
        this.yjyabz = yjyabz;
    }

    public String getYjyl() {
        return yjyl;
    }

    public void setYjyl(String yjyl) {
        this.yjyl = yjyl;
    }

    public String getYdtfsj() {
        return ydtfsj;
    }

    public void setYdtfsj(String ydtfsj) {
        this.ydtfsj = ydtfsj;
    }

    public String getYjfhgc() {
        return yjfhgc;
    }

    public void setYjfhgc(String yjfhgc) {
        this.yjfhgc = yjfhgc;
    }

    public String getYjzjk() {
        return yjzjk;
    }

    public void setYjzjk(String yjzjk) {
        this.yjzjk = yjzjk;
    }

    public String getYjjcnl() {
        return yjjcnl;
    }

    public void setYjjcnl(String yjjcnl) {
        this.yjjcnl = yjjcnl;
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

    public String getUploadDileName() {
        return uploadDileName;
    }

    public void setUploadDileName(String uploadDileName) {
        this.uploadDileName = uploadDileName;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCzjtcyYjcyx() {
        return czjtcyYjcyx;
    }

    public void setCzjtcyYjcyx(String czjtcyYjcyx) {
        this.czjtcyYjcyx = czjtcyYjcyx;
    }

    public String getJtcyEjcyx() {
        return jtcyEjcyx;
    }

    public void setJtcyEjcyx(String jtcyEjcyx) {
        this.jtcyEjcyx = jtcyEjcyx;
    }

    @Override
    public String toString() {
        return "City3_3{" +
                "id='" + id + '\'' +
                ", sydmc='" + sydmc + '\'' +
                ", sydbm='" + sydbm + '\'' +
                ", sydlx='" + sydlx + '\'' +
                ", czfxy='" + czfxy + '\'' +
                ", jlfxyml='" + jlfxyml + '\'' +
                ", czsycyYj='" + czsycyYj + '\'' +
                ", czwsgdYj='" + czwsgdYj + '\'' +
                ", czjtcyYj='" + czjtcyYj + '\'' +
                ", fxlssYj='" + fxlssYj + '\'' +
                ", JTJSPYj='" + JTJSPYj + '\'' +
                ", qtYj='" + qtYj + '\'' +
                ", czsygdEj='" + czsygdEj + '\'' +
                ", sygdEj='" + sygdEj + '\'' +
                ", jtcyEj='" + jtcyEj + '\'' +
                ", fxlssEj='" + fxlssEj + '\'' +
                ", jtjspEj='" + jtjspEj + '\'' +
                ", qtEj='" + qtEj + '\'' +
                ", hxpyszd='" + hxpyszd + '\'' +
                ", zjbjqnrbhq='" + zjbjqnrbhq + '\'' +
                ", yjyabz='" + yjyabz + '\'' +
                ", yjyl='" + yjyl + '\'' +
                ", ydtfsj='" + ydtfsj + '\'' +
                ", yjfhgc='" + yjfhgc + '\'' +
                ", yjzjk='" + yjzjk + '\'' +
                ", yjjcnl='" + yjjcnl + '\'' +
                ", bz='" + bz + '\'' +
                ", scs='" + scs + '\'' +
                ", scd='" + scd + '\'' +
                ", excelrow='" + excelrow + '\'' +
                ", nd='" + nd + '\'' +
                ", uploadDileName='" + uploadDileName + '\'' +
                ", syszsdm='" + syszsdm + '\'' +
                ", syszshdm='" + syszshdm + '\'' +
                ", syszxdm='" + syszxdm + '\'' +
                ", syszxmc='" + syszxmc + '\'' +
                ", dataState='" + dataState + '\'' +
                ", dataType='" + dataType + '\'' +
                ", year='" + year + '\'' +
                ", czjtcyYjcyx='" + czjtcyYjcyx + '\'' +
                ", jtcyEjcyx='" + jtcyEjcyx + '\'' +
                '}';
    }
}
