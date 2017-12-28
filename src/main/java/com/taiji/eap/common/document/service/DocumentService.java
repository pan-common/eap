package com.taiji.eap.common.document.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.document.bean.Document;
import java.util.List;

public interface DocumentService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param document
     * @return
     */
    int insert(Document document) throws Exception;

    /**
     * 选择性的插入数据
     * @param document
     * @return
     */
    int insertSelective(Document document) throws Exception;

     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Document selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param document
     * @return
     */
    int updateByPrimaryKey(Document document) throws Exception;

    /**
     * 选择性的修改数据
     * @param document
     * @return
     */
    int updateSelectiveByPrimaryKey(Document document) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Document> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Document> list(int pageNum, int pageSize, String searchText) throws Exception;
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<Document> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<Document> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<Document> getPath(Long primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<BaseTree> treeView(Long parentId) throws Exception;

}