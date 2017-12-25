package com.taiji.eap.common.form.formconf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.form.formconf.bean.Formconf;
import com.taiji.eap.common.form.formconf.dao.FormconfDao;
import com.taiji.eap.common.form.formconf.service.FormconfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormconfServiceImpl implements FormconfService{

    @Autowired
    private FormconfDao formconfDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return formconfDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Formconf formconf) {
        return formconfDao.insert(formconf);
    }

    @Override
    public Formconf selectByPrimaryKey(Long primaryKey) {
        return formconfDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Formconf formconf) {
        return formconfDao.updateByPrimaryKey(formconf);
    }

    @Override
    public List<Formconf> list(String searchText) {
        return formconfDao.list(searchText);
    }

    @Override
    public PageInfo<Formconf> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Formconf> formconfs = formconfDao.list(searchText);
        PageInfo<Formconf> pageInfo = new PageInfo<Formconf>(formconfs);
        return pageInfo;
    }
}