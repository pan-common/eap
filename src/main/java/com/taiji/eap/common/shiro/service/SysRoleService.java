package com.taiji.eap.common.shiro.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.http.entity.Response;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysRole;
import java.util.List;

public interface SysRoleService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param sysRole
     * @return
     */
    int insert(SysRole sysRole) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    SysRole selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param sysRole
     * @return
     */
    int updateByPrimaryKey(SysRole sysRole) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysRole> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<SysRole> list(int pageNum, int pageSize, String searchText) throws Exception;

     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<SysRole> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<SysRole> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<SysRole> getPath(Long primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<LayuiTree> treeView(Long parentId) throws Exception;

    /**
     * 通过用户ID获取角色列表
     * @param userId
     * @return
     */
    List<Long> getRoleIdsByUserId(Long userId);

    List<SysRole> selectByIds(List<Long> roleIds);

    int saveUserRole(Long userId, List<Long> roleIds);
}