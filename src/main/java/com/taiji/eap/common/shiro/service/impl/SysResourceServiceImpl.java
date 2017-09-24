package com.taiji.eap.common.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.eap.common.shiro.bean.SysResource;
import com.taiji.eap.common.shiro.dao.SysOrganPuriewDao;
import com.taiji.eap.common.shiro.dao.SysResourceDao;
import com.taiji.eap.common.shiro.dao.SysRolePuriewDao;
import com.taiji.eap.common.shiro.service.SysResourceService;

@Service
public class SysResourceServiceImpl implements SysResourceService{

	@Autowired
	private SysResourceDao sysResourceDao;//资源表
	@Autowired
	private SysRolePuriewDao sysRolePuriewDao;//角色权限关系
	@Autowired
	private SysOrganPuriewDao sysOrganPuriewDao;//部门权限关系

	@Override
	public List<SysResource> selectUserMenu(List<Long> roleIds,
			List<Long> organIds) {
		List<Long> puriewIds = new ArrayList<Long>();
		puriewIds.addAll(sysRolePuriewDao.selectPuriewIdByRoleIds(roleIds));
		puriewIds.addAll(sysOrganPuriewDao.selectPuriewIdByOrganIds(organIds));
		//去除重复权限
		removeDuplicate(puriewIds);
		List<SysResource> resources = sysResourceDao.selectMenuByPuriewIds(puriewIds);
		List<SysResource> menus = buildByRecursive(resources);
		return menus;
	}
	
	@Override
	public List<SysResource> selectAllMenu() {
		List<SysResource> resources = sysResourceDao.selectAllMenu();
		List<SysResource> menus = buildByRecursive(resources);
		return menus;
	}
	
	private void removeDuplicate(List<Long> list)  {
	    HashSet<Long> h = new HashSet<Long>(list);
	    list.clear();
	    list.addAll(h);
	}
	/**
	 * 递归建树
	 * @param resources
	 * @return
	 */
	private List<SysResource> buildByRecursive(List<SysResource> resources){
		Long pid = 0L;
		List<SysResource> trees = new ArrayList<SysResource>();
		for (SysResource tree : resources) {
			if(pid==tree.getParentId()){
				trees.add(findChildren(tree,resources));
			}
		}
		return trees;
	}

	private SysResource findChildren(SysResource tree, List<SysResource> resources) {
		for (SysResource sr : resources) {
			if(tree.getResourceId()==sr.getParentId()){
				if(tree.getChildren()==null){
					tree.setChildren(new ArrayList<SysResource>());
				}
				tree.getChildren().add(findChildren(sr, resources));
			}
		}
		return tree;
	}

	@Override
	public List<SysResource> getPath(Long resourceId) {
		List<SysResource> list = new ArrayList<SysResource>();
		list.add(new SysResource(0L, "资源管理"));
		if(resourceId!=0){
			disPlay(resourceId, list);
		}
		return list;
	}

	@Override
	public PageInfo<SysResource> list(Long parentId, int pageNum, int pageSize, String searchText) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysResource> sysResources = sysResourceDao.list(parentId,searchText);
		PageInfo<SysResource> pageInfo = new PageInfo<SysResource>(sysResources);
		return pageInfo;
	}

	@Override
	public int add(SysResource resource) {
		return sysResourceDao.add(resource);
	}

	@Override
	public SysResource selectOne(Long resourceId) {
		return sysResourceDao.selectByPrimaryKey(resourceId);
	}

	@Override
	public int edit(SysResource resource) {
		return sysResourceDao.edit(resource);
	}

	@Override
	public int delete(Long resourceId) {
		return sysResourceDao.delete(resourceId);
	}

	private void disPlay(Long resourceId,List<SysResource> list){
		SysResource sysResource = sysResourceDao.selectByPrimaryKey(resourceId);
		if(sysResource!=null){
			list.add(list.size(), sysResource);
			disPlay(sysResource.getParentId(), list);
		}
	}

}
