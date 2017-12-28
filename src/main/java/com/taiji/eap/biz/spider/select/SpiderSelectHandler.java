package com.taiji.eap.biz.spider.select;

import com.taiji.eap.biz.spider.bean.Spider;
import com.taiji.eap.biz.spider.service.SpiderService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public class SpiderSelectHandler extends SelectCommonDataSourceHandler<Spider>{

    @Autowired
    private SpiderService spiderService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("spider")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "spiderId";
    }

    @Override
    public String getValueName() {
        return "spiderName";
    }

    @Override
    public List<Spider> getDataSource(String... params) throws Exception {
        List<Spider> spiders = spiderService.list("");
        return spiders;
    }

    @Override
    public Class<Spider> getDataSourceClass() {
        return Spider.class;
    }

}
