package com.taiji.eap.common.app.release.dao;

import com.taiji.eap.common.app.release.bean.Release;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ReleaseDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param release
     * @return
     */
    int insert(Release release);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Release selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param release
     * @return
     */
    int updateByPrimaryKey(Release release);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Release> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Release> selectAll();
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
     * 获取应用当前版本
     * @return
     */
    Release getLastVersion();
}