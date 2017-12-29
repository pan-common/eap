package com.taiji.eap.biz.spider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.spider.bean.Spider;
import com.taiji.eap.biz.spider.dao.SpiderDao;
import com.taiji.eap.biz.spider.service.SpiderService;
import com.taiji.eap.common.datasource.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@DataSource("oracle")
public class SpiderServiceImpl implements SpiderService{

    @Autowired
    private SpiderDao spiderDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return spiderDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Spider spider) {
        return spiderDao.insert(spider);
    }

    @Override
    public Spider selectByPrimaryKey(Long primaryKey) {
        return spiderDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Spider spider) {
        return spiderDao.updateByPrimaryKey(spider);
    }

    @Override
    public List<Spider> list(String searchText) {
        return spiderDao.list(searchText);
    }

    @Override
    public PageInfo<Spider> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Spider> spiders = spiderDao.list(searchText);
        PageInfo<Spider> pageInfo = new PageInfo<Spider>(spiders);
        return pageInfo;
    }
}