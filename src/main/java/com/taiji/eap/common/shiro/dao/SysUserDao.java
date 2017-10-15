package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysUserDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysUser selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysUser
     * @return
     */
    int updateByPrimaryKey(SysUser sysUser);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysUser> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysUser> selectAll();


}