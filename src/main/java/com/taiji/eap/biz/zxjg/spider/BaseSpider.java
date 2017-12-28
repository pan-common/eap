package com.taiji.eap.biz.zxjg.spider;

import org.openqa.selenium.Cookie;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Set;

/**
 * @author 潘宏智
 * @date
 */
public abstract class BaseSpider{
    /**
     * 爬虫处理程序
     */
    protected BaseProcessor processor;
    /**
     * 结果处理程序
     */
    protected Pipeline pipeline;

    public BaseSpider(BaseProcessor processor,BasePipeline pipeline) {
        this.processor = processor;
        this.pipeline = pipeline;
    }

    /**
     * 模拟登陆
     * @param loginUrl 登陆url
     * @param userName 用户名
     * @param passWord 密码
     * @return
     */
    protected abstract Set<Cookie> login(String loginUrl,String userName,String passWord);

    public void start(String loginUrl,String userName,String passWord){
        processor.setCookies(login(loginUrl, userName, passWord));
        Spider.create(this.processor).addPipeline(this.pipeline).addUrl(getMainUrl()).run();
    }

    protected abstract String getMainUrl();

}
