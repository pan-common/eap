package com.taiji.eap.biz.zxjg.spider;

import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.jcxm.bean.Jcxm;
import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public class CyswryzxxtProcessor extends BaseProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(CyswryzxxtProcessor.class);

    public CyswryzxxtProcessor(List<Jcdxx> jcdxxes, String startDate, String endDate) {
        super(jcdxxes, startDate, endDate);
    }

    @Override
    protected void doProcess(Page page) {
        if(!page.getRequest().getUrl().contains("siteid=")){
            String json = page.getHtml().regex("x_state: (([\\s\\S]*)})",1).get();
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("X_Nodes");
                JSONArray jcdArray = jsonArray.getJSONArray(0).getJSONArray(20).getJSONArray(0).getJSONArray(20).getJSONArray(0).getJSONArray(20);
                for (int i = 0; i < jcdArray.length(); i++) {
                    String jcdmc = jcdArray.getJSONArray(i).getString(0);
                    page.addTargetRequest(jcdArray.getJSONArray(i).getString(9).replace("bbgl_jksj","bbgl_ihour"));
                    openDataPage("http://218.61.71.244:55555/"+jcdArray.getJSONArray(i).getString(9).replace("bbgl_jksj","bbgl_ihour"),page,jcdmc);
                }
                chromeDriver.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void openDataPage(String url,Page page,String jcdmc){
        chromeDriver.get(url+"#parentHorizontalTab1");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("date1")).clear();
        chromeDriver.findElement(By.id("date1")).sendKeys(startDate);
        chromeDriver.findElement(By.id("date2")).clear();
        chromeDriver.findElement(By.id("date2")).sendKeys(endDate);
        chromeDriver.findElement(By.id("Button5")).click();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.get("http://218.61.71.244:55555/data_hour1.aspx?p=1");
        List<Zxjg> zxjgs = new ArrayList<>();
        getData(zxjgs,jcdmc);
        try {
            int total =  Integer.valueOf(chromeDriver.findElement(By.id("GridView1_ctl28_lblPageCount")).getText());
            if(total>1){
                getNextPageData(total-1,zxjgs,page,jcdmc);
            }else {
                if(!zxjgs.isEmpty()) {
                    page.putField(zxjgs.get(0).getJcdbh(), zxjgs);
                }
            }
        } catch (NoSuchElementException e) {
            LOGGER.error("不需要动态分页！");
            if(!zxjgs.isEmpty()) {
                page.putField(zxjgs.get(0).getJcdbh(), zxjgs);
            }
        }

    }

    /**
     * 获取下一页数据
     * @param pageNum
     * @param zxjgs
     * @param page
     */
    public void getNextPageData(int pageNum,List<Zxjg> zxjgs,Page page,String jcdmc){
        for (int i = 0; i < pageNum; i++) {
            chromeDriver.findElement(By.id("GridView1_ctl28_btnNext")).click();
            getData(zxjgs,jcdmc);
        }
        if(!zxjgs.isEmpty()) {
            page.putField(zxjgs.get(0).getJcdbh(), zxjgs);
        }
    }

    /**
     * 获取数据
     * @param zxjgs
     */
    public void getData(List<Zxjg> zxjgs,String jcdmc){
        List<WebElement> rows = chromeDriver.findElements(By.xpath("//tr[@class='gradeX']"));
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (int i = 0; i < jcdxxes.size(); i++) {
                if(jcdmc.equals(jcdxxes.get(i).getJcdmc())){
                    Zxjg zxjg = new Zxjg();
                    zxjg.setQybh(jcdxxes.get(i).getQybh());
                    zxjg.setJcdfl(jcdxxes.get(i).getJcdfl());
                    zxjg.setJcdbh(jcdxxes.get(i).getJcdbh());
                    zxjg.setJcdmc(jcdmc);
                    zxjg.setSj(cols.get(1).getText());
                    zxjg.setKlwnd(cols.get(2).getText());
                    zxjg.setKlwzsnd(cols.get(3).getText());
                    zxjg.setKlwzl(cols.get(4).getText());
                    zxjg.setEyhlnd(cols.get(5).getText());
                    zxjg.setEyhlzsnd(cols.get(6).getText());
                    zxjg.setEyhlzl(cols.get(7).getText());
                    zxjg.setDyhwnd(cols.get(8).getText());
                    zxjg.setDyhwzsnd(cols.get(9).getText());
                    zxjg.setDyhwzl(cols.get(10).getText());
                    zxjg.setBgll(cols.get(11).getText());
                    zxjg.setYl(cols.get(12).getText());
                    zxjg.setYw(cols.get(13).getText());
                    zxjg.setHsl(cols.get(14).getText());
                    zxjg.setGzxx(cols.get(15).getText());
                    zxjg.setBz(cols.get(16).getText());
                    zxjg.setSfyz(cols.get(17).getText());

                    List<Jcxmjg> jcxmjgs = new ArrayList<>();
                    List<Jcxm> jcxms = jcxmService.listByJcdbh(jcdxxes.get(i).getQybh(),jcdxxes.get(i).getJcdbh());
                    for (Jcxm jcxm: jcxms) {
                        Jcxmjg jcxmjg = new Jcxmjg();
                        if("01".equals(jcxm.getWrwbm())){
                            //烟尘
                            jcxmjg.setWrwbm("01");
                            jcxmjg.setNd(cols.get(2).getText());
                            jcxmjg.setZsnd(cols.get(3).getText());
                            jcxmjg.setZl(cols.get(4).getText());
                        }else if("02".equals(jcxm.getWrwbm())){
                            //二氧化硫
                            jcxmjg.setWrwbm("02");
                            jcxmjg.setNd(cols.get(5).getText());
                            jcxmjg.setZsnd(cols.get(6).getText());
                            jcxmjg.setZl(cols.get(7).getText());
                        }else if("03".equals(jcxm.getWrwbm())){
                            //氮氧化物
                            jcxmjg.setWrwbm("03");
                            jcxmjg.setNd(cols.get(8).getText());
                            jcxmjg.setZsnd(cols.get(9).getText());
                            jcxmjg.setZl(cols.get(10).getText());
                        }
                        jcxmjg.setJcxmbh(jcxm.getJcxmbh());
                        jcxmjgs.add(jcxmjg);
                    }
                    zxjg.setJcxmjgs(jcxmjgs);
                    zxjgs.add(zxjg);
                }
            }
        }
    }
}
