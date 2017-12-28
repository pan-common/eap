package com.taiji.eap.common.form.elementExtend.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.form.elementExtend.bean.ElementExtend;
import java.util.List;

public interface ElementExtendService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param elementExtend
     * @return
     */
    int insert(ElementExtend elementExtend) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    ElementExtend selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param elementExtend
     * @return
     */
    int updateByPrimaryKey(ElementExtend elementExtend) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<ElementExtend> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<ElementExtend> list(int pageNum, int pageSize, String searchText) throws Exception;

    /**
     * 查询元素扩展属性
     * @param elementId
     * @return
     */
    List<ElementExtend> elementExtendList(Long elementId);

    /**
     * 批量插入数据
     * @param elementExtends
     * @return
     */
    int addList(List<ElementExtend> elementExtends);
}