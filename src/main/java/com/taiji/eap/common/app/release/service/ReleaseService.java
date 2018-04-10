package com.taiji.eap.common.app.release.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.app.release.bean.Release;
import java.util.List;

public interface ReleaseService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param release
     * @return
     */
    int insert(Release release) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Release selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param release
     * @return
     */
    int updateByPrimaryKey(Release release) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Release> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Release> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 选择性插入
    * @param release
    * @return
    */
    int insertSelective(Release release);
    /**
    * 选择性修改
    * @param release
    * @return
    */
    int updateByPrimaryKeySelective(Release release);
    /**
    * 按条件查询
    * @param release
    * @return
    */
    List<Release> queryAll(Release release);

    /**
     * 获取最新版本的应用
     * @return
     */
    Release getLastVersion();
}