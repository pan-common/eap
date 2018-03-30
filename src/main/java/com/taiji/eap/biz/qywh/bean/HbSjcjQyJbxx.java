package com.taiji.eap.biz.qywh.bean;

import com.taiji.eap.common.base.BaseModel;

/**
 * @author 潘宏智
 * @date
 */
public class HbSjcjQyJbxx extends BaseModel{
    private static final long serialVersionUID = 6967203975197567024L;

    private String id;//编号
    private String qybm;//单位编码
    private String qymc;//企业名称
    private String cym;//曾用名
    private String shfwm;//社会服务码
    private String zzjgdm;//组织机构代码
    private String qylb;//企业类别
    private String zclxdm;//注册类型代码
    private String qygmdm;//企业规模代码
    private String xzqhdmsheng;//行政区划代码（省）
    private String xzqhdmshi;//行政区划代码（市）
    private String xzqhdmxian;//行政区划代码（县）
    private String qyxxdzxz;//企业详细地址（乡镇）
    private String qyxxdz;//企业详细地址
    private String qyyzbm;//企业邮政编码
    private String qyzxjddu;//企业中心经度（度）
    private String qyzxjdfen;//企业中心经度（分）
    private String qyzxjdmiao;//企业中心经度（秒）
    private String qyzxwddu;//企业中心纬度（度）
    private String qyzxwdfen;//企业中心纬度（分）
    private String qyzxwdmiao;//企业中心纬度（秒）
    private String hblxrxm;//环保联系人姓名
    private String hblxrdh;//环保联系人电话
    private String hblxrsjh;//环保联系人手机号
    private String hblxrdzyx;//环保联系人电子邮箱
    private String hblxrcz;//环保联系人传真
    private String dwpmsytcfwz;//单位平面示意图存放位置
    private String qywz;//企业网址
    private String frdbxm;//法人代表姓名
    private String qylx;//企业类型
    private String ly;//流域
    private String hy;//海域
    private String hy11;//海域
    private String nsbd;//南水北调
    private String sxkq;//三峡库区
    private String lkq;//三区十群
    private String ssjt;//所属集团
    private String zdysx;//自定义属性
    private String wrylb;//污染源类别
    private String jctcny;//建成投产年月
    private String pwxkzbh;//排污许可证编号
    private String pwxkzfzrq;//排污许可证发证日期
    private String kzjbfq;//控制级别（废气）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String kzjbfs;//控制级别（废水）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String kzjbzjs;//控制级别（重金属）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String kzjbwf;//控制级别（危废）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String kzjbxq;//控制级别（规模化畜禽养殖场）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String sfgt;//是否关停
    private String gtyy;//关停原因
    private String gtqssj;//关停起始时间
    private String gtjssj;//关停结束时间
    private String hylb;//行业类别
    private String hylb1;//行业类别1级类
    private String hylb2;//行业类别2级类
    private String hylb3;//行业类别3级类
    private String hylb4;//行业类别4级类
    private String nd;//登记的年度
    private String zdhyb;//重点行业信息存放表
    private String wsclclb;//污水处理厂类别
    private String tbdlh;//填报登录号
    private String pwd;//密码
    private String shdlh;//审核登录号
    private String zt;//状态 1 表示已激活 3 表示未激活 5表示停报
    private String jb;//企业 9
    private String kzjbwsclc;//控制级别（污水处理厂）0000 千百十个分别表示国控、省控、市控、其他是否选中，1表示选中、0表示未选
    private String syncIud;//同步标志int
    private String syncTime;//同步时间
    private String syncProcode;//同步省
    private String qyzcdz;//企业注册地址
    private String xzqhdmsheng2;//$column.getRemarks()
    private String xzqhdmsheng3;//$column.getRemarks()
    private String xzqhdmshi2;//$column.getRemarks()
    private String xzqhdmshi3;//$column.getRemarks()
    private String xzqhdmxian2;//$column.getRemarks()
    private String xzqhdmxian3;//$column.getRemarks()
    private String qyxxdzxz2;//$column.getRemarks()
    private String qyxxdzxz3;//$column.getRemarks()
    private String qyxxdz2;//$column.getRemarks()
    private String qyxxdz3;//$column.getRemarks()
    private String qyyzbm2;//$column.getRemarks()
    private String qyyzbm3;//$column.getRemarks()
    private String qyzxjddu2;//$column.getRemarks()
    private String qyzxjddu3;//$column.getRemarks()
    private String qyzxjdfen2;//$column.getRemarks()
    private String qyzxjdfen3;//$column.getRemarks()
    private String qyzxjdmiao2;//$column.getRemarks()
    private String qyzxjdmiao3;//$column.getRemarks()
    private String qyzxwddu2;//$column.getRemarks()
    private String qyzxwddu3;//$column.getRemarks()
    private String qyzxwdfen2;//$column.getRemarks()
    private String qyzxwdfen3;//$column.getRemarks()
    private String qyzxwdmiao2;//$column.getRemarks()
    private String qyzxwdmiao3;//$column.getRemarks()
    private String qyzcdzsheng;//$column.getRemarks()
    private String qyzcdzshi;//$column.getRemarks()
    private String qyzcdzxian;//$column.getRemarks()
    private String qyzcdzxz;//$column.getRemarks()
    private String qyzcdzbm;//$column.getRemarks()
    private String gldlh;//登录号
    private String dlh;//登录号
    private String qybh;
    private String rwid;
    private String sfcb;
    private String sfsh;//是否审核方案0审核，1不审核
    private String hylb11;//行业类别
    private String yjc;//行业类别
    private String sjjc;//行业类别ENTERID
    private String enterid;
    //private String jb;//行业类别
    private String gljb;//省市县管理控制
    private String gljbstr;//存查询省市县管理级别字符串
    private String sfeey;//是否是二噁英企业
    private String sfgl;//是否关联发证企业
    private String glid;//是否企业id
    private String sfbj;//二噁英创建企业环保是否编辑
    private String ztx;
    private String fazt;//方案状态 1 未提交 2 审核中3 审核通过 4 审核失败 5 当前在用 6 曾用方案
    private String fazt1;//0 无方案 1 未提交 2 有当前在用方案 3 审核中4有当前在用方案且在审核中5方案审核未通过
    private String jcjg;
    private String yyjg;
    private String dcbt;//导出表头
    private String sjlb;//数据类别
    private String sfgx; //是否待更新
    private String xkznum; //许可证编号
    private String xkxtid; //许可系统ID
    private String rmmemberid;
    private String jcdsl; //监测点数量
    private String jcxmsl; //检测项目数量

