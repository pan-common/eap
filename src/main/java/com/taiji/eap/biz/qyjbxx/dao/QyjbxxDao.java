package com.taiji.eap.biz.qyjbxx.dao;

import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
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


}