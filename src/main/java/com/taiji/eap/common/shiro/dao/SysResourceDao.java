package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysResourceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysResource
     * @return
     */
    int insert(SysResource sysResource);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysResource selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysResource
     * @return
     */
    int updateByPrimaryKey(SysResource sysResource);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysResource> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysResource> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysResource> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

    List<SysResource> selectByIds(@Param("resourceIds") List<Long> resourceIds);

}