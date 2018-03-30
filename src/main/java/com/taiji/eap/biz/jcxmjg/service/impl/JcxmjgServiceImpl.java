package com.taiji.eap.biz.jcxmjg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import com.taiji.eap.biz.jcxmjg.dao.JcxmjgDao;
import com.taiji.eap.biz.jcxmjg.service.JcxmjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JcxmjgServiceImpl implements JcxmjgService{

    @Autowired
    private JcxmjgDao jcxmjgDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return jcxmjgDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Jcxmjg jcxmjg) {
        return jcxmjgDao.insert(jcxmjg);
    }

    @Override
    public Jcxmjg selectByPrimaryKey(Long primaryKey) {
        return jcxmjgDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Jcxmjg jcxmjg) {
        return jcxmjgDao.updateByPrimaryKey(jcxmjg);
    }

    @Override
    public List<Jcxmjg> list(String searchText) {
        return jcxmjgDao.list(searchText);
    }

    @Override
    public PageInfo<Jcxmjg> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Jcxmjg> jcxmjgs = jcxmjgDao.list(searchText);
        PageInfo<Jcxmjg> pageInfo = new PageInfo<Jcxmjg>(jcxmjgs);
        return pageInfo;
    }
}