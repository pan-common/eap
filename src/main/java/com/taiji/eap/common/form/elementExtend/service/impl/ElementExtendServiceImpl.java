package com.taiji.eap.common.form.elementExtend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.form.elementExtend.bean.ElementExtend;
import com.taiji.eap.common.form.elementExtend.dao.ElementExtendDao;
import com.taiji.eap.common.form.elementExtend.service.ElementExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElementExtendServiceImpl implements ElementExtendService{

    @Autowired
    private ElementExtendDao elementExtendDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return elementExtendDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(ElementExtend elementExtend) {
        return elementExtendDao.insert(elementExtend);
    }

    @Override
    public ElementExtend selectByPrimaryKey(Long primaryKey) {
        return elementExtendDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(ElementExtend elementExtend) {
        return elementExtendDao.updateByPrimaryKey(elementExtend);
    }

    @Override
    public List<ElementExtend> list(String searchText) {
        return elementExtendDao.list(searchText);
    }

    @Override
    public PageInfo<ElementExtend> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<ElementExtend> elementExtends = elementExtendDao.list(searchText);
        PageInfo<ElementExtend> pageInfo = new PageInfo<ElementExtend>(elementExtends);
        return pageInfo;
    }

    @Override
    public List<ElementExtend> elementExtendList(Long elementId) {
        List<ElementExtend> elementExtends = elementExtendDao.listByElementId(elementId);
        return elementExtends;
    }

    @Override
    public int addList(List<ElementExtend> elementExtends) {
        int k = 0;
        for (int i = 0; i <elementExtends.size() ; i++) {
           k += elementExtendDao.insert(elementExtends.get(i));
        }
        return k;
    }

}