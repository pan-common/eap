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

public class DicCheckBoxTag extends TagSupport{

    private String name;
    private String cssClass;//样式类
    private String styleClass;//内联样式
    private Long parentId;//参数系统编码
    private String checkPositions;

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
            if(this.getCheckPositions()!=null) {
                if (checkPositions.equals("all")) {
                    sb.append("<input id=\"" + dictionaries.get(i).getKeystone() + "\" type=\"checkbox\" value=\"" + dictionaries.get(i).getValue() + "\" name=\"" + getName() + "\" title=\"" + dictionaries.get(i).getValue() + "\" lay-skin=\"primary\" checked>");
                } else {
                    String[] positions = checkPositions.split(",");
                    if (checkPosition(i, positions)) {
                        sb.append("<input id=\"" + dictionaries.get(i).getKeystone() + "\" type=\"checkbox\" value=\"" + dictionaries.get(i).getValue() + "\" name=\"" + getName() + "\" title=\"" + dictionaries.get(i).getValue() + "\" lay-skin=\"primary\" checked>");
                    } else {
                        sb.append("<input id=\"" + dictionaries.get(i).getKeystone() + "\" type=\"checkbox\" value=\"" + dictionaries.get(i).getValue() + "\" name=\"" + getName() + "\" title=\"" + dictionaries.get(i).getValue() + "\" lay-skin=\"primary\" >");
                    }
                }
            }else {
                sb.append("<input id=\"" + dictionaries.get(i).getKeystone() + "\" type=\"checkbox\" value=\"" + dictionaries.get(i).getValue() + "\" name=\"" + getName() + "\" title=\"" + dictionaries.get(i).getValue() + "\" lay-skin=\"primary\" >");
            }
        }
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
    }

    public boolean checkPosition(int i,String[] positions){
        boolean flag = false;
        for (String position:positions) {
            if(position.equals(String.valueOf(i))){
                flag = true;
            }
        }
        return flag;
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

    public String getCheckPositions() {
        return checkPositions;
    }

    public void setCheckPositions(String checkPositions) {
        this.checkPositions = checkPositions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DicCheckBoxTag{" +
                "id='" + id + '\'' +
                ", cssClass='" + cssClass + '\'' +
                ", styleClass='" + styleClass + '\'' +
                ", parentId=" + parentId +
                ", checkPositions='" + checkPositions + '\'' +
                ", dictionaryService=" + dictionaryService +
                '}';
    }
}
