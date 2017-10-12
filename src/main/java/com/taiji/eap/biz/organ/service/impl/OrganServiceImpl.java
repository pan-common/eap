package com.taiji.eap.biz.organ.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.organ.bean.Organ;
import com.taiji.eap.biz.organ.dao.OrganDao;
import com.taiji.eap.biz.organ.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrganServiceImpl implements OrganService{

    @Autowired
    private OrganDao organDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return organDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Organ organ) {
        return organDao.insert(organ);
    }

    @Override
    public Organ selectByPrimaryKey(Long primaryKey) {
        return organDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Organ organ) {
        return organDao.updateByPrimaryKey(organ);
    }

    @Override
    public List<Organ> list(String searchText) {
        return organDao.list(searchText);
    }

    @Override
    public PageInfo<Organ> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Organ> organs = organDao.list(searchText);
        PageInfo<Organ> pageInfo = new PageInfo<Organ>(organs);
        return pageInfo;
    }

    @Override
    public List<Organ> listByPid(Long parentId) throws Exception {
        return organDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<Organ> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Organ> list = organDao.listByPid(parentId,searchText);
        PageInfo<Organ> pageInfo = new PageInfo<Organ>(list);
        return pageInfo;
    }

    @Override
    public List<Organ> getPath(Long organId) throws Exception {
        List<Organ> list = new ArrayList<Organ>();
        if(organId!=0){
            disPlay(organId, list);
        }
        list.add(new Organ(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    private void disPlay(Long organId,List<Organ> list){
    Organ organ = organDao.selectByPrimaryKey(organId);
        if(organ!=null){
            list.add(organ);
            disPlay(organ.getParentId(), list);
        }
    }
}