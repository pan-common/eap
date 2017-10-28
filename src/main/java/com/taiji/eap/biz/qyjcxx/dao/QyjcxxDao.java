package com.taiji.eap.biz.qyjcxx.dao;

import com.taiji.eap.biz.qyjcxx.bean.Jcdw;
import com.taiji.eap.biz.qyjcxx.bean.Jcyz;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.bean.ZfjcJcqk;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface QyjcxxDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param qyjcxx
     * @return
     */
    int insert(Qyjcxx qyjcxx);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Qyjcxx selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param qyjcxx
     * @return
     */
    int updateByPrimaryKey(Qyjcxx qyjcxx);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjcxx> list(@Param("searchText") String searchText);

    List<Map<String,String>> listMap(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Qyjcxx> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjcxx> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

    /**
     * 保存检测日期信息
     * @param zfjcJcqk
     * @return
     */
    int saveZfjcqk(ZfjcJcqk zfjcJcqk);

    /**
     * 保存监测点位信息
     * @param jcdw
     * @return
     */
    int saveJcdw(Jcdw jcdw);

    /**
     * 保存监测因子信息
     * @param jcyz
     * @return
     */
    int saveJcyz(Jcyz jcyz);

    /**
     *
     * @param code
     * @return
     */
    String getNameByCode(@Param("code") String code);

    /**
     *
     * @param name
     * @return
     */
    String getCodeByName(@Param("name") String name);
}