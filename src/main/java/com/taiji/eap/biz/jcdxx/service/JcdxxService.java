package com.taiji.eap.biz.jcdxx.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import java.util.List;

public interface JcdxxService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param jcdxx
     * @return
     */
    int insert(Jcdxx jcdxx) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Jcdxx selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param jcdxx
     * @return
     */
    int updateByPrimaryKey(Jcdxx jcdxx) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Jcdxx> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @param qyhb 企业编号
     * @param jcdfl 监测点分类
     * @return
     * @throws Exception
     */
    PageInfo<Jcdxx> list(int pageNum, int pageSize, String searchText,String qyhb,String jcdfl) throws Exception;

}