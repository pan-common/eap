package com.taiji.eap.common.datasource.dao;

import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.datasource.bean.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataSourceDao {
    List<DataSource> list();

    /**
     * 查询数据库表
     * @param dbname
     * @param type
     * @return
     */
    List<Table> selectTables(@Param("schema") String dbname,@Param("type") String type);

    /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
    /**
     * 添加数据
     * @param dataSource
     * @return
     */
    int insert(DataSource dataSource);
    /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    DataSource selectByPrimaryKey(Long primaryKey);
    /**
     * 修改数据
     * @param dataSource
     * @return
     */
    int updateByPrimaryKey(DataSource dataSource);
    /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<DataSource> list(@Param("searchText") String searchText);

    /**
     * 查询全部数据
     * @return
     */
    List<DataSource> selectAll();
}
