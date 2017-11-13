package com.taiji.eap.common.form.formconfVersion.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.form.formconfVersion.bean.FormconfVersion;
import java.util.List;

public interface FormconfVersionService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param formconfVersion
     * @return
     */
    int insert(FormconfVersion formconfVersion) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    FormconfVersion selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param formconfVersion
     * @return
     */
    int updateByPrimaryKey(FormconfVersion formconfVersion) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<FormconfVersion> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<FormconfVersion> list(int pageNum, int pageSize, String searchText,FormconfVersion formconfVersion) throws Exception;

    /**
     * 通过formid查询所有版本
     * @param aLong
     * @return
     */
    List<FormconfVersion> listByFormId(Long aLong);
}