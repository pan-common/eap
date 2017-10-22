package com.taiji.eap.biz.qyjcxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.dao.QyjcxxDao;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QyjcxxServiceImpl implements QyjcxxService{

    @Autowired
    private QyjcxxDao qyjcxxDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return qyjcxxDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Qyjcxx qyjcxx) {
        return qyjcxxDao.insert(qyjcxx);
    }

    @Override
    public Qyjcxx selectByPrimaryKey(Long primaryKey) {
        return qyjcxxDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Qyjcxx qyjcxx) {
        return qyjcxxDao.updateByPrimaryKey(qyjcxx);
    }

    @Override
    public List<Qyjcxx> list(String searchText) {
        return qyjcxxDao.list(searchText);
    }

    @Override
    public PageInfo<Qyjcxx> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Qyjcxx> qyjcxxs = qyjcxxDao.list(searchText);
        PageInfo<Qyjcxx> pageInfo = new PageInfo<Qyjcxx>(qyjcxxs);
        return pageInfo;
    }

    @Override
    public int easyuiSubmitData(EasyUISubmitData<Qyjcxx> easyUISubmitData) {
        List<Qyjcxx> inserted = easyUISubmitData.getInserted();
        List<Qyjcxx> updated = easyUISubmitData.getUpdated();
        List<Qyjcxx> deleted = easyUISubmitData.getDeleted();
        int k = 0;
        if(inserted!=null&&!inserted.isEmpty()) {
            for (int i = 0; i < inserted.size(); i++) {
                k += qyjcxxDao.insert(inserted.get(i));
            }
        }
        if(deleted!=null&&!deleted.isEmpty()) {
            for (int i = 0; i < deleted.size(); i++) {
                k += qyjcxxDao.deleteByPrimaryKey(deleted.get(i).getId());
            }
        }
        if(updated!=null&&!updated.isEmpty()) {
            for (int i = 0; i < updated.size(); i++) {
                k += qyjcxxDao.updateByPrimaryKey(updated.get(i));
            }
        }
        return k;
    }
}