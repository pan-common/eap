package com.taiji.eap.biz.zxjg.spider;

import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import com.taiji.eap.biz.zxjg.service.ZxjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
@Component
public class CyswryzxxtPipeline extends BasePipeline{

    @Autowired
    private ZxjgService zxjgService;

    public void setJcdxxes(List<Jcdxx> jcdxxes){
        this.jcdxxes = jcdxxes;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        if(jcdxxes!=null) {
            for (int i = 0; i < jcdxxes.size(); i++) {
                List<Zxjg> zxjgs = resultItems.get(jcdxxes.get(i).getJcdbh());
                try {
                    if (zxjgs != null) {
                        zxjgService.plInser(zxjgs);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
