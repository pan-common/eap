
package com.taiji.eap.common.form.element.bean;

import java.util.Date;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseTree;
public class Element extends BaseTree {
    private Long elementId;//元素ID
    private String elementName;//元素名称
    @Dictionary(parentId = 97)
    private String elementType;//元素类型
    private Long parentId;//上级元素ID
    private String jsTemplatePath;//js模板路径
    private String htmlTemplatePath;//html模板路径
    private String elementClass;//元素处理类
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private Long creater;//创建人
    private String valid;//是否有效
    public Element(Long elementId,String elementName) {
        this.elementId = elementId;
        this.elementName = elementName;
    }

    public Element() {

    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }


    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }


    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getJsTemplatePath() {
        return jsTemplatePath;
    }

    public void setJsTemplatePath(String jsTemplatePath) {
        this.jsTemplatePath = jsTemplatePath;
    }


    public String getHtmlTemplatePath() {
        return htmlTemplatePath;
    }

    public void setHtmlTemplatePath(String htmlTemplatePath) {
        this.htmlTemplatePath = htmlTemplatePath;
    }


    public String getElementClass() {
        return elementClass;
    }

    public void setElementClass(String elementClass) {
        this.elementClass = elementClass;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }


}
