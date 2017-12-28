package com.taiji.eap.common.document.dao;

import com.taiji.eap.common.document.bean.Document;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DocumentDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param document
     * @return
     */
    int insert(Document document);

    /**
     * 选择性的插入数据
     * @param document
     * @return
     */
    int insertSelective(Document document);

     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Document selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param document
     * @return
     */
    int updateByPrimaryKey(Document document);

    /**
     * 选择性的修改数据
     * @param document
     * @return
     */
    int updateSelectiveByPrimaryKey(Document document);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Document> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Document> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Document> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

}