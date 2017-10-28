package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysOrgan;
import com.taiji.eap.common.shiro.bean.SysUserOrgan;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysUserOrganDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysUserOrgan
     * @return
     */
    int insert(SysUserOrgan sysUserOrgan);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysUserOrgan selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysUserOrgan
     * @return
     */
    int updateByPrimaryKey(SysUserOrgan sysUserOrgan);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysUserOrgan> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysUserOrgan> selectAll();

    /**
     * 通过用户ID获取部门ID列表
     * @param userId
     * @return
     */
    List<Long> getOrganIdsByUserId(Long userId);

    /**
     * 删除用户所属部门
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);
}