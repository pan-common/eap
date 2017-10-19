package com.taiji.eap.common.taglib;

import com.taiji.eap.common.taglib.select.helper.SelectDataSourceHelper;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 从所有数据源中进行选择
 */
public class CommonSelectTag extends TagSupport{

    private String id;//
    private String name;//select的name值
    private String cssClass;//样式类
    private String styleClass;//内联样式
    private String param;//参数
    private String nullName;//未选择时给的提示信息
    private String value;//选中的值
    private String selectedValue;//选中的值
    private String onChange;//改变时调用的方法
    private String multiple;//选择方式  单选/多选
    private String layfilter;//layui过滤器
    private String dataSource;//数据来源

    @Override
    public int doEndTag() throws JspException {
        //TODO
        SelectDataSourceHelper helper = (SelectDataSourceHelper) SpringContextUtil.getBean("selectDataSourceHelper");
        List<Map<String,Object>> list = null;
        try {
            list = helper.getDataSources(this.getDataSource(),this.getParam());
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        JspWriter out = pageContext.getOut();

        sb.append("<select name=\""+this.getName()+"\"");
        sb.append("id=\"" + this.getId() + "\"");
        if (!StringUtils.isEmpty(this.getCssClass())){
            sb.append("class=\"" + this.getCssClass() + "\"");
        }
        if(!StringUtils.isEmpty(this.getValue())){
            sb.append("value=\"" + this.getValue() + "\"");
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
        for (Map<String,Object> map : list) {
            if(!StringUtils.isEmpty(this.getSelectedValue())){
                if(map.get("value").equals(this.getSelectedValue())){
                    sb.append("<option value=\"" + map.get("key") + "\" selected>");
                }else {
                    sb.append("<option value=\"" + map.get("key") + "\">");
                }
            }else {
                sb.append("<option value=\"" + map.get("key") + "\">");
            }
            sb.append(map.get("value")+"</option>");
        }
        sb.append("</select>");
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
    }

    public CommonSelectTag(String id, String name, String cssClass, String styleClass, String param, String nullName, String value, String onChange, String multiple) {
        this.id = id;
        this.name = name;
        this.cssClass = cssClass;
        this.styleClass = styleClass;
        this.param = param;
        this.nullName = nullName;
        this.value = value;
        this.onChange = onChange;
        this.multiple = multiple;
    }

    public CommonSelectTag() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "CommonSelectTag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cssClass='" + cssClass + '\'' +
                ", styleClass='" + styleClass + '\'' +
                ", param='" + param + '\'' +
                ", nullName='" + nullName + '\'' +
                ", value='" + value + '\'' +
                ", onChange='" + onChange + '\'' +
                ", multiple='" + multiple + '\'' +
                '}';
    }
}
