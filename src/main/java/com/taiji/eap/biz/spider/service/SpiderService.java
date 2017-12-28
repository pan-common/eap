package com.taiji.eap.biz.spider.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.spider.bean.Spider;
import java.util.List;

public interface SpiderService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param spider
     * @return
     */
    int insert(Spider spider) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Spider selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param spider
     * @return
     */
    int updateByPrimaryKey(Spider spider) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Spider> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Spider> list(int pageNum, int pageSize, String searchText) throws Exception;

}