package com.taiji.eap.biz.qyjbxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.jcdxx.dao.JcdxxDao;
import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import com.taiji.eap.biz.qyjbxx.dao.QyjbxxDao;
import com.taiji.eap.biz.qyjbxx.service.QyjbxxService;
import com.taiji.eap.biz.spider.bean.Spider;
import com.taiji.eap.biz.spider.dao.SpiderDao;
import com.taiji.eap.biz.zxjg.service.ZxjgService;
import com.taiji.eap.biz.zxjg.service.impl.ZxjgServiceImpl;
import com.taiji.eap.biz.zxjg.spider.CyswryzxxtPipeline;
import com.taiji.eap.biz.zxjg.spider.CyswryzxxtProcessor;
import com.taiji.eap.biz.zxjg.spider.CyswryzxxtSpider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QyjbxxServiceImpl implements QyjbxxService{

    @Autowired
    private QyjbxxDao qyjbxxDao;

    @Autowired
    private SpiderDao spiderDao;

    @Autowired
    private JcdxxDao jcdxxDao;

    @Autowired
    private CyswryzxxtPipeline pipeline;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return qyjbxxDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Qyjbxx qyjbxx) {
        return qyjbxxDao.insert(qyjbxx);
    }

    @Override
    public Qyjbxx selectByPrimaryKey(Long primaryKey) {
        return qyjbxxDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Qyjbxx qyjbxx) {
        return qyjbxxDao.updateByPrimaryKey(qyjbxx);
    }

    @Override
    public List<Qyjbxx> list(String searchText) {
        return qyjbxxDao.list(searchText);
    }

    @Override
    public PageInfo<Qyjbxx> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Qyjbxx> qyjbxxs = qyjbxxDao.list(searchText);
        PageInfo<Qyjbxx> pageInfo = new PageInfo<Qyjbxx>(qyjbxxs);
        return pageInfo;
    }

    @Override
    public void spider(Long id) {
        Qyjbxx qyjbxx = qyjbxxDao.selectByPrimaryKey(id);
        Spider s = spiderDao.selectByPrimaryKey(qyjbxx.getSpiderId());
        List<Jcdxx> jcdxxes = jcdxxDao.list(null,qyjbxx.getQybh(),null);
        CyswryzxxtProcessor processor = new CyswryzxxtProcessor(jcdxxes);
        pipeline.setJcdxxes(jcdxxes);
        CyswryzxxtSpider spider = new CyswryzxxtSpider(processor,pipeline);
        spider.start(s.getLandingPage(),qyjbxx.getLoginName(),qyjbxx.getLoginPw());
    }
}