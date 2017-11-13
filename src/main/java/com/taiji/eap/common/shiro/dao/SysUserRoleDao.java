package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysUserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysUserRoleDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysUserRole
     * @return
     */
    int insert(SysUserRole sysUserRole);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysUserRole selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysUserRole
     * @return
     */
    int updateByPrimaryKey(SysUserRole sysUserRole);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysUserRole> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysUserRole> selectAll();

    List<Long> getRoleIdsByUserId(@Param("userId") Long userId);

    int deleteByUserId(@Param("userId") Long userId);

    /**
     * 通过角色ID获取用户ID
     * @param roleId
     * @return
     */
    List<Long> getUserIdByRoleId(Long roleId);
}