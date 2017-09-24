package com.taiji.eap.common.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 角色权限操作类
 * @author panho
 *
 */
public interface SysRolePuriewDao {

	/**
	 * 通过角色ID集合查询权限集合
	 * @param roleIds
	 * @return
	 */
	List<Long> selectPuriewIdByRoleIds(@Param("roleIds")List<Long> roleIds);

}
