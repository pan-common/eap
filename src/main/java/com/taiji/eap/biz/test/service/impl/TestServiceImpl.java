package com.taiji.eap.biz.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.test.bean.Test;
import com.taiji.eap.biz.test.dao.TestDao;
import com.taiji.eap.biz.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return testDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Test test) {
        return testDao.insert(test);
    }

    @Override
    public Test selectByPrimaryKey(Long primaryKey) {
        return testDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Test test) {
        return testDao.updateByPrimaryKey(test);
    }

    @Override
    public List<Test> list(String searchText) {
        return testDao.list(searchText);
    }

    @Override
    public PageInfo<Test> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Test> tests = testDao.list(searchText);
        PageInfo<Test> pageInfo = new PageInfo<Test>(tests);
        return pageInfo;
    }
}