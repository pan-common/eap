package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.ConfigTree;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ConfigTreeDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param ConfigTree
     * @return
     */
    int insert(ConfigTree ConfigTree);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    ConfigTree selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param ConfigTree
     * @return
     */
    int updateByPrimaryKey(ConfigTree ConfigTree);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<ConfigTree> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<ConfigTree> selectAll();
     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<ConfigTree> listByPid(@Param("parentId") String parentId,@Param("searchText") String searchText);
    /**
     * 选择性插入
     * @param dmsctest
     * @return
     */
    int insertSelective(ConfigTree ConfigTree);
    /**
     * 选择性修改
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKeySelective(ConfigTree ConfigTree);
    /**
     * 按条件查询
     * @param dmsctest
     * @return
     */
    List<ConfigTree> queryAll(ConfigTree ConfigTree);
}