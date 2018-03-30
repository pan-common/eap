package com.taiji.eap.biz.qyjbxx.dao;

import com.taiji.eap.biz.qyjbxx.bean.Qyfaxx;
import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface QyjbxxDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param qyjbxx
     * @return
     */
    int insert(Qyjbxx qyjbxx);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Qyjbxx selectByPrimaryKey(Long primaryKey);

    /**
     * 通过企业编号查询企业数据
     * @param qybh
     * @return
     */
    Qyjbxx selectByQybh(String qybh);

     /**
     * 修改数据
     * @param qyjbxx
     * @return
     */
    int updateByPrimaryKey(Qyjbxx qyjbxx);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjbxx> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Qyjbxx> selectAll();

    /**
     * 在正式库中查询企业基本信息
     * @param qymc
     * @return
     */
    List<Dictionary> getQybhByQymc(@Param("qymc") String qymc);

    /**
     * 通过企业编号查询企业历史方案和当前在用方案
     * @param qybh 企业编号
     * @return
     */
    List<Qyfaxx> getQyfaxxs(@Param("qybh") String qybh);

    /**
     * 修改企业方案信息
     * @param qybh 企业编号
     * @param vid 方案版本号
     * @return
     */
    int updateQyfaxx(@Param("qybh")String qybh,@Param("vid") String vid);
}