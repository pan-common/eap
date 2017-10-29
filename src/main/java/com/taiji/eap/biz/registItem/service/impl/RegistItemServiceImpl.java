package com.taiji.eap.biz.registItem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.registItem.bean.RegistItem;
import com.taiji.eap.biz.registItem.dao.RegistItemDao;
import com.taiji.eap.biz.registItem.service.RegistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RegistItemServiceImpl implements RegistItemService{

    @Autowired
    private RegistItemDao registItemDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return registItemDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(RegistItem registItem) {
        return registItemDao.insert(registItem);
    }

    @Override
    public RegistItem selectByPrimaryKey(Long primaryKey) {
        return registItemDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(RegistItem registItem) {
        return registItemDao.updateByPrimaryKey(registItem);
    }

    @Override
    public List<RegistItem> list(String searchText) {
        return registItemDao.list(searchText);
    }

    @Override
    public PageInfo<RegistItem> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<RegistItem> registItems = registItemDao.list(searchText);
        PageInfo<RegistItem> pageInfo = new PageInfo<RegistItem>(registItems);
        return pageInfo;
    }
}