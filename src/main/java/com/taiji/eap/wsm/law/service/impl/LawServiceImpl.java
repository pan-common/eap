package com.taiji.eap.wsm.law.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.file.bean.CommonFileInfo;
import com.taiji.eap.common.file.dao.FileDao;
import com.taiji.eap.common.file.service.FileService;
import com.taiji.eap.common.utils.UUIDUtils;
import com.taiji.eap.wsm.law.bean.Law;
import com.taiji.eap.wsm.law.dao.LawDao;
import com.taiji.eap.wsm.law.service.LawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LawServiceImpl extends BaseServiceImpl implements LawService{

    @Autowired
    private LawDao lawDao;

    @Autowired
    private FileService fileService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) throws Exception {
        Law law = lawDao.selectByPrimaryKey(primaryKey);
        fileService.deleteByPrimaryKey(law.getFileId());
        return lawDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Law law) {
        law.setCreateUser(getCurrentUser().getUserId());
        law.setLawId(UUIDUtils.getGUID());
        law.setUpdateTime(new Date());
        return lawDao.insert(law);
    }

    @Override
    public Law selectByPrimaryKey(String primaryKey) {
        return lawDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Law law) {
        return lawDao.updateByPrimaryKey(law);
    }

    @Override
    public List<Law> list(String searchText) {
        return lawDao.list(searchText);
    }

    @Override
    public PageInfo<Law> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Law> laws = lawDao.list(searchText);
        PageInfo<Law> pageInfo = new PageInfo<Law>(laws);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Law law) {
        law.setCreateUser(getCurrentUser().getUserId());
        law.setLawId(UUIDUtils.getGUID());
        law.setUpdateTime(new Date());
        return lawDao.insertSelective(law);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Law law) {
        return lawDao.updateByPrimaryKeySelective(law);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Law> queryAll(Law law) {
        return lawDao.queryAll(law);
    }

    @Override
    public List<Law> selectAll() throws Exception {
        List<Law> laws = lawDao.selectAll();
        for (int i = 0; i < laws.size(); i++) {
            CommonFileInfo fileInfo = fileService.selectByPrimaryKey(laws.get(i).getFileId());
            laws.get(i).setFileInfo(fileInfo);
        }
        return laws;
    }
}