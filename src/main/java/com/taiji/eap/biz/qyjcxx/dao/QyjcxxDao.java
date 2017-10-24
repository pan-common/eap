package com.taiji.eap.biz.qyjcxx.dao;

import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface QyjcxxDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param qyjcxx
     * @return
     */
    int insert(Qyjcxx qyjcxx);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Qyjcxx selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param qyjcxx
     * @return
     */
    int updateByPrimaryKey(Qyjcxx qyjcxx);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjcxx> list(@Param("searchText") String searchText);

    List<Map<String,String>> listMap(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Qyjcxx> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjcxx> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

}