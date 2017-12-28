package com.taiji.eap.common.form.elementExtend.dao;

import com.taiji.eap.common.form.elementExtend.bean.ElementExtend;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ElementExtendDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param elementExtend
     * @return
     */
    int insert(ElementExtend elementExtend);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    ElementExtend selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param elementExtend
     * @return
     */
    int updateByPrimaryKey(ElementExtend elementExtend);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<ElementExtend> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<ElementExtend> selectAll();


    List<ElementExtend> listByElementId(@Param("elementId") Long elementId);
}