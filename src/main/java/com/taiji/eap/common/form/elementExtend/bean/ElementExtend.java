
package com.taiji.eap.common.form.elementExtend.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class ElementExtend extends BaseModel{
    /**
     * 元素扩展属性ID
     */
    private Long elementExtendId;
    /**
     * 元素ID
     */
    private Long elementId;
    /**
     * 扩展属性字段
     */
    private String extendField;
    /**
     * 扩展属性名称
     */
    private String extendName;
    /**
     * 扩展字段类型
     */
    private String extendType;
    /**
     * 备注
     */
    private String note;

    public Long getElementExtendId() {
        return elementExtendId;
    }

    public void setElementExtendId(Long elementExtendId) {
        this.elementExtendId = elementExtendId;
    }


    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }


    public String getExtendField() {
        return extendField;
    }

    public void setExtendField(String extendField) {
        this.extendField = extendField;
    }


    public String getExtendName() {
        return extendName;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }


    public String getExtendType() {
        return extendType;
    }

    public void setExtendType(String extendType) {
        this.extendType = extendType;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
