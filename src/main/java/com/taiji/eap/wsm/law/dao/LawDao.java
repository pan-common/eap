package com.taiji.eap.wsm.law.dao;

import com.taiji.eap.wsm.law.bean.Law;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface LawDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param law
     * @return
     */
    int insert(Law law);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Law selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param law
     * @return
     */
    int updateByPrimaryKey(Law law);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Law> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Law> selectAll();
    /**
     * 选择性插入
     * @param dmsctest
     * @return
     */
    int insertSelective(Law law);
    /**
     * 选择性修改
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKeySelective(Law law);
    /**
     * 按条件查询
     * @param dmsctest
     * @return
     */
    List<Law> queryAll(Law law);
}