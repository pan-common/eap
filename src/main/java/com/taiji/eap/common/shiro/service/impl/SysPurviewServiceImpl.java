package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.shiro.bean.SysPurview;
import com.taiji.eap.common.shiro.dao.SysPurviewDao;
import com.taiji.eap.common.shiro.dao.SysPurviewResourceDao;
import com.taiji.eap.common.shiro.service.SysPurviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SysPurviewServiceImpl implements SysPurviewService {

    @Autowired
    private SysPurviewDao sysPurviewDao;

    @Autowired
    private SysPurviewResourceDao sysPurviewResourceDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysPurviewDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysPurview sysPurview) {
        return sysPurviewDao.insert(sysPurview);
    }

    @Override
    public SysPurview selectByPrimaryKey(Long primaryKey) {
        return sysPurviewDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysPurview sysPurview) {
        return sysPurviewDao.updateByPrimaryKey(sysPurview);
    }

    @Override
    public List<SysPurview> list(String searchText) {
        return sysPurviewDao.list(searchText);
    }

    @Override
    public PageInfo<SysPurview> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysPurview> sysPurviews = sysPurviewDao.list(searchText);
        PageInfo<SysPurview> pageInfo = new PageInfo<SysPurview>(sysPurviews);
        return pageInfo;
    }

    @Override
    public List<SysPurview> getPuriewByResourceIds(List<Long> resourceIds) {
        List<Long> puriewIds = sysPurviewResourceDao.getPuriewByResourceIds(resourceIds);
        List<SysPurview> sysPurviews = sysPurviewDao.listByIds(puriewIds);
        return sysPurviews;
    }

    @Override
    public List<Map<String, Object>> globalConfig() {
        return sysPurviewDao.globalConfig();
    }
}