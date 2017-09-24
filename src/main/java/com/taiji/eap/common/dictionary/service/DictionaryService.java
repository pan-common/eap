package com.taiji.eap.common.dictionary.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryService {
    /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;

    /**
     *
     * @param dictionary
     * @return
     */
    int insert(Dictionary dictionary) throws Exception;

    /**
     *
     * @param primaryKey
     * @return
     */
    Dictionary selectByPrimaryKey(Long primaryKey) throws Exception;
    /**
     *
     * @param dictionary
     * @return
     */
    int updateByPrimaryKey(Dictionary dictionary) throws Exception;

    /**
     *
     * @param searchText 搜索条件
     * @return
     */
    List<Dictionary> list(String searchText) throws Exception;

    /**
     *
     * @param searchText 搜索条件
     * @return
     */
    PageInfo<Dictionary> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;

    /**
     *
     * @param parentId
     * @return
     */
    List<Dictionary> listByPid(Long parentId) throws Exception;

    /**
     *
     * @param dicId
     * @return
     */
    List<Dictionary> getPath(Long dicId) throws Exception;
}
