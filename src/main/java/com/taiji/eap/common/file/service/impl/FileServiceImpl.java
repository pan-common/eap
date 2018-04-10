package com.taiji.eap.common.file.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opslab.util.FileUtil;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.file.bean.CommonFileInfo;
import com.taiji.eap.common.file.dao.FileDao;
import com.taiji.eap.common.file.service.FileService;
import com.taiji.eap.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl extends BaseServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        //根据主键删除文件
        CommonFileInfo fileInfo = fileDao.selectByPrimaryKey(primaryKey);
        File file = new File(fileInfo.getAbsolutePath());
        FileUtil.deleteFile(file);
        return fileDao.deleteByPrimaryKey(primaryKey);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(CommonFileInfo file) {
        file.setFileId(UUIDUtils.getGUID());
        file.setUpdateTime(new Date());
        file.setCreater(getCurrentUser().getUserId());
        file.setCreateTime(new Date());
        file.setValid("1");
        return fileDao.insert(file);
    }

    @Override
    public CommonFileInfo selectByPrimaryKey(String primaryKey) {
        return fileDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
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