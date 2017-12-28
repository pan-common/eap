package com.taiji.eap.common.shiro.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.shiro.bean.SysResource;
import java.util.List;

public interface SysResourceService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param sysResource
     * @return
     */
    int insert(SysResource sysResource) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    SysResource selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param sysResource
     * @return
     */
    int updateByPrimaryKey(SysResource sysResource) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysResource> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<SysResource> list(int pageNum, int pageSize, String searchText) throws Exception;
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<SysResource> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<SysResource> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<SysResource> getPath(Long primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<BaseTree> treeView(Long parentId) throws Exception;

    List<BaseTree> treeViewByUser(Long parentId) throws Exception;

    /**
     * 通过角色ID获取资源ID列表
     * @param roleId
     * @return
     */
    List<Long> getResourceIdsByRoleId(Long roleId);

    /**
     * 通过部门ID获取资源列表
     * @param organId
     * @return
     */
    List<Long> getResourceIdsByOrganId(Long organId);

    /**
     * 通过资源ID列表获取资源
     * @param resourceIds
     * @return
     */
    List<SysResource> selectByIds(List<Long> resourceIds);

    /**
     * 保存角色资源
     * @param roleId
     * @param resourceIds
     * @return
     */
    int saveRoleResource(Long roleId, List<Long> resourceIds);

    /**
     * 保持部门资源
     * @param organId 部门ID
     * @param resourceIds 资源ID
     * @return
     */
    int saveOrganResource(Long organId, List<Long> resourceIds);

    /**
     * 通过部门ID列表获取资源
     * @param organIdList
     */
    List<Long> getResourceIdsByOrganIds(List<Long> organIdList);

    /**
     * 通过角色ID列表获取资源
     * @param roleIdList
     */
    List<Long> getResourceIdsByRoleIds(List<Long> roleIdList);
}