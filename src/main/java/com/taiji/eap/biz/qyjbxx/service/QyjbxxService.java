package com.taiji.eap.biz.qyjbxx.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.qyjbxx.bean.Qyfaxx;
import com.taiji.eap.common.dictionary.bean.Dictionary;
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

    /**
     * 通过企业名称查询正式库企业编号
     * @param qymc
     * @return
     */
    List<Dictionary> getQybhByQymc(@Param("qymc") String qymc);

    /**
     * 通过企业编号查询企业再在方案和历史方案
     * @param qybh
     * @return
     */
    List<Qyfaxx> getQyfaxxs(String qybh);

    /**
     * 修改企业方案信息
     * @param qybh
     * @param vid
     * @return
     */
    int updateQyfaxx(String qybh, String vid);

    /**
     * 通过企业编号查询企业信息
     * @param qybh
     * @return
     */
    Qyjbxx selectOneByQybh(String qybh);
}