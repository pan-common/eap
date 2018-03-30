package com.taiji.eap.wsm.baseInfo.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import java.util.List;

public interface BaseInfoService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param baseInfo
     * @return
     */
    int insert(BaseInfo baseInfo) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    BaseInfo selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param baseInfo
     * @return
     */
    int updateByPrimaryKey(BaseInfo baseInfo) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<BaseInfo> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<BaseInfo> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 选择性插入
    * @param baseInfo
    * @return
    */
    int insertSelective(BaseInfo baseInfo);
    /**
    * 选择性修改
    * @param baseInfo
    * @return
    */
    int updateByPrimaryKeySelective(BaseInfo baseInfo);
    /**
    * 按条件查询
    * @param baseInfo
    * @return
    */
    List<BaseInfo> queryAll(BaseInfo baseInfo);

    BaseInfo selectOneByUserId(String userId);
}