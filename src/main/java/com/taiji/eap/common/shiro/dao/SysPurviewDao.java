package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysPurview;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface SysPurviewDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysPurview
     * @return
     */
    int insert(SysPurview sysPurview);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysPurview selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysPurview
     * @return
     */
    int updateByPrimaryKey(SysPurview sysPurview);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysPurview> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysPurview> selectAll();

    /**
     * 通过权限ID获取权限列表
     * @param puriewIds
     * @return
     */
    List<SysPurview> listByIds(@Param("puriewIds") List<Long> puriewIds);

    /**
     *
     * @return
     */
    List<Map<String,Object>> globalConfig();
}