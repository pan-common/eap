package com.taiji.eap.biz.zxjg.spider;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.Set;

/**
 * @author 潘宏智
 * @date
 */
public class CyswryzxxtSpider extends BaseSpider{


    public CyswryzxxtSpider(BaseProcessor processor, BasePipeline pipeline) {
        super(processor, pipeline);
    }

    @Override
    protected Set<Cookie> login(String loginUrl, String userName, String passWord) {
        processor.getDriver().get(loginUrl);
        processor.getDriver().findElement(By.id("user")).clear();
        processor.getDriver().findElement(By.id("user")).sendKeys(userName);
        processor.getDriver().findElement(By.id("pwd")).clear();
        processor.getDriver().findElement(By.id("pwd")).sendKeys(passWord);
        processor.getDriver().findElement(By.id("ddd1")).click();
        return processor.getDriver().manage().getCookies();
    }

    @Override
    protected String getMainUrl() {
        return "http://218.61.71.244:55555/bbgl_jksj.aspx";
    }

}
