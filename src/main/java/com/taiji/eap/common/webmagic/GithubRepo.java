package com.taiji.eap.common.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author 潘宏智
 * @date
 */
@TargetUrl("https://github.com/\\w+/\\w+")
@HelpUrl("https://github.com/\\w+")
public class GithubRepo implements AfterExtractor{

    @ExtractBy(value = "//h1[@class='entry-title public']/strong/a/text()",notNull = true)
    private String name;
    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String author;
    @ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;

    public static void main(String[] args){
        OOSpider.create(Site.me().setSleepTime(1000),new ConsolePageModelPipeline(),GithubRepo.class)
                .addUrl("https://github.com/code4craft").thread(5).run();
    }

    @Override
    public void afterProcess(Page page) {
        //抽取结束调用
    }
}
