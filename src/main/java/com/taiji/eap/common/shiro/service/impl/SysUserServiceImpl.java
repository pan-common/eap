package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.dao.SysUserDao;
import com.taiji.eap.common.shiro.helper.PasswordHelper;
import com.taiji.eap.common.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private PasswordHelper passwordHelper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysUserDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysUser sysUser) {
        passwordHelper.encryptPassword(sysUser);
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

    @Override
    public int easyuiSubmitData(EasyUISubmitData<SysUser> easyUISubmitData) {
        List<SysUser> inserted = easyUISubmitData.getInserted();
        List<SysUser> updated = easyUISubmitData.getUpdated();
        List<SysUser> deleted = easyUISubmitData.getDeleted();
        int k = 0;
        if(inserted!=null&&!inserted.isEmpty()) {
            for (int i = 0; i < inserted.size(); i++) {
                inserted.get(i).setCreateTime(new Date());
                inserted.get(i).setUpdateTime(new Date());
                inserted.get(i).setValid("1");
                inserted.get(i).setCreater(1L);
                k += sysUserDao.insert(inserted.get(i));
            }
        }
        if(deleted!=null&&!deleted.isEmpty()) {
            for (int i = 0; i < deleted.size(); i++) {
                k += sysUserDao.deleteByPrimaryKey(deleted.get(i).getUserId());
            }
        }
        if(updated!=null&&!updated.isEmpty()) {
            for (int i = 0; i < updated.size(); i++) {
                updated.get(i).setCreateTime(new Date());
                updated.get(i).setUpdateTime(new Date());
                updated.get(i).setValid("1");
                updated.get(i).setCreater(1L);
                k += sysUserDao.updateByPrimaryKey(updated.get(i));
            }
        }
        return k;
    }

    @Override
    public SysUser getUserByName(String username) {
        SysUser sysUser =  sysUserDao.getUserByName(username);
        return sysUser;
    }
}