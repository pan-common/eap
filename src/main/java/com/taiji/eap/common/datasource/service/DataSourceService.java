package com.taiji.eap.common.datasource.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.generator.bean.LayuiTree;

import java.util.List;
import java.util.Map;

public interface DataSourceService {

    Map<Object,Object> getDataSources() throws NoSuchFieldException, IllegalAccessException;

    /**
     * 获取全部数据库连接
     * @return
     */
    List<LayuiTree> getDataSourceTree();

    /**
     *
     * @return
     */
    List<LayuiTree> dataSourceTree() throws NoSuchFieldException, IllegalAccessException, Exception;

    List<LayuiTree> tableTree(String beanName,String driverClassName,String url,String username,String password);

    void updateDatabaseId(String beanName);

    void resetDatabaseId();

    /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
    /**
     * 插入数据
     * @param dataSource
     * @return
     */
    int insert(DataSource dataSource) throws Exception;
    /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    DataSource selectByPrimaryKey(Long primaryKey) throws Exception;
    /**
     * 根据主键修改数据
     * @param dataSource
     * @return
     */
    int updateByPrimaryKey(DataSource dataSource) throws Exception;
    /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<DataSource> list(String searchText) throws Exception;
    /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<DataSource> list(int pageNum, int pageSize, String searchText) throws Exception;

    /**
     * 数据源连接测试
     * @param dataSource
     * @return
     */
    String connectTest(DataSource dataSource) throws Exception;

    /**
     * 获取单个数据源的表 树状视图
     * @param datasource
     * @return
     */
    List<LayuiTree> tableTree(String datasource) throws NoSuchFieldException, IllegalAccessException, Exception;

    /**
     * 切换数据源
     * @param datasource
     */
    void changeDataSource(String datasource) throws NoSuchFieldException, IllegalAccessException;

    /**
     * 获取全部数据源
     * @return
     */
    List<DataSource> getAllDataSources() throws NoSuchFieldException, IllegalAccessException, Exception;
}
