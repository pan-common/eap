package com.taiji.eap.common.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taiji.eap.common.shiro.bean.SysResource;

public interface SysResourceDao {

	/**
	 * 通过权限ID查询菜单资源
	 * @param puriewIds
	 * @return
	 */
	List<SysResource> selectMenuByPuriewIds(@Param("puriewIds")List<Long> puriewIds);
	/**
	 * 查询全部菜单
	 * @return
	 */
	List<SysResource> selectAllMenu();
	/**
	 * 通过主键查询资源
	 * @param resourceId
	 * @return
	 */
	SysResource selectByPrimaryKey(@Param("resourceId")Long resourceId);

	/**
	 * 通过父节点ID查询子节点列表
	 * @param parentId 父节点ID
	 * @param searchText 搜索内容
	 * @return
	 */
    List<SysResource> list(@Param("parentId") Long parentId, @Param("searchText") String searchText);

	/**
	 * 添加资源
	 * @param resource
	 * @return
	 */
	int add(SysResource resource);

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
	int delete(@Param("resourceId")Long resourceId);
}
