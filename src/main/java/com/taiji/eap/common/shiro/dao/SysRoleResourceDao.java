package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysRoleResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysRoleResourceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysRoleResource
     * @return
     */
    int insert(SysRoleResource sysRoleResource);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysRoleResource selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysRoleResource
     * @return
     */
    int updateByPrimaryKey(SysRoleResource sysRoleResource);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysRoleResource> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysRoleResource> selectAll();


    List<Long> getResourceIdsByRoleId(Long roleId);

    int deleteByRoleId(Long roleId);

    List<Long> getResourceIdsByRoleIds(@Param("roleIdList") List<Long> roleIdList);
}