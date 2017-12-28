package com.taiji.eap.common.form.element.dao;

import com.taiji.eap.common.form.element.bean.Element;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ElementDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param element
     * @return
     */
    int insert(Element element);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Element selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param element
     * @return
     */
    int updateByPrimaryKey(Element element);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Element> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Element> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Element> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

}