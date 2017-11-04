package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysPuriewResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysPuriewResourceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysPuriewResource
     * @return
     */
    int insert(SysPuriewResource sysPuriewResource);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysPuriewResource selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysPuriewResource
     * @return
     */
    int updateByPrimaryKey(SysPuriewResource sysPuriewResource);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysPuriewResource> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysPuriewResource> selectAll();

    /**
     * 通过资源ID列表获取权限列表
     * @param resourceIds
     * @return
     */
    List<Long> getPuriewByResourceIds(@Param("resourceIds") List<Long> resourceIds);

    /**
     * 通过资源ID删除资源权限关系
     * @param primaryKey
     * @return
     */
    int deleteByResourceId(@Param("primaryKey") Long primaryKey);
}