package com.taiji.eap.biz.zxjg.spider;

import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
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

    public CyswryzxxtProcessor(List<Jcdxx> jcdxxes) {
        super(jcdxxes);
    }

    @Override
    protected void doProcess(Page page) {
        if(!page.getRequest().getUrl().contains("siteid=")){
            String json = page.getHtml().regex("x_state: (([\\s\\S]*)})",1).get();
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
                chromeDriver.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void openDataPage(String url,Page page){
        chromeDriver.get(url+"#parentHorizontalTab1");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("date1")).clear();
        chromeDriver.findElement(By.id("date1")).sendKeys("2017-12-25");
        chromeDriver.findElement(By.id("date2")).clear();
        chromeDriver.findElement(By.id("date2")).sendKeys("2017-12-25");
        chromeDriver.findElement(By.id("Button5")).click();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.get("http://218.61.71.244:55555/data_hour1.aspx?p=1");
        List<WebElement> rows = chromeDriver.findElements(By.xpath("//tr[@class='gradeX']"));
        List<Zxjg> zxjgs = new ArrayList<>();
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (int i = 0; i < jcdxxes.size(); i++) {
                if(cols.get(0).getText().equals(jcdxxes.get(i).getJcdmc())){
                    Zxjg zxjg = new Zxjg();
                    zxjg.setQybh(jcdxxes.get(i).getQybh());
                    zxjg.setJcdbh(jcdxxes.get(i).getJcdbh());
                    zxjg.setJcdmc(cols.get(0).getText());
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
                    zxjgs.add(zxjg);
                }
            }
        }
        if(!zxjgs.isEmpty()) {
            page.putField(zxjgs.get(0).getJcdbh(), zxjgs);
        }
    }
}
