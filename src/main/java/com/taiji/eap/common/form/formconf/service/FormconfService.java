package com.taiji.eap.common.form.formconf.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.form.formconf.bean.Formconf;
import java.util.List;

public interface FormconfService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param formconf
     * @return
     */
    int insert(Formconf formconf) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Formconf selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param formconf
     * @return
     */
    int updateByPrimaryKey(Formconf formconf) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Formconf> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Formconf> list(int pageNum, int pageSize, String searchText) throws Exception;

}