package com.taiji.eap.wsm.water.bean;

import java.io.Serializable;

/**
 * @author 
 */
public class City3_1 implements Serializable {
    private String id;

    private String csmc;

    private String yysyslDbs;

    private String yysyslDxs;

    private String czfxydsysl;

    private String sjjlfxymldsysl;

    private String bhqczjtcysl;

    private String sjjlwxhxpsl;

    private String bysy;

    private String lwgs;

    private String fssywrsgsl;

    private String yxczsywrsl;

    private String bz;

    private String scs;

    private String scd;

    private String excelrow;

    private String nd;

    private String uploadfilename;

    private String syszsdm;

    private String syszshdm;

    private String syszxdm;

    private String syszxmc;

    private String datastate;

    private String datatype;

    private String csbm;

    private String calstate;

    private String year;

    private String yjJtcys;

    private String ejJtcys;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc;
    }

    public String getYysyslDbs() {
        return yysyslDbs;
    }

    public void setYysyslDbs(String yysyslDbs) {
        this.yysyslDbs = yysyslDbs;
    }

    public String getYysyslDxs() {
        return yysyslDxs;
    }

    public void setYysyslDxs(String yysyslDxs) {
        this.yysyslDxs = yysyslDxs;
    }

    public String getCzfxydsysl() {
        return czfxydsysl;
    }

    public void setCzfxydsysl(String czfxydsysl) {
        this.czfxydsysl = czfxydsysl;
    }

    public String getSjjlfxymldsysl() {
        return sjjlfxymldsysl;
    }

    public void setSjjlfxymldsysl(String sjjlfxymldsysl) {
        this.sjjlfxymldsysl = sjjlfxymldsysl;
    }

    public String getBhqczjtcysl() {
        return bhqczjtcysl;
    }

    public void setBhqczjtcysl(String bhqczjtcysl) {
        this.bhqczjtcysl = bhqczjtcysl;
    }

    public String getSjjlwxhxpsl() {
        return sjjlwxhxpsl;
    }

    public void setSjjlwxhxpsl(String sjjlwxhxpsl) {
        this.sjjlwxhxpsl = sjjlwxhxpsl;
    }

    public String getBysy() {
        return bysy;
    }

    public void setBysy(String bysy) {
        this.bysy = bysy;
    }

    public String getLwgs() {
        return lwgs;
    }

    public void setLwgs(String lwgs) {
        this.lwgs = lwgs;
    }

    public String getFssywrsgsl() {
        return fssywrsgsl;
    }

    public void setFssywrsgsl(String fssywrsgsl) {
        this.fssywrsgsl = fssywrsgsl;
    }

    public String getYxczsywrsl() {
        return yxczsywrsl;
    }

    public void setYxczsywrsl(String yxczsywrsl) {
        this.yxczsywrsl = yxczsywrsl;
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

    public String getCsbm() {
        return csbm;
    }

    public void setCsbm(String csbm) {
        this.csbm = csbm;
    }

    public String getCalstate() {
        return calstate;
    }

    public void setCalstate(String calstate) {
        this.calstate = calstate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYjJtcys() {
        return yjJtcys;
    }

    public void setYjJtcys(String yjJtcys) {
        this.yjJtcys = yjJtcys;
    }

    public String getEjJtcys() {
        return ejJtcys;
    }

    public void setEjJtcys(String ejJtcys) {
        this.ejJtcys = ejJtcys;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        City3_1 other = (City3_1) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCsmc() == null ? other.getCsmc() == null : this.getCsmc().equals(other.getCsmc()))
            && (this.getYysyslDbs() == null ? other.getYysyslDbs() == null : this.getYysyslDbs().equals(other.getYysyslDbs()))
            && (this.getYysyslDxs() == null ? other.getYysyslDxs() == null : this.getYysyslDxs().equals(other.getYysyslDxs()))
            && (this.getCzfxydsysl() == null ? other.getCzfxydsysl() == null : this.getCzfxydsysl().equals(other.getCzfxydsysl()))
            && (this.getSjjlfxymldsysl() == null ? other.getSjjlfxymldsysl() == null : this.getSjjlfxymldsysl().equals(other.getSjjlfxymldsysl()))
            && (this.getBhqczjtcysl() == null ? other.getBhqczjtcysl() == null : this.getBhqczjtcysl().equals(other.getBhqczjtcysl()))
            && (this.getSjjlwxhxpsl() == null ? other.getSjjlwxhxpsl() == null : this.getSjjlwxhxpsl().equals(other.getSjjlwxhxpsl()))
            && (this.getBysy() == null ? other.getBysy() == null : this.getBysy().equals(other.getBysy()))
            && (this.getLwgs() == null ? other.getLwgs() == null : this.getLwgs().equals(other.getLwgs()))
            && (this.getFssywrsgsl() == null ? other.getFssywrsgsl() == null : this.getFssywrsgsl().equals(other.getFssywrsgsl()))
            && (this.getYxczsywrsl() == null ? other.getYxczsywrsl() == null : this.getYxczsywrsl().equals(other.getYxczsywrsl()))
            && (this.getBz() == null ? other.getBz() == null : this.getBz().equals(other.getBz()))
            && (this.getScs() == null ? other.getScs() == null : this.getScs().equals(other.getScs()))
            && (this.getScd() == null ? other.getScd() == null : this.getScd().equals(other.getScd()))
            && (this.getExcelrow() == null ? other.getExcelrow() == null : this.getExcelrow().equals(other.getExcelrow()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getUploadfilename() == null ? other.getUploadfilename() == null : this.getUploadfilename().equals(other.getUploadfilename()))
            && (this.getSyszsdm() == null ? other.getSyszsdm() == null : this.getSyszsdm().equals(other.getSyszsdm()))
            && (this.getSyszshdm() == null ? other.getSyszshdm() == null : this.getSyszshdm().equals(other.getSyszshdm()))
            && (this.getSyszxdm() == null ? other.getSyszxdm() == null : this.getSyszxdm().equals(other.getSyszxdm()))
            && (this.getSyszxmc() == null ? other.getSyszxmc() == null : this.getSyszxmc().equals(other.getSyszxmc()))
            && (this.getDatastate() == null ? other.getDatastate() == null : this.getDatastate().equals(other.getDatastate()))
            && (this.getDatatype() == null ? other.getDatatype() == null : this.getDatatype().equals(other.getDatatype()))
            && (this.getCsbm() == null ? other.getCsbm() == null : this.getCsbm().equals(other.getCsbm()))
            && (this.getCalstate() == null ? other.getCalstate() == null : this.getCalstate().equals(other.getCalstate()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getYjJtcys() == null ? other.getYjJtcys() == null : this.getYjJtcys().equals(other.getYjJtcys()))
            && (this.getEjJtcys() == null ? other.getEjJtcys() == null : this.getEjJtcys().equals(other.getEjJtcys()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCsmc() == null) ? 0 : getCsmc().hashCode());
        result = prime * result + ((getYysyslDbs() == null) ? 0 : getYysyslDbs().hashCode());
        result = prime * result + ((getYysyslDxs() == null) ? 0 : getYysyslDxs().hashCode());
        result = prime * result + ((getCzfxydsysl() == null) ? 0 : getCzfxydsysl().hashCode());
        result = prime * result + ((getSjjlfxymldsysl() == null) ? 0 : getSjjlfxymldsysl().hashCode());
        result = prime * result + ((getBhqczjtcysl() == null) ? 0 : getBhqczjtcysl().hashCode());
        result = prime * result + ((getSjjlwxhxpsl() == null) ? 0 : getSjjlwxhxpsl().hashCode());
        result = prime * result + ((getBysy() == null) ? 0 : getBysy().hashCode());
        result = prime * result + ((getLwgs() == null) ? 0 : getLwgs().hashCode());
        result = prime * result + ((getFssywrsgsl() == null) ? 0 : getFssywrsgsl().hashCode());
        result = prime * result + ((getYxczsywrsl() == null) ? 0 : getYxczsywrsl().hashCode());
        result = prime * result + ((getBz() == null) ? 0 : getBz().hashCode());
        result = prime * result + ((getScs() == null) ? 0 : getScs().hashCode());
        result = prime * result + ((getScd() == null) ? 0 : getScd().hashCode());
        result = prime * result + ((getExcelrow() == null) ? 0 : getExcelrow().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getUploadfilename() == null) ? 0 : getUploadfilename().hashCode());
        result = prime * result + ((getSyszsdm() == null) ? 0 : getSyszsdm().hashCode());
        result = prime * result + ((getSyszshdm() == null) ? 0 : getSyszshdm().hashCode());
        result = prime * result + ((getSyszxdm() == null) ? 0 : getSyszxdm().hashCode());
        result = prime * result + ((getSyszxmc() == null) ? 0 : getSyszxmc().hashCode());
        result = prime * result + ((getDatastate() == null) ? 0 : getDatastate().hashCode());
        result = prime * result + ((getDatatype() == null) ? 0 : getDatatype().hashCode());
        result = prime * result + ((getCsbm() == null) ? 0 : getCsbm().hashCode());
        result = prime * result + ((getCalstate() == null) ? 0 : getCalstate().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getYjJtcys() == null) ? 0 : getYjJtcys().hashCode());
        result = prime * result + ((getEjJtcys() == null) ? 0 : getEjJtcys().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", csmc=").append(csmc);
        sb.append(", yysyslDbs=").append(yysyslDbs);
        sb.append(", yysyslDxs=").append(yysyslDxs);
        sb.append(", czfxydsysl=").append(czfxydsysl);
        sb.append(", sjjlfxymldsysl=").append(sjjlfxymldsysl);
        sb.append(", bhqczjtcysl=").append(bhqczjtcysl);
        sb.append(", sjjlwxhxpsl=").append(sjjlwxhxpsl);
        sb.append(", bysy=").append(bysy);
        sb.append(", lwgs=").append(lwgs);
        sb.append(", fssywrsgsl=").append(fssywrsgsl);
        sb.append(", yxczsywrsl=").append(yxczsywrsl);
        sb.append(", bz=").append(bz);
        sb.append(", scs=").append(scs);
        sb.append(", scd=").append(scd);
        sb.append(", excelrow=").append(excelrow);
        sb.append(", nd=").append(nd);
        sb.append(", uploadfilename=").append(uploadfilename);
        sb.append(", syszsdm=").append(syszsdm);
        sb.append(", syszshdm=").append(syszshdm);
        sb.append(", syszxdm=").append(syszxdm);
        sb.append(", syszxmc=").append(syszxmc);
        sb.append(", datastate=").append(datastate);
        sb.append(", datatype=").append(datatype);
        sb.append(", csbm=").append(csbm);
        sb.append(", calstate=").append(calstate);
        sb.append(", year=").append(year);
        sb.append(", yjJtcys=").append(yjJtcys);
        sb.append(", ejJtcys=").append(ejJtcys);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}