package com.taiji.eap.biz.registItem.dao;

import com.taiji.eap.biz.registItem.bean.RegistItem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface RegistItemDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param registItem
     * @return
     */
    int insert(RegistItem registItem);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    RegistItem selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param registItem
     * @return
     */
    int updateByPrimaryKey(RegistItem registItem);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<RegistItem> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<RegistItem> selectAll();


}