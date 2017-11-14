package com.taiji.eap.common.chain.base;

import com.taiji.eap.common.form.element.bean.Element;
import com.taiji.eap.common.form.formconfColumn.bean.FormconfColumn;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

public abstract class FormElementHandler{

    protected String htmlCode;

    protected String jsCode;

    protected abstract void getHtmlCode();

    protected abstract void getJsCode();

    /**
     * 替换模板
     * @param path 模板路径
     * @param column 数据表列属性
     * @return
     */
    protected String replaceTemplate(String path, FormconfColumn column){
        Template template = Velocity.getTemplate(path);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("column",column);
        StringWriter sw = new StringWriter();
        template.merge(velocityContext,sw);
        return sw.toString();
    }

}
