package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysOrganResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysOrganResourceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysOrganResource
     * @return
     */
    int insert(SysOrganResource sysOrganResource);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysOrganResource selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysOrganResource
     * @return
     */
    int updateByPrimaryKey(SysOrganResource sysOrganResource);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysOrganResource> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysOrganResource> selectAll();


    int deleteByOrganId(Long organId);

    List<Long> getResourceIdsByOrganId(Long organId);

    List<Long> getResourceIdsByOrganIds(@Param("organIdList") List<Long> organIdList);
}