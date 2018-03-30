package com.taiji.eap.biz.yhysje.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.yhysje.bean.Yhysje;
import java.io.InputStream;
import java.util.List;

public interface YhysjeService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param yhysje
     * @return
     */
    int insert(Yhysje yhysje) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Yhysje selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param yhysje
     * @return
     */
    int updateByPrimaryKey(Yhysje yhysje) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Yhysje> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Yhysje> list(int pageNum, int pageSize, String searchText) throws Exception;
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

    /**
     * 导入借款数据
     * @param inputStream
     */
    void importJk(InputStream inputStream);

    /**
     * 导入贷款数据
     * @param inputStream
     */
    void importDk(InputStream inputStream);
}