package com.taiji.eap.biz.spider.task;

import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import com.taiji.eap.biz.qyjbxx.service.QyjbxxService;
import com.taiji.eap.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
@Component("taskJob")
public class TaskJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskJob.class);

    @Autowired
    private QyjbxxService qyjbxxService;

    /**
     * 每天0点5分执行
     * @throws Exception
     */
    @Scheduled(cron = "0 05 0 ? * *")
    public void job() throws Exception {
        LOGGER.info("执行了定时任务"+ DateUtils.getNowTimeStr());
        List<Qyjbxx> qyjbxxes = qyjbxxService.list("");
        Date date = DateUtils.getFetureDate(-1);
        String yesterday = DateUtils.dateToString(date,"yyyy-MM-dd");
        for (int i = 0; i < qyjbxxes.size(); i++) {
            qyjbxxService.spider(qyjbxxes.get(i).getQybh(),yesterday,yesterday);
        }
    }

}
