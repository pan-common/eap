package com.taiji.eap.common.file.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.file.bean.CommonFileInfo;

import java.util.List;

public interface FileService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param file
     * @return
     */
    int insert(CommonFileInfo file) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    CommonFileInfo selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param file
     * @return
     */
    int updateByPrimaryKey(CommonFileInfo file) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<CommonFileInfo> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<CommonFileInfo> list(int pageNum, int pageSize, String searchText) throws Exception;

}