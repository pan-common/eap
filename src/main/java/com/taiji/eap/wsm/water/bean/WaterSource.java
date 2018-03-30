package com.taiji.eap.wsm.water.bean;

import com.taiji.eap.common.base.BaseModel;

import java.util.Date;

/**
 * @author 潘宏智
 * @date
 */
public class WaterSource extends BaseModel {

    private static final long serialVersionUID = 2924514872666102806L;
    private String id;//主键
    private String sydmc;//水源地名称
    private String sydbm;//水源地编码
    private String sydlx;//水源地类型
    private String fwrk;//服务人口
    private String sjqsl;//设计取水量
    private String mctj;//埋藏条件
    private String hsjzlx;//含水介质类型
    private String sjjs;//设计降深(m)
    private String swms;//水位埋深
    private String sbdzyxcbdzb;//受天然背景值超标的指标
    private String bz;//备注
    private String scs;//上传省份
    private String scd;//上传地市
    private String excelrow;//excel中行
    private String nd;//年度
    private String uploadfilename;//数据对应的上传文件
    private String sydlxbm;//水源地类型编码
    private String mctjbm;//埋藏条件编码
    private String hsjzlxbm;//含水介质类型编码
    private String shjqsl;//实际取水量（万吨/年）
    private String hbzdcssy;//环保重点城市水源
    private String ycl;//隐藏列
    private String sfkjsy;//是否跨界水源
    private String kjshs;//跨界水源（跨省或跨市）
    private String sssx_gl;//所属水系 干流
    private String sssx_ejzl;//所属水系 二级支流
    private String sssx_sjzl;//所属水系 三级支流
    private String dysc;//对应水厂
    private Date jcsj;//建成时间
    private Date zsqs;//正式取水时间
    private String qssw;//取水水位
    private String sjksw;//设计枯水位
    private String ccsy;//超采水源
    private String sfdb;//是否达标
    private String sysyzt;//水源使用状态
    private String zjhj;//资金合计
    private String syszsdm;//水源所在省代码
    private String syszshdm;//水源所在市代码
    private String syszxdm;//水源所在县代码
    private String syszxmc;//水源所在县名称
    private String datastate;//数据状态（1、县 2、市 3、省  4、国）
    private String datatype;//数据类型（地级上、地级下）
    private String year;//年

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

    public String getFwrk() {
        return fwrk;
    }

    public void setFwrk(String fwrk) {
        this.fwrk = fwrk;
    }

    public String getSjqsl() {
        return sjqsl;
    }

    public void setSjqsl(String sjqsl) {
        this.sjqsl = sjqsl;
    }

    public String getMctj() {
        return mctj;
    }

    public void setMctj(String mctj) {
        this.mctj = mctj;
    }

    public String getHsjzlx() {
        return hsjzlx;
    }

    public void setHsjzlx(String hsjzlx) {
        this.hsjzlx = hsjzlx;
    }

    public String getSjjs() {
        return sjjs;
    }

    public void setSjjs(String sjjs) {
        this.sjjs = sjjs;
    }

    public String getSwms() {
        return swms;
    }

    public void setSwms(String swms) {
        this.swms = swms;
    }

    public String getSbdzyxcbdzb() {
        return sbdzyxcbdzb;
    }

    public void setSbdzyxcbdzb(String sbdzyxcbdzb) {
        this.sbdzyxcbdzb = sbdzyxcbdzb;
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

    public String getUploadfilename() {
        return uploadfilename;
    }

    public void setUploadfilename(String uploadfilename) {
        this.uploadfilename = uploadfilename;
    }

    public String getSydlxbm() {
        return sydlxbm;
    }

    public void setSydlxbm(String sydlxbm) {
        this.sydlxbm = sydlxbm;
    }

    public String getMctjbm() {
        return mctjbm;
    }

    public void setMctjbm(String mctjbm) {
        this.mctjbm = mctjbm;
    }

    public String getHsjzlxbm() {
        return hsjzlxbm;
    }

    public void setHsjzlxbm(String hsjzlxbm) {
        this.hsjzlxbm = hsjzlxbm;
    }

    public String getShjqsl() {
        return shjqsl;
    }

    public void setShjqsl(String shjqsl) {
        this.shjqsl = shjqsl;
    }

    public String getHbzdcssy() {
        return hbzdcssy;
    }

    public void setHbzdcssy(String hbzdcssy) {
        this.hbzdcssy = hbzdcssy;
    }

    public String getYcl() {
        return ycl;
    }

    public void setYcl(String ycl) {
        this.ycl = ycl;
    }

    public String getSfkjsy() {
        return sfkjsy;
    }

    public void setSfkjsy(String sfkjsy) {
        this.sfkjsy = sfkjsy;
    }

    public String getKjshs() {
        return kjshs;
    }

    public void setKjshs(String kjshs) {
        this.kjshs = kjshs;
    }

    public String getSssx_gl() {
        return sssx_gl;
    }

    public void setSssx_gl(String sssx_gl) {
        this.sssx_gl = sssx_gl;
    }

    public String getSssx_ejzl() {
        return sssx_ejzl;
    }

    public void setSssx_ejzl(String sssx_ejzl) {
        this.sssx_ejzl = sssx_ejzl;
    }

    public String getSssx_sjzl() {
        return sssx_sjzl;
    }

    public void setSssx_sjzl(String sssx_sjzl) {
        this.sssx_sjzl = sssx_sjzl;
    }

    public String getDysc() {
        return dysc;
    }

    public void setDysc(String dysc) {
        this.dysc = dysc;
    }

    public Date getJcsj() {
        return jcsj;
    }

    public void setJcsj(Date jcsj) {
        this.jcsj = jcsj;
    }

    public Date getZsqs() {
        return zsqs;
    }

    public void setZsqs(Date zsqs) {
        this.zsqs = zsqs;
    }

    public String getQssw() {
        return qssw;
    }

    public void setQssw(String qssw) {
        this.qssw = qssw;
    }

    public String getSjksw() {
        return sjksw;
    }

    public void setSjksw(String sjksw) {
        this.sjksw = sjksw;
    }

    public String getCcsy() {
        return ccsy;
    }

    public void setCcsy(String ccsy) {
        this.ccsy = ccsy;
    }

    public String getSfdb() {
        return sfdb;
    }

    public void setSfdb(String sfdb) {
        this.sfdb = sfdb;
    }

    public String getSysyzt() {
        return sysyzt;
    }

    public void setSysyzt(String sysyzt) {
        this.sysyzt = sysyzt;
    }

    public String getZjhj() {
        return zjhj;
    }

    public void setZjhj(String zjhj) {
        this.zjhj = zjhj;
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

    public String getDatastate() {
        return datastate;
    }

    public void setDatastate(String datastate) {
        this.datastate = datastate;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