    //四川对应企业名称--孙世厅加
    private String scqymc;
    private String scqyid;
    //企业对应表id
    private String qydybid;
    private String zw;
    private String ew;
    private String rwfbremc;
    private String sfwcdy;


    public String getSfwcdy() {
        return sfwcdy;
    }

    public void setSfwcdy(String sfwcdy) {
        this.sfwcdy = sfwcdy;
    }

    public String getRwfbremc() {
        return rwfbremc;
    }

    public void setRwfbremc(String rwfbremc) {
        this.rwfbremc = rwfbremc;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getEw() {
        return ew;
    }

    public void setEw(String ew) {
        this.ew = ew;
    }
    //添加需要的值
    private String sjfbrq;
    private String	jcrq;

    public String getJcrq() {
        return jcrq;
    }

    public void setJcrq(String jcrq) {
        this.jcrq = jcrq;
    }

    public String getSjfbrq() {
        return sjfbrq;
    }



    public void setSjfbrq(String sjfbrq) {
        this.sjfbrq = sjfbrq;
    }


    public String getQydybid() {
        return qydybid;
    }

    public void setQydybid(String qydybid) {
        this.qydybid = qydybid;
    }

    public String getScqyid() {
        return scqyid;
    }

    public String getJcdsl() {
        return jcdsl;
    }

    public void setJcdsl(String jcdsl) {
        this.jcdsl = jcdsl;
    }

    public String getJcxmsl() {
        return jcxmsl;
    }

    public void setJcxmsl(String jcxmsl) {
        this.jcxmsl = jcxmsl;
    }

    public void setScqyid(String scqyid) {
        this.scqyid = scqyid;
    }

    public String getScqymc() {
        return scqymc;
    }

    public void setScqymc(String scqymc) {
        this.scqymc = scqymc;
    }

    public String getRmmemberid() {
        return rmmemberid;
    }

    public void setRmmemberid(String rmmemberid) {
        this.rmmemberid = rmmemberid;
    }
    public String getSjlb() {
        return sjlb;
    }
    public void setSjlb(String sjlb) {
        this.sjlb = sjlb;
    }
    public String getDcbtIn(){
        String dcbtin="";
        if(this.dcbt!=null){
            String[] cxbts=this.dcbt.split(",");
            for(String bt:cxbts){
                dcbtin+="'"+bt.trim()+"',";
            }
            dcbtin+="''";
        }

        return dcbtin;
    }
    public String getDcbt() {
        return dcbt;
    }
    public void setDcbt(String dcbt) {
        this.dcbt = dcbt;
    }
    public String getJcjg() {
        return jcjg;
    }
    public void setJcjg(String jcjg) {
        this.jcjg = jcjg;
    }
    public String getYyjg() {
        return yyjg;
    }
    public void setYyjg(String yyjg) {
        this.yyjg = yyjg;
    }
    public String getFazt1() {
        return fazt1;
    }
    public void setFazt1(String fazt1) {
        this.fazt1 = fazt1;
    }
    public String getFazt() {
        return fazt;
    }
    public void setFazt(String fazt) {
        this.fazt = fazt;
    }
    public String getZtx() {
        return ztx;
    }
    public void setZtx(String ztx) {
        this.ztx = ztx;
    }

    public String getSfbj() {
        return sfbj;
    }

    public void setSfbj(String sfbj) {
        this.sfbj = sfbj;
    }

    public String getSfeey() {
        return sfeey;
    }

    public void setSfeey(String sfeey) {
        this.sfeey = sfeey;
    }

    public String getGljbstr() {
        return gljbstr;
    }

    public void setGljbstr(String gljbstr) {
        this.gljbstr = gljbstr;
    }

    public String getGljb() {
        return gljb;
    }

    public void setGljb(String gljb) {
        this.gljb = gljb;
    }

    public String getYjc() {
        return yjc;
    }

    public String getEnterid() {
        return enterid;
    }

    public void setEnterid(String enterid) {
        this.enterid = enterid;
    }

    public String getSfsh() {
        return sfsh;
    }

    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    public void setYjc(String yjc) {
        this.yjc = yjc;
    }

    public String getSjjc() {
        return sjjc;
    }

    public void setSjjc(String sjjc) {
        this.sjjc = sjjc;
    }

    public String getHylb12() {
        return hylb12;
    }

    public void setHylb12(String hylb12) {
        this.hylb12 = hylb12;
    }

    private String hylb12;//行业类别
    private String ly11;//流域
    private String zclxdm1;//注册类型
    public String getSfcb() {
        return sfcb;
    }

    public void setSfcb(String sfcb) {
        this.sfcb = sfcb;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid;
    }

    public String getHylb1() {
        return hylb1;
    }

    public void setHylb1(String hylb1) {
        this.hylb1 = hylb1;
    }

    public String getDlh() {
        return dlh;
    }

    public void setDlh(String dlh) {
        this.dlh = dlh;
    }

    public String getGldlh() {
        return gldlh;
    }

    public void setGldlh(String gldlh) {
        this.gldlh = gldlh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQybm() {
        return qybm;
    }

    public void setQybm(String qybm) {
        this.qybm = qybm;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    public String getShfwm() {
        return shfwm;
    }

    public void setShfwm(String shfwm) {
        this.shfwm = shfwm;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getQylb() {
        return qylb;
    }

    public void setQylb(String qylb) {
        this.qylb = qylb;
    }

    public String getZclxdm() {
        return zclxdm;
    }

    public void setZclxdm(String zclxdm) {
        this.zclxdm = zclxdm;
    }

    public String getQygmdm() {
        return qygmdm;
    }

    public void setQygmdm(String qygmdm) {
        this.qygmdm = qygmdm;
    }

    public String getXzqhdmsheng() {
        return xzqhdmsheng;
    }

    public void setXzqhdmsheng(String xzqhdmsheng) {
        this.xzqhdmsheng = xzqhdmsheng;
    }

    public String getXzqhdmshi() {
        return xzqhdmshi;
    }

    public void setXzqhdmshi(String xzqhdmshi) {
        this.xzqhdmshi = xzqhdmshi;
    }

    public String getXzqhdmxian() {
        return xzqhdmxian;
    }

    public void setXzqhdmxian(String xzqhdmxian) {
        this.xzqhdmxian = xzqhdmxian;
    }

    public String getQyxxdzxz() {
        return qyxxdzxz;
    }

    public void setQyxxdzxz(String qyxxdzxz) {
        this.qyxxdzxz = qyxxdzxz;
    }

    public String getQyxxdz() {
        return qyxxdz;
    }

    public void setQyxxdz(String qyxxdz) {
        this.qyxxdz = qyxxdz;
    }

    public String getQyyzbm() {
        return qyyzbm;
    }

    public void setQyyzbm(String qyyzbm) {
        this.qyyzbm = qyyzbm;
    }

    public String getQyzxjddu() {
        return qyzxjddu;
    }

    public void setQyzxjddu(String qyzxjddu) {
        this.qyzxjddu = qyzxjddu;
    }

    public String getQyzxjdfen() {
        return qyzxjdfen;
    }

    public void setQyzxjdfen(String qyzxjdfen) {
        this.qyzxjdfen = qyzxjdfen;
    }

    public String getQyzxjdmiao() {
        return qyzxjdmiao;
    }

    public void setQyzxjdmiao(String qyzxjdmiao) {
        this.qyzxjdmiao = qyzxjdmiao;
    }

    public String getQyzxwddu() {
        return qyzxwddu;
    }

    public void setQyzxwddu(String qyzxwddu) {
        this.qyzxwddu = qyzxwddu;
    }

    public String getQyzxwdfen() {
        return qyzxwdfen;
    }

    public void setQyzxwdfen(String qyzxwdfen) {
        this.qyzxwdfen = qyzxwdfen;
    }

    public String getQyzxwdmiao() {
        return qyzxwdmiao;
    }

    public void setQyzxwdmiao(String qyzxwdmiao) {
        this.qyzxwdmiao = qyzxwdmiao;
    }

    public String getHblxrxm() {
        return hblxrxm;
    }

    public void setHblxrxm(String hblxrxm) {
        this.hblxrxm = hblxrxm;
    }

    public String getHblxrdh() {
        return hblxrdh;
    }

    public void setHblxrdh(String hblxrdh) {
        this.hblxrdh = hblxrdh;
    }

    public String getHblxrsjh() {
        return hblxrsjh;
    }

    public void setHblxrsjh(String hblxrsjh) {
        this.hblxrsjh = hblxrsjh;
    }

    public String getHblxrdzyx() {
        return hblxrdzyx;
    }

    public void setHblxrdzyx(String hblxrdzyx) {
        this.hblxrdzyx = hblxrdzyx;
    }

    public String getHblxrcz() {
        return hblxrcz;
    }

    public void setHblxrcz(String hblxrcz) {
        this.hblxrcz = hblxrcz;
    }

    public String getDwpmsytcfwz() {
        return dwpmsytcfwz;
    }

    public void setDwpmsytcfwz(String dwpmsytcfwz) {
        this.dwpmsytcfwz = dwpmsytcfwz;
    }

    public String getQywz() {
        return qywz;
    }

    public void setQywz(String qywz) {
        this.qywz = qywz;
    }

    public String getFrdbxm() {
        return frdbxm;
    }

    public void setFrdbxm(String frdbxm) {
        this.frdbxm = frdbxm;
    }

    public String getQylx() {
        return qylx;
    }

    public void setQylx(String qylx) {
        this.qylx = qylx;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
    }

    public String getNsbd() {
        return nsbd;
    }

    public void setNsbd(String nsbd) {
        this.nsbd = nsbd;
    }

    public String getSxkq() {
        return sxkq;
    }

    public void setSxkq(String sxkq) {
        this.sxkq = sxkq;
    }

    public String getLkq() {
        return lkq;
    }

    public void setLkq(String lkq) {
        this.lkq = lkq;
    }

    public String getSsjt() {
        return ssjt;
    }

    public void setSsjt(String ssjt) {
        this.ssjt = ssjt;
    }

    public String getZdysx() {
        return zdysx;
    }

    public void setZdysx(String zdysx) {
        this.zdysx = zdysx;
    }

    public String getWrylb() {
        return wrylb;
    }

    public void setWrylb(String wrylb) {
        this.wrylb = wrylb;
    }

    public String getJctcny() {
        return jctcny;
    }

    public void setJctcny(String jctcny) {
        this.jctcny = jctcny;
    }

    public String getPwxkzbh() {
        return pwxkzbh;
    }

    public void setPwxkzbh(String pwxkzbh) {
        this.pwxkzbh = pwxkzbh;
    }

    public String getPwxkzfzrq() {
        return pwxkzfzrq;
    }

    public void setPwxkzfzrq(String pwxkzfzrq) {
        this.pwxkzfzrq = pwxkzfzrq;
    }

    public String getKzjbfq() {
        return kzjbfq;
    }

    public void setKzjbfq(String kzjbfq) {
        this.kzjbfq = kzjbfq;
    }

    public String getKzjbfs() {
        return kzjbfs;
    }

    public void setKzjbfs(String kzjbfs) {
        this.kzjbfs = kzjbfs;
    }

    public String getKzjbzjs() {
        return kzjbzjs;
    }

    public void setKzjbzjs(String kzjbzjs) {
        this.kzjbzjs = kzjbzjs;
    }

    public String getKzjbwf() {
        return kzjbwf;
    }

    public void setKzjbwf(String kzjbwf) {
        this.kzjbwf = kzjbwf;
    }

    public String getKzjbxq() {
        return kzjbxq;
    }

    public void setKzjbxq(String kzjbxq) {
        this.kzjbxq = kzjbxq;
    }

    public String getSfgt() {
        return sfgt;
    }

    public void setSfgt(String sfgt) {
        this.sfgt = sfgt;
    }

    public String getGtyy() {
        return gtyy;
    }

    public void setGtyy(String gtyy) {
        this.gtyy = gtyy;
    }

    public String getGtqssj() {
        return gtqssj;
    }

    public void setGtqssj(String gtqssj) {
        this.gtqssj = gtqssj;
    }

    public String getGtjssj() {
        return gtjssj;
    }

    public void setGtjssj(String gtjssj) {
        this.gtjssj = gtjssj;
    }

    public String getHylb() {
        return hylb;
    }

    public void setHylb(String hylb) {
        this.hylb = hylb;
    }

    public String getHylb2() {
        return hylb2;
    }

    public void setHylb2(String hylb2) {
        this.hylb2 = hylb2;
    }

    public String getHylb3() {
        return hylb3;
    }

    public void setHylb3(String hylb3) {
        this.hylb3 = hylb3;
    }

    public String getHylb4() {
        return hylb4;
    }

    public void setHylb4(String hylb4) {
        this.hylb4 = hylb4;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getZdhyb() {
        return zdhyb;
    }

    public void setZdhyb(String zdhyb) {
        this.zdhyb = zdhyb;
    }

    public String getWsclclb() {
        return wsclclb;
    }

    public void setWsclclb(String wsclclb) {
        this.wsclclb = wsclclb;
    }

    public String getTbdlh() {
        return tbdlh;
    }

    public void setTbdlh(String tbdlh) {
        this.tbdlh = tbdlh;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShdlh() {
        return shdlh;
    }

    public void setShdlh(String shdlh) {
        this.shdlh = shdlh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public String getKzjbwsclc() {
        return kzjbwsclc;
    }

    public void setKzjbwsclc(String kzjbwsclc) {
        this.kzjbwsclc = kzjbwsclc;
    }

    public String getSyncIud() {
        return syncIud;
    }

    public void setSyncIud(String syncIud) {
        this.syncIud = syncIud;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getSyncProcode() {
        return syncProcode;
    }

    public void setSyncProcode(String syncProcode) {
        this.syncProcode = syncProcode;
    }

    public String getQyzcdz() {
        return qyzcdz;
    }

    public void setQyzcdz(String qyzcdz) {
        this.qyzcdz = qyzcdz;
    }

    public String getXzqhdmsheng2() {
        return xzqhdmsheng2;
    }

    public void setXzqhdmsheng2(String xzqhdmsheng2) {
        this.xzqhdmsheng2 = xzqhdmsheng2;
    }

    public String getXzqhdmsheng3() {
        return xzqhdmsheng3;
    }

    public void setXzqhdmsheng3(String xzqhdmsheng3) {
        this.xzqhdmsheng3 = xzqhdmsheng3;
    }

    public String getXzqhdmshi2() {
        return xzqhdmshi2;
    }

    public void setXzqhdmshi2(String xzqhdmshi2) {
        this.xzqhdmshi2 = xzqhdmshi2;
    }

    public String getXzqhdmshi3() {
        return xzqhdmshi3;
    }

    public void setXzqhdmshi3(String xzqhdmshi3) {
        this.xzqhdmshi3 = xzqhdmshi3;
    }

    public String getXzqhdmxian2() {
        return xzqhdmxian2;
    }

    public void setXzqhdmxian2(String xzqhdmxian2) {
        this.xzqhdmxian2 = xzqhdmxian2;
    }

    public String getXzqhdmxian3() {
        return xzqhdmxian3;
    }

    public void setXzqhdmxian3(String xzqhdmxian3) {
        this.xzqhdmxian3 = xzqhdmxian3;
    }

    public String getQyxxdzxz2() {
        return qyxxdzxz2;
    }

    public void setQyxxdzxz2(String qyxxdzxz2) {
        this.qyxxdzxz2 = qyxxdzxz2;
    }

    public String getQyxxdzxz3() {
        return qyxxdzxz3;
    }

    public void setQyxxdzxz3(String qyxxdzxz3) {
        this.qyxxdzxz3 = qyxxdzxz3;
    }

    public String getQyxxdz2() {
        return qyxxdz2;
    }

    public void setQyxxdz2(String qyxxdz2) {
        this.qyxxdz2 = qyxxdz2;
    }

    public String getQyxxdz3() {
        return qyxxdz3;
    }

    public void setQyxxdz3(String qyxxdz3) {
        this.qyxxdz3 = qyxxdz3;
    }

    public String getQyyzbm2() {
        return qyyzbm2;
    }

    public void setQyyzbm2(String qyyzbm2) {
        this.qyyzbm2 = qyyzbm2;
    }

    public String getQyyzbm3() {
        return qyyzbm3;
    }

    public void setQyyzbm3(String qyyzbm3) {
        this.qyyzbm3 = qyyzbm3;
    }

    public String getQyzxjddu2() {
        return qyzxjddu2;
    }

    public void setQyzxjddu2(String qyzxjddu2) {
        this.qyzxjddu2 = qyzxjddu2;
    }

    public String getQyzxjddu3() {
        return qyzxjddu3;
    }

    public void setQyzxjddu3(String qyzxjddu3) {
        this.qyzxjddu3 = qyzxjddu3;
    }

    public String getQyzxjdfen2() {
        return qyzxjdfen2;
    }

    public void setQyzxjdfen2(String qyzxjdfen2) {
        this.qyzxjdfen2 = qyzxjdfen2;
    }

    public String getQyzxjdfen3() {
        return qyzxjdfen3;
    }

    public void setQyzxjdfen3(String qyzxjdfen3) {
        this.qyzxjdfen3 = qyzxjdfen3;
    }

    public String getQyzxjdmiao2() {
        return qyzxjdmiao2;
    }

    public void setQyzxjdmiao2(String qyzxjdmiao2) {
        this.qyzxjdmiao2 = qyzxjdmiao2;
    }

    public String getQyzxjdmiao3() {
        return qyzxjdmiao3;
    }

    public void setQyzxjdmiao3(String qyzxjdmiao3) {
        this.qyzxjdmiao3 = qyzxjdmiao3;
    }

    public String getQyzxwddu2() {
        return qyzxwddu2;
    }

    public void setQyzxwddu2(String qyzxwddu2) {
        this.qyzxwddu2 = qyzxwddu2;
    }

    public String getQyzxwddu3() {
        return qyzxwddu3;
    }

    public void setQyzxwddu3(String qyzxwddu3) {
        this.qyzxwddu3 = qyzxwddu3;
    }

    public String getQyzxwdfen2() {
        return qyzxwdfen2;
    }

    public void setQyzxwdfen2(String qyzxwdfen2) {
        this.qyzxwdfen2 = qyzxwdfen2;
    }

    public String getQyzxwdfen3() {
        return qyzxwdfen3;
    }

    public void setQyzxwdfen3(String qyzxwdfen3) {
        this.qyzxwdfen3 = qyzxwdfen3;
    }

    public String getQyzxwdmiao2() {
        return qyzxwdmiao2;
    }

    public void setQyzxwdmiao2(String qyzxwdmiao2) {
        this.qyzxwdmiao2 = qyzxwdmiao2;
    }

    public String getQyzxwdmiao3() {
        return qyzxwdmiao3;
    }

    public void setQyzxwdmiao3(String qyzxwdmiao3) {
        this.qyzxwdmiao3 = qyzxwdmiao3;
    }

    public String getQyzcdzsheng() {
        return qyzcdzsheng;
    }

    public void setQyzcdzsheng(String qyzcdzsheng) {
        this.qyzcdzsheng = qyzcdzsheng;
    }

    public String getQyzcdzshi() {
        return qyzcdzshi;
    }

    public void setQyzcdzshi(String qyzcdzshi) {
        this.qyzcdzshi = qyzcdzshi;
    }

    public String getQyzcdzxian() {
        return qyzcdzxian;
    }

    public void setQyzcdzxian(String qyzcdzxian) {
        this.qyzcdzxian = qyzcdzxian;
    }

    public String getQyzcdzxz() {
        return qyzcdzxz;
    }

    public void setQyzcdzxz(String qyzcdzxz) {
        this.qyzcdzxz = qyzcdzxz;
    }

    public String getQyzcdzbm() {
        return qyzcdzbm;
    }

    public void setQyzcdzbm(String qyzcdzbm) {
        this.qyzcdzbm = qyzcdzbm;
    }

    public String getHylb11() {
        return hylb11;
    }

    public void setHylb11(String hylb11) {
        this.hylb11 = hylb11;
    }

    public String getLy11() {
        return ly11;
    }

    public void setLy11(String ly11) {
        this.ly11 = ly11;
    }

    public String getZclxdm1() {
        return zclxdm1;
    }

    public void setZclxdm1(String zclxdm1) {
        this.zclxdm1 = zclxdm1;
    }

    public String getSfgl() {
        return sfgl;
    }

    public void setSfgl(String sfgl) {
        this.sfgl = sfgl;
    }

    public String getGlid() {
        return glid;
    }

    public void setGlid(String glid) {
        this.glid = glid;
    }

    public String getHy11() {
        return hy11;
    }

    public void setHy11(String hy11) {
        this.hy11 = hy11;
    }

    public String getSfgx() {
        return sfgx;
    }

    public void setSfgx(String sfgx) {
        this.sfgx = sfgx;
    }

    public String getXkxtid() {
        return xkxtid;
    }

    public void setXkxtid(String xkxtid) {
        this.xkxtid = xkxtid;
    }

    public String getXkznum() {
        return xkznum;
    }

    public void setXkznum(String xkznum) {
        this.xkznum = xkznum;
    }

}
