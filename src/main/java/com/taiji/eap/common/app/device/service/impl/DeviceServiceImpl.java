package com.taiji.eap.common.app.device.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.app.device.bean.Device;
import com.taiji.eap.common.app.device.dao.DeviceDao;
import com.taiji.eap.common.app.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceDao deviceDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        return deviceDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Device device) {
        return deviceDao.insert(device);
    }

    @Override
    public Device selectByPrimaryKey(String primaryKey) {
        return deviceDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Device device) {
        return deviceDao.updateByPrimaryKey(device);
    }

    @Override
    public List<Device> list(String searchText) {
        return deviceDao.list(searchText);
    }

    @Override
    public PageInfo<Device> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Device> devices = deviceDao.list(searchText);
        PageInfo<Device> pageInfo = new PageInfo<Device>(devices);
        return pageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Device device) {
        return deviceDao.insertSelective(device);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Device device) {
        return deviceDao.updateByPrimaryKeySelective(device);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Device> queryAll(Device device) {
        return deviceDao.queryAll(device);
    }
}