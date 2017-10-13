package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.shiro.bean.SysOrgan;
import com.taiji.eap.common.shiro.dao.SysOrganDao;
import com.taiji.eap.common.shiro.service.SysOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysOrganServiceImpl implements SysOrganService{

    @Autowired
    private SysOrganDao sysOrganDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysOrganDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysOrgan sysOrgan) {
        return sysOrganDao.insert(sysOrgan);
    }

    @Override
    public SysOrgan selectByPrimaryKey(Long primaryKey) {
        return sysOrganDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysOrgan sysOrgan) {
        return sysOrganDao.updateByPrimaryKey(sysOrgan);
    }

    @Override
    public List<SysOrgan> list(String searchText) {
        return sysOrganDao.list(searchText);
    }

    @Override
    public PageInfo<SysOrgan> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysOrgan> sysOrgans = sysOrganDao.list(searchText);
        PageInfo<SysOrgan> pageInfo = new PageInfo<SysOrgan>(sysOrgans);
        return pageInfo;
    }

    @Override
    public List<SysOrgan> listByPid(Long parentId) throws Exception {
        return sysOrganDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<SysOrgan> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<SysOrgan> list = sysOrganDao.listByPid(parentId,searchText);
        PageInfo<SysOrgan> pageInfo = new PageInfo<SysOrgan>(list);
        return pageInfo;
    }

    @Override
    public List<SysOrgan> getPath(Long organId) throws Exception {
        List<SysOrgan> list = new ArrayList<SysOrgan>();
        if(organId!=0){
            disPlay(organId, list);
        }
        list.add(new SysOrgan(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    private void disPlay(Long organId,List<SysOrgan> list){
    SysOrgan sysOrgan = sysOrganDao.selectByPrimaryKey(organId);
        if(sysOrgan!=null){
            list.add(sysOrgan);
            disPlay(sysOrgan.getParentId(), list);
        }
    }
}