package com.taiji.eap.biz.dmsctest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.dmsctest.bean.Dmsctest;
import com.taiji.eap.biz.dmsctest.dao.DmsctestDao;
import com.taiji.eap.biz.dmsctest.service.DmsctestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DmsctestServiceImpl implements DmsctestService{

    @Autowired
    private DmsctestDao dmsctestDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return dmsctestDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Dmsctest dmsctest) {
        return dmsctestDao.insert(dmsctest);
    }

    @Override
    public Dmsctest selectByPrimaryKey(Long primaryKey) {
        return dmsctestDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Dmsctest dmsctest) {
        return dmsctestDao.updateByPrimaryKey(dmsctest);
    }

    @Override
    public List<Dmsctest> list(String searchText) {
        return dmsctestDao.list(searchText);
    }

    @Override
    public PageInfo<Dmsctest> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Dmsctest> dmsctests = dmsctestDao.list(searchText);
        PageInfo<Dmsctest> pageInfo = new PageInfo<Dmsctest>(dmsctests);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Dmsctest dmsctest) {
        return dmsctestDao.insertSelective(dmsctest);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Dmsctest dmsctest) {
        return dmsctestDao.updateByPrimaryKeySelective(dmsctest);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Dmsctest> queryAll(Dmsctest dmsctest) {
        return dmsctestDao.queryAll(dmsctest);
    }
}