package com.taiji.eap.wsm.water.bean;

/**
 * @author 潘宏智
 * @date
 */
public class City3_2 {

    private String id;//主键
    private String sydmc;//水源名称
    private String sydbm;//水源代码
    private String sydlx;//水源类型
    private String syjzbczfxy;//上游及周边存在风险源（是/否）
    private String jlfxyml;//建立风险源名录（是/否）
    private String czjtcyYj;//风险管理-一级保护区-存在交通穿越（是/否）
    private String jtjspszYj;//风险管理-一级保护区-交通警示牌设置（是/否）
    private String fzhlYj;//风险管理-一级保护区-交通警示牌设置（是/否）
    private String sgdlcYj;//风险管理-一级保护区-防护设施设置-事故导流槽（是/否）
    private String yjcYj;//风险管理-一级保护区-防护设施设置-应急池（是/否）
    private String qtYj;//风险管理-一级保护区-防护设施设置-其他
    private String czjtcyEj;//风险管理-二级保护区-存在交通穿越（是/否）
    private String jtjspszEj;//风险管理-二级保护区-交通警示牌设置（是/否）
    private String fzhlEj;//风险管理-二级保护区-防护设施设置-防撞护栏（是/否）
    private String sgdlcEj;//风险管理-二级保护区-防护设施设置-事故导流槽（是/否）
    private String yjcEj;//风险管理-二级保护区-防护设施设置-应急池（是/否）
    private String qtEj;//风险管理-二级保护区-防护设施设置-其他
    private String jlwxhxpglzd;//风险管理-建立危险化学品运输管理制度（是/否）
    private String tfhjsjya;//应急能力-突发环境事件应急预案编制、修订与备案（有/无）
    private String yjyl;//应急能力-应急演练（有/无）
    private String jscb;//应急能力-应对重大突发污染事故的物资和技术储备（有/无）
    private String shjs;//应急能力-应急防护工程设施建设（有/无）
    private String yjzjk;//应急能力-应急专家库（有/无）
    private String yjjcnl;//应急能力-应急监测能力（有/无）
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
    private String year;//年
    private String czjtcyYts;//风险管理-一级保护区-交通穿越条数
    private String czjtcyEts;//风险管理-二级保护区-交通穿越条数

    public City3_2() {
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

    public String getSyjzbczfxy() {
        return syjzbczfxy;
    }

    public void setSyjzbczfxy(String syjzbczfxy) {
        this.syjzbczfxy = syjzbczfxy;
    }

    public String getJlfxyml() {
        return jlfxyml;
    }

    public void setJlfxyml(String jlfxyml) {
        this.jlfxyml = jlfxyml;
    }

    public String getCzjtcyYj() {
        return czjtcyYj;
    }

    public void setCzjtcyYj(String czjtcyYj) {
        this.czjtcyYj = czjtcyYj;
    }

    public String getJtjspszYj() {
        return jtjspszYj;
    }

    public void setJtjspszYj(String jtjspszYj) {
        this.jtjspszYj = jtjspszYj;
    }

    public String getFzhlYj() {
        return fzhlYj;
    }

    public void setFzhlYj(String fzhlYj) {
        this.fzhlYj = fzhlYj;
    }

    public String getSgdlcYj() {
        return sgdlcYj;
    }

    public void setSgdlcYj(String sgdlcYj) {
        this.sgdlcYj = sgdlcYj;
    }

    public String getYjcYj() {
        return yjcYj;
    }

    public void setYjcYj(String yjcYj) {
        this.yjcYj = yjcYj;
    }

    public String getQtYj() {
        return qtYj;
    }

    public void setQtYj(String qtYj) {
        this.qtYj = qtYj;
    }

    public String getCzjtcyEj() {
        return czjtcyEj;
    }

    public void setCzjtcyEj(String czjtcyEj) {
        this.czjtcyEj = czjtcyEj;
    }

    public String getJtjspszEj() {
        return jtjspszEj;
    }

    public void setJtjspszEj(String jtjspszEj) {
        this.jtjspszEj = jtjspszEj;
    }

    public String getFzhlEj() {
        return fzhlEj;
    }

    public void setFzhlEj(String fzhlEj) {
        this.fzhlEj = fzhlEj;
    }

    public String getSgdlcEj() {
        return sgdlcEj;
    }

    public void setSgdlcEj(String sgdlcEj) {
        this.sgdlcEj = sgdlcEj;
    }

    public String getYjcEj() {
        return yjcEj;
    }

    public void setYjcEj(String yjcEj) {
        this.yjcEj = yjcEj;
    }

    public String getQtEj() {
        return qtEj;
    }

    public void setQtEj(String qtEj) {
        this.qtEj = qtEj;
    }

    public String getJlwxhxpglzd() {
        return jlwxhxpglzd;
    }

    public void setJlwxhxpglzd(String jlwxhxpglzd) {
        this.jlwxhxpglzd = jlwxhxpglzd;
    }

    public String getTfhjsjya() {
        return tfhjsjya;
    }

    public void setTfhjsjya(String tfhjsjya) {
        this.tfhjsjya = tfhjsjya;
    }

    public String getYjyl() {
        return yjyl;
    }

    public void setYjyl(String yjyl) {
        this.yjyl = yjyl;
    }

    public String getJscb() {
        return jscb;
    }

    public void setJscb(String jscb) {
        this.jscb = jscb;
    }

    public String getShjs() {
        return shjs;
    }

    public void setShjs(String shjs) {
        this.shjs = shjs;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCzjtcyYts() {
        return czjtcyYts;
    }

    public void setCzjtcyYts(String czjtcyYts) {
        this.czjtcyYts = czjtcyYts;
    }

    public String getCzjtcyEts() {
        return czjtcyEts;
    }

    public void setCzjtcyEts(String czjtcyEts) {
        this.czjtcyEts = czjtcyEts;
    }

    @Override
    public String toString() {
        return "City3_2{" +
                "id='" + id + '\'' +
                ", sydmc='" + sydmc + '\'' +
                ", sydbm='" + sydbm + '\'' +
                ", sydlx='" + sydlx + '\'' +
                ", syjzbczfxy='" + syjzbczfxy + '\'' +
                ", jlfxyml='" + jlfxyml + '\'' +
                ", czjtcyYj='" + czjtcyYj + '\'' +
                ", jtjspszYj='" + jtjspszYj + '\'' +
                ", fzhlYj='" + fzhlYj + '\'' +
                ", sgdlcYj='" + sgdlcYj + '\'' +
                ", yjcYj='" + yjcYj + '\'' +
                ", qtYj='" + qtYj + '\'' +
                ", czjtcyEj='" + czjtcyEj + '\'' +
                ", jtjspszEj='" + jtjspszEj + '\'' +
                ", fzhlEj='" + fzhlEj + '\'' +
                ", sgdlcEj='" + sgdlcEj + '\'' +
                ", yjcEj='" + yjcEj + '\'' +
                ", qtEj='" + qtEj + '\'' +
                ", jlwxhxpglzd='" + jlwxhxpglzd + '\'' +
                ", tfhjsjya='" + tfhjsjya + '\'' +
                ", yjyl='" + yjyl + '\'' +
                ", jscb='" + jscb + '\'' +
                ", shjs='" + shjs + '\'' +
                ", yjzjk='" + yjzjk + '\'' +
                ", yjjcnl='" + yjjcnl + '\'' +
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
                ", year='" + year + '\'' +
                ", czjtcyYts='" + czjtcyYts + '\'' +
                ", czjtcyEts='" + czjtcyEts + '\'' +
                '}';
    }
}
