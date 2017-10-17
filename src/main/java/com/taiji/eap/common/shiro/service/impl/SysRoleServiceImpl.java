package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysRole;
import com.taiji.eap.common.shiro.dao.SysRoleDao;
import com.taiji.eap.common.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleDao sysRoleDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return sysRoleDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(SysRole sysRole) {
        return sysRoleDao.insert(sysRole);
    }

    @Override
    public SysRole selectByPrimaryKey(Long primaryKey) {
        return sysRoleDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SysRole sysRole) {
        return sysRoleDao.updateByPrimaryKey(sysRole);
    }

    @Override
    public List<SysRole> list(String searchText) {
        return sysRoleDao.list(searchText);
    }

    @Override
    public PageInfo<SysRole> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<SysRole> sysRoles = sysRoleDao.list(searchText);
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(sysRoles);
        return pageInfo;
    }

    @Override
    public List<SysRole> listByPid(Long parentId) throws Exception {
        return sysRoleDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<SysRole> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> list = sysRoleDao.listByPid(parentId,searchText);
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
        return pageInfo;
    }

    @Override
    public List<SysRole> getPath(Long roleId) throws Exception {
        List<SysRole> list = new ArrayList<SysRole>();
        if(roleId!=0){
            disPlay(roleId, list);
        }
        list.add(new SysRole(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<LayuiTree> treeView(Long parentId) throws Exception {
        List<SysRole> list = sysRoleDao.selectAll();
        List<LayuiTree> trees = new ArrayList<LayuiTree>();
        for (SysRole tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    @Override
    public void getRoleTreeByUserId(Long userId) {

    }

    private SysRole findChildren(SysRole tree,List<SysRole> list){
        for (SysRole sysRole:list) {
            sysRole.setName(sysRole.getName());
            sysRole.setSpread(true);
            if(tree.getRoleId()==sysRole.getParentId()){
                tree.getChildren().add(findChildren(sysRole,list));
            }
        }
        return tree;
    }

    private void disPlay(Long roleId,List<SysRole> list){
    SysRole sysRole = sysRoleDao.selectByPrimaryKey(roleId);
        if(sysRole!=null){
            list.add(sysRole);
            disPlay(sysRole.getParentId(), list);
        }
    }
}