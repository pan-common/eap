package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.dao.SysUserDao;
import com.taiji.eap.common.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysUserDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysUser sysUser) {
        return sysUserDao.insert(sysUser);
    }

    @Override
    public SysUser selectByPrimaryKey(Long primaryKey) {
        return sysUserDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysUser sysUser) {
        return sysUserDao.updateByPrimaryKey(sysUser);
    }

    @Override
    public List<SysUser> list(String searchText) {
        return sysUserDao.list(searchText);
    }

    @Override
    public PageInfo<SysUser> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUsers = sysUserDao.list(searchText);
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUsers);
        return pageInfo;
    }
}