package com.taiji.eap.biz.yhysje.dao;

import com.taiji.eap.biz.yhysje.bean.Yhysje;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface YhysjeDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param yhysje
     * @return
     */
    int insert(Yhysje yhysje);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Yhysje selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param yhysje
     * @return
     */
    int updateByPrimaryKey(Yhysje yhysje);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Yhysje> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Yhysje> selectAll();
    /**
     * 选择性插入
     * @param dmsctest
     * @return
     */
    int insertSelective(Yhysje yhysje);
    /**
     * 选择性修改
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKeySelective(Yhysje yhysje);
    /**
     * 按条件查询
     * @param dmsctest
     * @return
     */
    List<Yhysje> queryAll(Yhysje yhysje);
}