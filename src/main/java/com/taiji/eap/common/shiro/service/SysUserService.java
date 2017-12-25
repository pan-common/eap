package com.taiji.eap.common.shiro.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.shiro.bean.SysUser;
import java.util.List;

public interface SysUserService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    SysUser selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param sysUser
     * @return
     */
    int updateByPrimaryKey(SysUser sysUser) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysUser> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<SysUser> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * easyui提交数据
    * @return
    */
    int easyuiSubmitData(EasyUISubmitData<SysUser> easyUISubmitData);

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    SysUser getUserByName(String username);
}