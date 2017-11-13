package com.taiji.eap.common.form.formconfColumn.dao;

import com.taiji.eap.common.form.formconfColumn.bean.FormconfColumn;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface FormconfColumnDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param formconfColumn
     * @return
     */
    int insert(FormconfColumn formconfColumn);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    FormconfColumn selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param formconfColumn
     * @return
     */
    int updateByPrimaryKey(FormconfColumn formconfColumn);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<FormconfColumn> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<FormconfColumn> selectAll();


}