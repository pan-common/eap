package com.taiji.eap.biz.dmsctest.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.dmsctest.bean.Dmsctest;
import java.util.List;

public interface DmsctestService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param dmsctest
     * @return
     */
    int insert(Dmsctest dmsctest) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Dmsctest selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKey(Dmsctest dmsctest) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Dmsctest> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Dmsctest> list(int pageNum, int pageSize, String searchText) throws Exception;
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