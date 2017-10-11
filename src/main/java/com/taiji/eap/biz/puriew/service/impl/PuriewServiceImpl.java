
package com.taiji.eap.biz.puriew.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.puriew.bean.Puriew;
import com.taiji.eap.biz.puriew.dao.PuriewDao;
import com.taiji.eap.biz.puriew.service.PuriewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PuriewServiceImpl implements PuriewService{

    @Autowired
    private PuriewDao puriewDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return puriewDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Puriew puriew) {
        return puriewDao.insert(puriew);
    }

    @Override
    public Puriew selectByPrimaryKey(Long primaryKey) {
        return puriewDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Puriew puriew) {
        return puriewDao.updateByPrimaryKey(puriew);
    }

    @Override
    public List<Puriew> list(String searchText) {
        return puriewDao.list(searchText);
    }

    @Override
    public PageInfo<Puriew> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Puriew> puriews = puriewDao.list(searchText);
        PageInfo<Puriew> pageInfo = new PageInfo<Puriew>(puriews);
        return pageInfo;
    }

}