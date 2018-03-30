package com.taiji.eap.biz.jcxm.dao;

import com.taiji.eap.biz.jcxm.bean.Jcxm;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface JcxmDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param jcxm
     * @return
     */
    int insert(Jcxm jcxm);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Jcxm selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param jcxm
     * @return
     */
    int updateByPrimaryKey(Jcxm jcxm);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Jcxm> list(@Param("searchText") String searchText,@Param("qybh") String qybh,@Param("jcdbh")String jcdbh);

     /**
     * 查询全部数据
     * @return
     */
    List<Jcxm> selectAll();

    /**
     * 通过企业编号监测点编号获取监测项目
     * @param qybh 企业编号
     * @param jcdbh 监测点编号
     * @return
     */
    List<Dictionary> getJcxmByJcdbh(@Param("qybh") String qybh,@Param("jcdbh") String jcdbh);
}