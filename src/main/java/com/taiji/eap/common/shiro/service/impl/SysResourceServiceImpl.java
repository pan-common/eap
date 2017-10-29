package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysOrganResource;
import com.taiji.eap.common.shiro.bean.SysPuriew;
import com.taiji.eap.common.shiro.bean.SysResource;
import com.taiji.eap.common.shiro.bean.SysRoleResource;
import com.taiji.eap.common.shiro.dao.*;
import com.taiji.eap.common.shiro.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService{

    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysRoleResourceDao sysRoleResourceDao;//角色资源关系
    @Autowired
    private SysOrganResourceDao sysOrganResourceDao;//部门资源关系
    @Autowired
    private SysPuriewResourceDao sysPuriewResourceDao;//
    @Autowired
    private SysPuriewDao sysPuriewDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        int k = 0;
        k+=sysResourceDao.deleteByPrimaryKey(primaryKey);
        recursiveDelete(primaryKey);
        return k;
    }


    @Transactional
    @Override
    public int insert(SysResource sysResource) {
        SysPuriew sysPuriew = new SysPuriew();

        return sysResourceDao.insert(sysResource);
    }

    @Override
    public SysResource selectByPrimaryKey(Long primaryKey) {
        return sysResourceDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysResource sysResource) {
        return sysResourceDao.updateByPrimaryKey(sysResource);
    }

    @Override
    public List<SysResource> list(String searchText) {
        return sysResourceDao.list(searchText);
    }

    @Override
    public PageInfo<SysResource> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysResource> sysResources = sysResourceDao.list(searchText);
        PageInfo<SysResource> pageInfo = new PageInfo<SysResource>(sysResources);
        return pageInfo;
    }

    @Override
    public List<SysResource> listByPid(Long parentId) throws Exception {
        return sysResourceDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<SysResource> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<SysResource> list = sysResourceDao.listByPid(parentId,searchText);
        PageInfo<SysResource> pageInfo = new PageInfo<SysResource>(list);
        return pageInfo;
    }

    @Override
    public List<SysResource> getPath(Long resourceId) throws Exception {
        List<SysResource> list = new ArrayList<SysResource>();
        if(resourceId!=0){
            disPlay(resourceId, list);
        }
        list.add(new SysResource(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<LayuiTree> treeView(Long parentId) throws Exception {
        List<SysResource> list = sysResourceDao.selectAll();
        List<LayuiTree> trees = new ArrayList<LayuiTree>();
        for (SysResource tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    private SysResource findChildren(SysResource tree,List<SysResource> list){
        for (SysResource sysResource:list) {
            sysResource.setName(sysResource.getName());
            sysResource.setSpread(false);
            if(tree.getResourceId()==sysResource.getParentId()){
                tree.getChildren().add(findChildren(sysResource,list));
            }
        }
        return tree;
    }

    @Override
    public List<Long> getResourceIdsByRoleId(Long roleId) {
        List<Long> resourceIds = sysRoleResourceDao.getResourceIdsByRoleId(roleId);
        return resourceIds;
    }

    @Override
    public List<Long> getResourceIdsByOrganId(Long organId) {
        List<Long> resourceIds = sysOrganResourceDao.getResourceIdsByOrganId(organId);
        return resourceIds;
    }

    @Override
    public List<SysResource> selectByIds(List<Long> resourceIds) {
        List<SysResource> sysResources = sysResourceDao.selectByIds(resourceIds);
        return sysResources;
    }

    @Transactional
    @Override
    public int saveRoleResource(Long roleId, List<Long> resourceIds) {
        int k = 0;
        k+=sysRoleResourceDao.deleteByRoleId(roleId);
        for (int i = 0; i < resourceIds.size(); i++) {
            SysRoleResource sysRoleResource = new SysRoleResource();
            sysRoleResource.setResourceId(resourceIds.get(i));
            sysRoleResource.setRoleId(roleId);
            k+=sysRoleResourceDao.insert(sysRoleResource);
        }
        return k;
    }

    @Transactional
    @Override
    public int saveOrganResource(Long organId, List<Long> resourceIds) {
        int k=0;
        k+=sysOrganResourceDao.deleteByOrganId(organId);
        for (int i = 0; i < resourceIds.size(); i++) {
            SysOrganResource sysOrganResource = new SysOrganResource();
            sysOrganResource.setOrganId(organId);
            sysOrganResource.setResourceId(resourceIds.get(i));
            k+=sysOrganResourceDao.insert(sysOrganResource);
        }
        return k;
    }

    private void disPlay(Long resourceId,List<SysResource> list){
        SysResource sysResource = sysResourceDao.selectByPrimaryKey(resourceId);
        if(sysResource!=null){
            list.add(sysResource);
            disPlay(sysResource.getParentId(), list);
        }
    }

    /**
     * 递归删除
     * @param parentId
     */
    private void recursiveDelete(Long parentId){
        List<SysResource> sysResources =sysResourceDao.listByPid(parentId,"");
        if(sysResources!=null&&!sysResources.isEmpty()){
            for (SysResource sysResource: sysResources) {
                sysResourceDao.deleteByPrimaryKey(sysResource.getResourceId());
                recursiveDelete(sysResource.getResourceId());
            }
        }
    }
}