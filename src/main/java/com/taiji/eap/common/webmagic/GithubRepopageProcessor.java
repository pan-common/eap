package com.taiji.eap.common.webmagic;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Set;

/**
 * @author 潘宏智
 * @date
 */
public class GithubRepopageProcessor implements PageProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubRepopageProcessor.class);
    /**
     * 抓取网站相关配置  抓取间隔  重试次数
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(0).setTimeOut(3000);

    private Set<Cookie> cookies;

    @Override
    public void process(Page page) {
//        List<String> urls = page.getHtml().css("a.x-tree-node-anchor").links().regex(".*/bbgl_jksj.aspx/\\?siteid.*").all();
//        page.addTargetRequests(urls);
        String name = page.getHtml().xpath("//span[@class='hoverUeser']/text()").replace("▼","").get().trim();
        LOGGER.debug("企业名称："+name);
        String json = page.getHtml().regex("x_state: (([\\s\\S]*)})",1).get();
        LOGGER.debug(json);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("X_Nodes");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void login(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://218.61.71.244:55555/Default.aspx");
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("F024003");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
        driver.findElement(By.id("ddd1")).click();
        cookies = driver.manage().getCookies();
        driver.close();
    }

    @Override
    public Site getSite() {
        for (Cookie cookie: cookies) {
            site.addCookie(cookie.getName().toString(),cookie.getValue().toString());
        }
        return site.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1");
    }

    public static void main(String[] args){
        GithubRepopageProcessor processor = new GithubRepopageProcessor();
        processor.login();
        //从 url 开始  开启5个线程抓取
        Spider.create(processor).addUrl("http://218.61.71.244:55555/bbgl_jksj.aspx").run();
    }

}
