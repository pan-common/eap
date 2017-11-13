
package com.taiji.eap.common.form.formconf.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;

public class Formconf extends BaseModel{

    private static final long serialVersionUID = -6855235355810532522L;
    private Long formId;//表单ID
    private Integer seq;//序号
    private String formName;//表单名称
    private String formAlias;//表单别名
    private String formNote;//表单备注
    private String formType;//表单类型
    private String formStatus;//表单状态

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }


    public String getFormAlias() {
        return formAlias;
    }

    public void setFormAlias(String formAlias) {
        this.formAlias = formAlias;
    }


    public String getFormNote() {
        return formNote;
    }

    public void setFormNote(String formNote) {
        this.formNote = formNote;
    }


    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }


    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }


}
