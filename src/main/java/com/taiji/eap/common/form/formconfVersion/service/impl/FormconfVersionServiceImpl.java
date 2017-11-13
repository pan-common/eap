package com.taiji.eap.common.form.formconfVersion.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.form.formconfVersion.bean.FormconfVersion;
import com.taiji.eap.common.form.formconfVersion.dao.FormconfVersionDao;
import com.taiji.eap.common.form.formconfVersion.service.FormconfVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FormconfVersionServiceImpl implements FormconfVersionService{

    @Autowired
    private FormconfVersionDao formconfVersionDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return formconfVersionDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(FormconfVersion formconfVersion) {
        return formconfVersionDao.insert(formconfVersion);
    }

    @Override
    public FormconfVersion selectByPrimaryKey(Long primaryKey) {
        return formconfVersionDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(FormconfVersion formconfVersion) {
        return formconfVersionDao.updateByPrimaryKey(formconfVersion);
    }

    @Override
    public List<FormconfVersion> list(String searchText) {
        return formconfVersionDao.list(searchText,null);
    }

    @Override
    public PageInfo<FormconfVersion> list(int pageNum, int pageSize, String searchText, FormconfVersion formconfVersion) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<FormconfVersion> formconfVersions = formconfVersionDao.list(searchText,formconfVersion.getFormId());
        PageInfo<FormconfVersion> pageInfo = new PageInfo<FormconfVersion>(formconfVersions);
        return pageInfo;
    }

    @Override
    public List<FormconfVersion> listByFormId(Long formId) {
        return formconfVersionDao.listByFormId(formId);
    }

}