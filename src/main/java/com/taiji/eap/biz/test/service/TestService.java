package com.taiji.eap.biz.test.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.test.bean.Test;
import java.util.List;

public interface TestService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param test
     * @return
     */
    int insert(Test test) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Test selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param test
     * @return
     */
    int updateByPrimaryKey(Test test) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Test> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Test> list(int pageNum, int pageSize, String searchText) throws Exception;


}