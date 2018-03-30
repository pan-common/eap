
package com.taiji.eap.biz.jcdxx.bean;

import com.taiji.eap.common.base.BaseModel;

public class Jcdxx extends BaseModel{
    private Long id;//主键
    private String qybh;//企业编号
    private String qyfa;//企业方案编号
    private String jcdbh;//对应系统监测点编号
    private String jcdmc;//检测点名称
    private String jcdfl;//监测点分类

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getQyfa() {
        return qyfa;
    }

    public void setQyfa(String qyfa) {
        this.qyfa = qyfa;
    }

    public String getJcdbh() {
        return jcdbh;
    }

    public void setJcdbh(String jcdbh) {
        this.jcdbh = jcdbh;
    }


    public String getJcdmc() {
        return jcdmc;
    }

    public void setJcdmc(String jcdmc) {
        this.jcdmc = jcdmc;
    }


    public String getJcdfl() {
        return jcdfl;
    }

    public void setJcdfl(String jcdfl) {
        this.jcdfl = jcdfl;
    }


}
