
package com.taiji.eap.biz.spider.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Spider extends BaseModel{
    private Long spiderId;//主键  爬虫模块ID
    private String spiderName;//模块名称
    private String landingPage;//登陆页
    private String spiderClass;//爬虫模块类名

    public Long getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Long spiderId) {
        this.spiderId = spiderId;
    }


    public String getSpiderName() {
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }


    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }


    public String getSpiderClass() {
        return spiderClass;
    }

    public void setSpiderClass(String spiderClass) {
        this.spiderClass = spiderClass;
    }


}
