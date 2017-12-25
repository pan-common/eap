package com.taiji.eap.common.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.shiro.bean.SysRole;
import com.taiji.eap.common.shiro.bean.SysUserRole;
import com.taiji.eap.common.shiro.dao.SysRoleDao;
import com.taiji.eap.common.shiro.dao.SysUserRoleDao;
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

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

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
    public List<BaseTree> treeView(Long parentId) throws Exception {
        List<SysRole> list = sysRoleDao.selectAll();
        List<BaseTree> trees = new ArrayList<BaseTree>();
        for (SysRole tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    @Override
    public List<Long> getRoleIdsByUserId(Long userId) {
        List<Long> roleIds = sysUserRoleDao.getRoleIdsByUserId(userId);
        return roleIds;
    }

    @Override
    public List<SysRole> selectByIds(List<Long> roleIds) {
        List<SysRole> sysRoles = sysRoleDao.selectByIds(roleIds);
        return sysRoles;
    }

    @Transactional
    @Override
    public int saveUserRole(Long userId, List<Long> roleIds) {
        int k = 0;
        k+=sysUserRoleDao.deleteByUserId(userId);
        for (int i = 0; i < roleIds.size(); i++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(roleIds.get(i));
            k+=sysUserRoleDao.insert(sysUserRole);
        }
        return k;
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