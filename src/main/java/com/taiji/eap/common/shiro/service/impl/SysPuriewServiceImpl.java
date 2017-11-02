package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysPuriew;
import com.taiji.eap.common.shiro.dao.SysPuriewDao;
import com.taiji.eap.common.shiro.dao.SysPuriewResourceDao;
import com.taiji.eap.common.shiro.service.SysPuriewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysPuriewServiceImpl implements SysPuriewService{

    @Autowired
    private SysPuriewDao sysPuriewDao;

    @Autowired
    private SysPuriewResourceDao sysPuriewResourceDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysPuriewDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysPuriew sysPuriew) {
        return sysPuriewDao.insert(sysPuriew);
    }

    @Override
    public SysPuriew selectByPrimaryKey(Long primaryKey) {
        return sysPuriewDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysPuriew sysPuriew) {
        return sysPuriewDao.updateByPrimaryKey(sysPuriew);
    }

    @Override
    public List<SysPuriew> list(String searchText) {
        return sysPuriewDao.list(searchText);
    }

    @Override
    public PageInfo<SysPuriew> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysPuriew> sysPuriews = sysPuriewDao.list(searchText);
        PageInfo<SysPuriew> pageInfo = new PageInfo<SysPuriew>(sysPuriews);
        return pageInfo;
    }

    @Override
    public List<SysPuriew> getPuriewByResourceIds(List<Long> resourceIds) {
        List<Long> puriewIds = sysPuriewResourceDao.getPuriewByResourceIds(resourceIds);
        List<SysPuriew> sysPuriews = sysPuriewDao.listByIds(puriewIds);
        return sysPuriews;
    }
}