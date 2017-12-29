package com.taiji.eap.biz.qyjbxx.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import java.util.List;

public interface QyjbxxService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param qyjbxx
     * @return
     */
    int insert(Qyjbxx qyjbxx) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Qyjbxx selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param qyjbxx
     * @return
     */
    int updateByPrimaryKey(Qyjbxx qyjbxx) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjbxx> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Qyjbxx> list(int pageNum, int pageSize, String searchText) throws Exception;

    /**
     * 爬取企业数据
     * @param qybh
     * @param startDate
     * @param endDate
     */
    void spider(String qybh,String startDate,String endDate);
}