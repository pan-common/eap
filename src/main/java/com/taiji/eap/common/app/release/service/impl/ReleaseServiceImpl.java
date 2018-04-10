package com.taiji.eap.common.app.release.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.app.release.bean.Release;
import com.taiji.eap.common.app.release.dao.ReleaseDao;
import com.taiji.eap.common.app.release.service.ReleaseService;
import com.taiji.eap.common.file.service.FileService;
import com.taiji.eap.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{

    @Autowired
    private ReleaseDao releaseDao;

    @Autowired
    private FileService fileService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) throws Exception {
        Release release = releaseDao.selectByPrimaryKey(primaryKey);
        fileService.deleteByPrimaryKey(release.getFileId());
        return releaseDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Release release) {
        release.setVersionId(UUIDUtils.getGUID());
        release.setUpdatetime(new Date());
        return releaseDao.insert(release);
    }

    @Override
    public Release selectByPrimaryKey(String primaryKey) {
        return releaseDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Release release) {
        release.setUpdatetime(new Date());
        return releaseDao.updateByPrimaryKey(release);
    }

    @Override
    public List<Release> list(String searchText) {
        return releaseDao.list(searchText);
    }

    @Override
    public PageInfo<Release> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Release> releases = releaseDao.list(searchText);
        PageInfo<Release> pageInfo = new PageInfo<Release>(releases);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Release release) {
        release.setVersionId(UUIDUtils.getGUID());
        release.setUpdatetime(new Date());
        return releaseDao.insertSelective(release);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Release release) {
        release.setUpdatetime(new Date());
        return releaseDao.updateByPrimaryKeySelective(release);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Release> queryAll(Release release) {
        return releaseDao.queryAll(release);
    }

    @Override
    public Release getLastVersion() {
        return releaseDao.getLastVersion();
    }
}