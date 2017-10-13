package com.taiji.eap.common.taglib;

import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class DicRadioTag extends TagSupport{

    private String name;
    private String cssClass;
    private String styleClass;
    private Long parentId;
    private String checkPosition;
    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public int doEndTag() throws JspException {
        dictionaryService = (DictionaryService) SpringContextUtil.getBean("dictionaryService");
        List<Dictionary> dictionaries = null;
        try {
            dictionaries = dictionaryService.listByPid(getParentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        JspWriter out = pageContext.getOut();

        for (int i = 0; i < dictionaries.size(); i++) {
            if(checkPosition==null)
                checkPosition = "1";
            if (Integer.valueOf(checkPosition)==(i+1)){
                sb.append("<input type=\"radio\" name=\""+getName()+"\" value=\""+dictionaries.get(i).getKeystone()+"\" title=\""+dictionaries.get(i).getValue()+"\" checked>");
            }else {
                sb.append("<input type=\"radio\" name=\""+getName()+"\" value=\""+dictionaries.get(i).getKeystone()+"\" title=\""+dictionaries.get(i).getValue()+"\" >");
            }
        }
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCheckPosition() {
        return checkPosition;
    }

    public void setCheckPosition(String checkPosition) {
        this.checkPosition = checkPosition;
    }

    public DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @Override
    public String toString() {
        return "DicRadioTag{" +
                "name='" + name + '\'' +
                ", cssClass='" + cssClass + '\'' +
                ", styleClass='" + styleClass + '\'' +
                ", parentId=" + parentId +
                ", checkPositions='" + checkPosition + '\'' +
                ", dictionaryService=" + dictionaryService +
                '}';
    }
}
