package com.taiji.eap.biz.jcxm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.jcxm.bean.Jcxm;
import com.taiji.eap.biz.jcxm.dao.JcxmDao;
import com.taiji.eap.biz.jcxm.service.JcxmService;
import com.taiji.eap.common.datasource.annotation.DataSource;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("JcxmService")
@DataSource("oracle")
public class JcxmServiceImpl implements JcxmService{

    @Autowired
    private JcxmDao jcxmDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return jcxmDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Jcxm jcxm) {
        return jcxmDao.insert(jcxm);
    }

    @Override
    public Jcxm selectByPrimaryKey(Long primaryKey) {
        return jcxmDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Jcxm jcxm) {
        return jcxmDao.updateByPrimaryKey(jcxm);
    }

    @Override
    public List<Jcxm> list(String searchText) {
        return jcxmDao.list(searchText,null,null);
    }

    @Override
    public PageInfo<Jcxm> list(int pageNum, int pageSize, String searchText, String qybh, String jcdbh) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Jcxm> jcxms = jcxmDao.list(searchText,qybh,jcdbh);
        PageInfo<Jcxm> pageInfo = new PageInfo<Jcxm>(jcxms);
        return pageInfo;
    }

    @Override
    public List<Jcxm> listByJcdbh(String qybh, String jcdbh) {
        return jcxmDao.list(null,qybh,jcdbh);
    }

    @Override
    @DataSource("jcpt")
    public List<Dictionary> getJcxmByJcdbh(String qybh, String jcdbh) {
        return jcxmDao.getJcxmByJcdbh(qybh,jcdbh);
    }
}