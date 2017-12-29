package com.taiji.eap.biz.jcdxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.jcdxx.dao.JcdxxDao;
import com.taiji.eap.biz.jcdxx.service.JcdxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JcdxxServiceImpl implements JcdxxService{

    @Autowired
    private JcdxxDao jcdxxDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return jcdxxDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Jcdxx jcdxx) {
        return jcdxxDao.insert(jcdxx);
    }

    @Override
    public Jcdxx selectByPrimaryKey(Long primaryKey) {
        return jcdxxDao.selectByPrimaryKey(primaryKey);
    }

    @Override
    public List<Jcdxx> selectByQybh(String qybh) throws Exception {
        return jcdxxDao.selectByQybh(qybh);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Jcdxx jcdxx) {
        return jcdxxDao.updateByPrimaryKey(jcdxx);
    }

    @Override
    public List<Jcdxx> list(String searchText) {
        return jcdxxDao.list(searchText,null,null);
    }

    @Override
    public PageInfo<Jcdxx> list(int pageNum, int pageSize, String searchText, String qyhb, String jcdfl) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Jcdxx> jcdxxs = jcdxxDao.list(searchText,qyhb,jcdfl);
        PageInfo<Jcdxx> pageInfo = new PageInfo<Jcdxx>(jcdxxs);
        return pageInfo;
    }

}