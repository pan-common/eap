package com.taiji.eap.biz.dmsctest.dao;

import com.taiji.eap.biz.dmsctest.bean.Dmsctest;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DmsctestDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param dmsctest
     * @return
     */
    int insert(Dmsctest dmsctest);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Dmsctest selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKey(Dmsctest dmsctest);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Dmsctest> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Dmsctest> selectAll();
    /**
     * 选择性插入
     * @param dmsctest
     * @return
     */
    int insertSelective(Dmsctest dmsctest);
    /**
     * 选择性修改
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKeySelective(Dmsctest dmsctest);
    /**
     * 按条件查询
     * @param dmsctest
     * @return
     */
    List<Dmsctest> queryAll(Dmsctest dmsctest);
}