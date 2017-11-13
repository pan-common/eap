package com.taiji.eap.common.form.formconfColumn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.form.formconfColumn.bean.FormconfColumn;
import com.taiji.eap.common.form.formconfColumn.dao.FormconfColumnDao;
import com.taiji.eap.common.form.formconfColumn.service.FormconfColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FormconfColumnServiceImpl implements FormconfColumnService{

    @Autowired
    private FormconfColumnDao formconfColumnDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return formconfColumnDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(FormconfColumn formconfColumn) {
        return formconfColumnDao.insert(formconfColumn);
    }

    @Override
    public FormconfColumn selectByPrimaryKey(Long primaryKey) {
        return formconfColumnDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(FormconfColumn formconfColumn) {
        return formconfColumnDao.updateByPrimaryKey(formconfColumn);
    }

    @Override
    public List<FormconfColumn> list(String searchText) {
        return formconfColumnDao.list(searchText);
    }

    @Override
    public PageInfo<FormconfColumn> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<FormconfColumn> formconfColumns = formconfColumnDao.list(searchText);
        PageInfo<FormconfColumn> pageInfo = new PageInfo<FormconfColumn>(formconfColumns);
        return pageInfo;
    }
}