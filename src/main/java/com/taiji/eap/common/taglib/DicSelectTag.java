package com.taiji.eap.common.taglib;

import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class DicSelectTag extends TagSupport{

    @Autowired
    private DictionaryService dictionaryService;

    private String id;
    private String cssClass;//样式类
    private String styleClass;//内联样式
    private Long parentId;//参数系统编码
    private String selectName;//select的name值
    private String nullName;//未选择时给的提示信息
    private String value;//选中的值
    private String selectedValue;//选中的值
    private String onChange;//改变时调用的方法
    private String multiple;//选择方式 单选 多选
    private String layfilter;//layui过滤器

    @Override
    public int doEndTag() throws JspException {
        dictionaryService = (DictionaryService) SpringContextUtil.getBean("dictionaryService");
        List<Dictionary> dictionaries = dictionaryService.selectByPid(0L);
        StringBuffer sb = new StringBuffer();
        JspWriter out = pageContext.getOut();

        sb.append("<select name=\""+this.getSelectName()+"\"");
        sb.append("id=\"" + this.getId() + "\"");
        if (!StringUtils.isEmpty(this.getCssClass())){
            sb.append("class=\"" + this.getCssClass() + "\"");
        }
        if(!StringUtils.isEmpty(this.getStyleClass())){
            sb.append("style=\"" + this.getStyleClass() + "\"");
        }
        if(!StringUtils.isEmpty(this.getMultiple())){
            sb.append("multiple=\"" + this.getMultiple() + "\"");
        }
        if(!StringUtils.isEmpty(this.getOnChange())){
            sb.append("onchange=\"" + this.getOnChange() + "\"");
        }
        if(!StringUtils.isEmpty(this.getLayfilter())){
            sb.append("lay-filter=\"" + this.getLayfilter() + "\"");
        }
        sb.append(">");
        if(!StringUtils.isEmpty(this.getNullName())){
            sb.append("<option value=\"\">--"+this.getNullName()+"--</option>");
        }
        for (Dictionary dictionary: dictionaries) {
            if(!StringUtils.isEmpty(this.getSelectedValue())) {
                if (dictionary.getKeystone().equals(this.getSelectedValue())) {
                    sb.append("<option value=\"" + dictionary.getKeystone() + "\" selected>");
                } else {
                    sb.append("<option value=\"" + dictionary.getKeystone() + "\">");
                }
            }else {
                sb.append("<option value=\"" + dictionary.getKeystone() + "\">");
            }
            sb.append(dictionary.getValue()+"</option>");
        }
        sb.append("</select>");
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
    }

    public DicSelectTag(String cssClass, String styleClass, Long parentId, String selectName, String nullName, String value, String selectedValue, String onChange, String multiple) {
        this.cssClass = cssClass;
        this.styleClass = styleClass;
        this.parentId = parentId;
        this.selectName = selectName;
        this.nullName = nullName;
        this.value = value;
        this.selectedValue = selectedValue;
        this.onChange = onChange;
        this.multiple = multiple;
    }

    public DicSelectTag() {
    }

    public DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public String getNullName() {
        return nullName;
    }

    public void setNullName(String nullName) {
        this.nullName = nullName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getOnChange() {
        return onChange;
    }

    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getLayfilter() {
        return layfilter;
    }

    public void setLayfilter(String layfilter) {
        this.layfilter = layfilter;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DicSelectTag{" +
                "dictionaryService=" + dictionaryService +
                ", cssClass='" + cssClass + '\'' +
                ", styleClass='" + styleClass + '\'' +
                ", parentId=" + parentId +
                ", selectName='" + selectName + '\'' +
                ", nullName='" + nullName + '\'' +
                ", value='" + value + '\'' +
                ", selectedValue='" + selectedValue + '\'' +
                ", onChange='" + onChange + '\'' +
                ", multiple='" + multiple + '\'' +
                '}';
    }
}
