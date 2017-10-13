package com.taiji.eap.common.shiro.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.shiro.bean.SysResource;
import javafx.scene.control.TreeView;

public interface SysResourceService {
	/**
	 * 查询用户所能看到的菜单
	 * @param roleIds 角色ID列表
	 * @param organIds 部门ID列表
	 * @return
	 */
	List<SysResource> selectUserMenu(List<Long> roleIds, List<Long> organIds);
	/**
	 * 查询全部菜单
	 * @return
	 */
	List<SysResource> selectAllMenu();
	/**
	 * 获取当前菜单路径
	 * @param resourceId
	 * @return
	 */
	List<SysResource> getPath(Long resourceId);

	/**
	 * 分页获取资源列表
	 * @param parentId
	 * @param pageNum
	 * @param pageSize
	 * @param searchText
	 * @return
	 */
    PageInfo<SysResource> list(Long parentId, int pageNum, int pageSize, String searchText);

	/**
	 * 添加资源
	 * @param resource
	 * @return
	 */
	int add(SysResource resource);

	/**
	 * 查询单个资源
	 * @param resourceId
	 * @return
	 */
    SysResource selectOne(Long resourceId);

	/**
	 * 编辑资源
	 * @param resource
	 * @return
	 */
	int edit(SysResource resource);

	/**
	 * 删除资源
	 * @param resourceId
	 * @return
	 */
	int delete(Long resourceId);

	/**
	 * 获取资源树结构视图  layui结构
	 * @return
	 */
	List<LayuiTree> treeView();
}
