package com.taiji.eap.common.dictionary.dao;

import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryDao {

    /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);

    /**
     *
     * @param dictionary
     * @return
     */
    int insert(Dictionary dictionary);

    /**
     *
     * @param primaryKey
     * @return
     */
    Dictionary selectByPrimaryKey(Long primaryKey);
    /**
     *
     * @param dictionary
     * @return
     */
    int updateByPrimaryKey(Dictionary dictionary);

    /**
     *
     * @param searchText 搜索条件
     * @return
     */
    List<Dictionary> list(@Param("searchText") String searchText);

    /**
     *
     * @param searchText 搜索条件
     * @return
     */
    List<Dictionary> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);
}