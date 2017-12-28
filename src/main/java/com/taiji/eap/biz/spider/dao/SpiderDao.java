package com.taiji.eap.biz.spider.dao;

import com.taiji.eap.biz.spider.bean.Spider;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SpiderDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param spider
     * @return
     */
    int insert(Spider spider);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Spider selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param spider
     * @return
     */
    int updateByPrimaryKey(Spider spider);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Spider> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Spider> selectAll();


}