package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysOrgan;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysOrganDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysOrgan
     * @return
     */
    int insert(SysOrgan sysOrgan);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysOrgan selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysOrgan
     * @return
     */
    int updateByPrimaryKey(SysOrgan sysOrgan);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysOrgan> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysOrgan> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysOrgan> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

    /**
     * 通过主键集合查询结果
     * @param organIds
     * @return
     */
    List<SysOrgan> selectByIds(List<Long> organIds);

}