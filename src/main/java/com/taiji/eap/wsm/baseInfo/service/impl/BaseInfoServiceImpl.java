package com.taiji.eap.wsm.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.common.shiro.service.SysUserService;
import com.taiji.eap.common.utils.UUIDUtils;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import com.taiji.eap.wsm.baseInfo.dao.BaseInfoDao;
import com.taiji.eap.wsm.baseInfo.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BaseInfoServiceImpl extends BaseServiceImpl implements BaseInfoService{

    @Autowired
    private BaseInfoDao baseInfoDao;

    @Autowired
    private SysUserService sysUserService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        BaseInfo baseInfo = baseInfoDao.selectByPrimaryKey(primaryKey);
        try {
            sysUserService.deleteByPrimaryKey(baseInfo.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseInfoDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(BaseInfo baseInfo) {
        SysUser sysUser = new SysUser();
        sysUser.setCreater(getCurrentUser().getUserId());
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setLocked(1);
        sysUser.setValid("1");
        sysUser.setUserName(baseInfo.getPhoneNumber());
        sysUser.setPassword("8888");
        sysUser.setSalt(UUIDUtils.getGUID());
        sysUser.setSeq(1);
        try {
            sysUserService.insert(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseInfo.setUserId(sysUser.getUserId());
        baseInfo.setBaseId(UUIDUtils.getGUID());
        baseInfo.setCreateTime(new Date());
        baseInfo.setValid("1");
        baseInfo.setUpdateTime(new Date());
        return baseInfoDao.insert(baseInfo);
    }

    @Override
    public BaseInfo selectByPrimaryKey(String primaryKey) {
        return baseInfoDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(BaseInfo baseInfo) {
        SysUser sysUser = null;
        Long userId = baseInfoDao.selectByPrimaryKey(baseInfo.getBaseId()).getUserId();
        try {
            sysUser = sysUserService.selectByPrimaryKey(userId);
            sysUser.setPassword("8888");
            sysUser.setUserName(baseInfo.getPhoneNumber());
            sysUserService.updateByPrimaryKey(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseInfo.setUpdateTime(new Date());
        return baseInfoDao.updateByPrimaryKeySelective(baseInfo);
    }

    @Override
    public List<BaseInfo> list(String searchText) {
        return baseInfoDao.list(searchText);
    }

    @Override
    public PageInfo<BaseInfo> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<BaseInfo> baseInfos = baseInfoDao.list(searchText);
        for (int i = 0; i < baseInfos.size(); i++) {
            SysUser sysUser = sysUserService.selectByPrimaryKey(baseInfos.get(i).getUserId());
            baseInfos.get(i).setUserName(sysUser.getUserName());
        }
        PageInfo<BaseInfo> pageInfo = new PageInfo<BaseInfo>(baseInfos);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(BaseInfo baseInfo) {
        baseInfo.setBaseId(UUIDUtils.getGUID());
        baseInfo.setCreateTime(new Date());
        baseInfo.setValid("1");
        baseInfo.setUpdateTime(new Date());
        return baseInfoDao.insertSelective(baseInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(BaseInfo baseInfo) {
        return baseInfoDao.updateByPrimaryKeySelective(baseInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<BaseInfo> queryAll(BaseInfo baseInfo) {
        return baseInfoDao.queryAll(baseInfo);
    }

    @Override
    public BaseInfo selectOneByUserId(String userId) {
        return baseInfoDao.selectOneByUserId(Long.valueOf(userId));
    }
}