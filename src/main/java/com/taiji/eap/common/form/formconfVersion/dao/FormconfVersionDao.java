package com.taiji.eap.common.form.formconfVersion.dao;

import com.taiji.eap.common.form.formconfVersion.bean.FormconfVersion;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface FormconfVersionDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param formconfVersion
     * @return
     */
    int insert(FormconfVersion formconfVersion);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    FormconfVersion selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param formconfVersion
     * @return
     */
    int updateByPrimaryKey(FormconfVersion formconfVersion);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<FormconfVersion> list(@Param("searchText") String searchText,@Param("formId") Long formId);

     /**
     * 查询全部数据
     * @return
     */
    List<FormconfVersion> selectAll();

    /**
     * 通过FormId查询版本
     * @param formId
     * @return
     */
    List<FormconfVersion> listByFormId(Long formId);
}