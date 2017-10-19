package com.taiji.eap.biz.test.dao;

import com.taiji.eap.biz.test.bean.Test;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TestDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param test
     * @return
     */
    int insert(Test test);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Test selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param test
     * @return
     */
    int updateByPrimaryKey(Test test);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Test> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Test> selectAll();


}