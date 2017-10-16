package com.taiji.eap.common.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.bean.GenerateConf;
import com.taiji.eap.common.generator.dao.GenerateConfDao;
import com.taiji.eap.common.generator.service.GenerateConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GenerateConfServiceImpl implements GenerateConfService{

    @Autowired
    private GenerateConfDao generateConfDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return generateConfDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(GenerateConf generateConf) {
        return generateConfDao.insert(generateConf);
    }

    @Override
    public GenerateConf selectByPrimaryKey(Long primaryKey) {
        return generateConfDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(GenerateConf generateConf) {
        return generateConfDao.updateByPrimaryKey(generateConf);
    }

    @Override
    public List<GenerateConf> list(String searchText) {
        return generateConfDao.list(searchText);
    }

    @Override
    public PageInfo<GenerateConf> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<GenerateConf> generateConfs = generateConfDao.list(searchText);
        PageInfo<GenerateConf> pageInfo = new PageInfo<GenerateConf>(generateConfs);
        return pageInfo;
    }
}