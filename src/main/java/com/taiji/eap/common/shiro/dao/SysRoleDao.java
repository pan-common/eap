package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysRoleDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysRole
     * @return
     */
    int insert(SysRole sysRole);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysRole selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysRole
     * @return
     */
    int updateByPrimaryKey(SysRole sysRole);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysRole> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysRole> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysRole> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

    List<SysRole> selectByIds(@Param("roleIds") List<Long> roleIds);
}