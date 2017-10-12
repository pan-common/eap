package com.taiji.eap.biz.organ.dao;

import com.taiji.eap.biz.organ.bean.Organ;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface OrganDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param organ
     * @return
     */
    int insert(Organ organ);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Organ selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param organ
     * @return
     */
    int updateByPrimaryKey(Organ organ);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Organ> list(@Param("searchText") String searchText);

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Organ> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

}