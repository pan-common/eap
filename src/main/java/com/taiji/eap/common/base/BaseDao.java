package com.taiji.eap.common.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T,PK> {

    /**
     *
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(PK primaryKey);

    /**
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     *
     * @param primaryKey
     * @return
     */
    T selectByPrimaryKey(PK primaryKey);

    /**
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     *
     * @param searchText 搜索条件
     * @return
     */
    List<T> list(@Param("searchText") String searchText);
}
