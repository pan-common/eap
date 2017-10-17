package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysOrgan;
import com.taiji.eap.common.shiro.dao.SysOrganDao;
import com.taiji.eap.common.shiro.dao.SysUserOrganDao;
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

    @Autowired
    private SysUserOrganDao sysUserOrganDao;

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

    @Override
    public List<LayuiTree> treeView(Long parentId) throws Exception {
        List<SysOrgan> list = sysOrganDao.selectAll();
        List<LayuiTree> trees = new ArrayList<LayuiTree>();
        for (SysOrgan tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    @Override
    public List<SysOrgan> getOrganTreeByUserId(Long userId) {
       List<Long> organIds = sysUserOrganDao.getOrganIdsByUserId(userId);
       List<SysOrgan> sysOrgans = sysOrganDao.selectByIds(organIds);
       return sysOrgans;
    }

    private SysOrgan findChildren(SysOrgan tree,List<SysOrgan> list){
        for (SysOrgan sysOrgan:list) {
            sysOrgan.setName(sysOrgan.getName());
            sysOrgan.setSpread(true);
            if(tree.getOrganId()==sysOrgan.getParentId()){
                tree.getChildren().add(findChildren(sysOrgan,list));
            }
        }
        return tree;
    }

    private void disPlay(Long organId,List<SysOrgan> list){
    SysOrgan sysOrgan = sysOrganDao.selectByPrimaryKey(organId);
        if(sysOrgan!=null){
            list.add(sysOrgan);
            disPlay(sysOrgan.getParentId(), list);
        }
    }
}