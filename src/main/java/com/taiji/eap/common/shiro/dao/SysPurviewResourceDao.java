package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysPurviewResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysPurviewResourceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysPurviewResource
     * @return
     */
    int insert(SysPurviewResource sysPurviewResource);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysPurviewResource selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysPurviewResource
     * @return
     */
    int updateByPrimaryKey(SysPurviewResource sysPurviewResource);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysPurviewResource> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysPurviewResource> selectAll();

    /**
     * 通过资源ID列表获取权限列表
     * @param resourceIds
     * @return
     */
    List<Long> getPuriewByResourceIds(@Param("resourceIds") List<Long> resourceIds);

    /**
     * 通过资源ID删除资源权限关系
     * @param resourceId
     * @return
     */
    int deleteByResourceId(@Param("resourceId") Long resourceId);
}