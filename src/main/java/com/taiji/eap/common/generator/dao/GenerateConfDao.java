package com.taiji.eap.common.generator.dao;

import com.taiji.eap.common.generator.bean.GenerateConf;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GenerateConfDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param generateConf
     * @return
     */
    int insert(GenerateConf generateConf);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    GenerateConf selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param generateConf
     * @return
     */
    int updateByPrimaryKey(GenerateConf generateConf);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<GenerateConf> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<GenerateConf> selectAll();


}