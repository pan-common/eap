package com.taiji.eap.biz.jcdxx.dao;

import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface JcdxxDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param jcdxx
     * @return
     */
    int insert(Jcdxx jcdxx);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Jcdxx selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param jcdxx
     * @return
     */
    int updateByPrimaryKey(Jcdxx jcdxx);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @param qybh 企业编号
     * @param jcdfl 监测点分类
     * @return
     */
    List<Jcdxx> list(@Param("searchText") String searchText,@Param("qybh")String qybh,@Param("jcdfl")String jcdfl);

     /**
     * 查询全部数据
     * @return
     */
    List<Jcdxx> selectAll();

    /**
     * 通过企业编号查询监测点信息
     * @param qybh
     * @return
     */
    List<Jcdxx> selectByQybh(@Param("qybh") String qybh);

    /**
     * 通过企业编号和监测点分类查询监测点
     * @param qybh 企业编号
     * @param jcdfl 监测点分类
     * @return
     */
    List<Dictionary> getJcdbhByQybh(@Param("qybh") String qybh,@Param("jcdfl") String jcdfl);
}