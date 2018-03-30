package com.taiji.eap.biz.yhysje.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.yhysje.bean.Yhysje;
import com.taiji.eap.biz.yhysje.dao.YhysjeDao;
import com.taiji.eap.biz.yhysje.service.YhysjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class YhysjeServiceImpl implements YhysjeService{

    @Autowired
    private YhysjeDao yhysjeDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return yhysjeDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Yhysje yhysje) {
        return yhysjeDao.insert(yhysje);
    }

    @Override
    public Yhysje selectByPrimaryKey(Long primaryKey) {
        return yhysjeDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Yhysje yhysje) {
        return yhysjeDao.updateByPrimaryKey(yhysje);
    }

    @Override
    public List<Yhysje> list(String searchText) {
        return yhysjeDao.list(searchText);
    }

    @Override
    public PageInfo<Yhysje> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Yhysje> yhysjes = yhysjeDao.list(searchText);
        PageInfo<Yhysje> pageInfo = new PageInfo<Yhysje>(yhysjes);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Yhysje yhysje) {
        return yhysjeDao.insertSelective(yhysje);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Yhysje yhysje) {
        return yhysjeDao.updateByPrimaryKeySelective(yhysje);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Yhysje> queryAll(Yhysje yhysje) {
        return yhysjeDao.queryAll(yhysje);
    }

    @Override
    public void importJk(InputStream inputStream) {

    }

    @Override
    public void importDk(InputStream inputStream) {

    }
}