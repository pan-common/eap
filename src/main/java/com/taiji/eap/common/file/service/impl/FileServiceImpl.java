package com.taiji.eap.common.file.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.file.bean.CommonFileInfo;
import com.taiji.eap.common.file.dao.FileDao;
import com.taiji.eap.common.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return fileDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(CommonFileInfo file) {
        return fileDao.insert(file);
    }

    @Override
    public CommonFileInfo selectByPrimaryKey(Long primaryKey) {
        return fileDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(CommonFileInfo file) {
        return fileDao.updateByPrimaryKey(file);
    }

    @Override
    public List<CommonFileInfo> list(String searchText) {
        return fileDao.list(searchText);
    }

    @Override
    public PageInfo<CommonFileInfo> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<CommonFileInfo> files = fileDao.list(searchText);
        PageInfo<CommonFileInfo> pageInfo = new PageInfo<CommonFileInfo>(files);
        return pageInfo;
    }
}