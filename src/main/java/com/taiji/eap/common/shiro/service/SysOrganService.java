package com.taiji.eap.common.shiro.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.shiro.bean.SysOrgan;
import java.util.List;

public interface SysOrganService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param sysOrgan
     * @return
     */
    int insert(SysOrgan sysOrgan) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    SysOrgan selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param sysOrgan
     * @return
     */
    int updateByPrimaryKey(SysOrgan sysOrgan) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysOrgan> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<SysOrgan> list(int pageNum, int pageSize, String searchText) throws Exception;

     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<SysOrgan> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<SysOrgan> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<SysOrgan> getPath(Long primaryKey) throws Exception;

    List<LayuiTree> treeView(Long parentId) throws Exception;
}