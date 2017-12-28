package com.taiji.eap.common.webmagic;

import com.google.gson.JsonArray;
import com.taiji.eap.biz.zxjg.service.impl.ZxjgServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
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

    WebDriver driver = new ChromeDriver();

    @Override
    public void process(Page page) {
//        List<String> urls = page.getHtml().css("a.x-tree-node-anchor").links().regex(".*/bbgl_jksj.aspx/\\?siteid.*").all();
//        page.addTargetRequests(urls);
        if(!page.getRequest().getUrl().contains("siteid=")){
            String name = page.getHtml().xpath("//span[@class='hoverUeser']/text()").replace("▼","").replace("▲","").replace("  ","").get().trim();
            LOGGER.debug("企业名称："+name);
            String json = page.getHtml().regex("x_state: (([\\s\\S]*)})",1).get();
            LOGGER.debug(json);
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("X_Nodes");
                JSONArray jcdArray = jsonArray.getJSONArray(0).getJSONArray(20).getJSONArray(0).getJSONArray(20).getJSONArray(0).getJSONArray(20);
                List<String> jcdmcs = new ArrayList<>();
                for (int i = 0; i < jcdArray.length(); i++) {
                    jcdmcs.add(jcdArray.getJSONArray(i).getString(0));
                    page.addTargetRequest(jcdArray.getJSONArray(i).getString(9).replace("bbgl_jksj","bbgl_ihour"));
                    openDataPage("http://218.61.71.244:55555/"+jcdArray.getJSONArray(i).getString(9).replace("bbgl_jksj","bbgl_ihour"),page);
                }
                LOGGER.debug(jcdmcs.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void login(){
        driver.get("http://218.61.71.244:55555/Default.aspx");
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("F024003");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
        driver.findElement(By.id("ddd1")).click();
        cookies = driver.manage().getCookies();
    }

    public void openDataPage(String url,Page page){
        driver.get(url+"#parentHorizontalTab1");
        driver.manage().window().maximize();
        driver.findElement(By.id("date1")).clear();
        driver.findElement(By.id("date1")).sendKeys("2017-12-25");
        driver.findElement(By.id("date2")).clear();
        driver.findElement(By.id("date2")).sendKeys("2017-12-25");
        driver.findElement(By.id("Button5")).click();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://218.61.71.244:55555/data_hour1.aspx?p=1");
//        page.addTargetRequest("/data_hour1.aspx?p=1");
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='gradeX']"));

        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col:cols) {
                LOGGER.info(col.getText());
            }
        }

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
//        Spider.create(processor).addPipeline(new ZxjgServiceImpl()).addUrl("http://218.61.71.244:55555/bbgl_jksj.aspx");
    }


}
