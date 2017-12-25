package com.taiji.eap.common.shiro.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.shiro.bean.SysPurview;
import java.util.List;
import java.util.Map;

public interface SysPurviewService {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param sysPurview
     * @return
     */
    int insert(SysPurview sysPurview) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    SysPurview selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param sysPurview
     * @return
     */
    int updateByPrimaryKey(SysPurview sysPurview) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysPurview> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<SysPurview> list(int pageNum, int pageSize, String searchText) throws Exception;

    /**
     * 通过资源ID列表，获取对应权限列表
     * @param resourceIds
     * @return
     */
    List<SysPurview> getPuriewByResourceIds(List<Long> resourceIds);

    /***
     * 获取权限全局配置
     * @return
     */
    List<Map<String,Object>> globalConfig();
}