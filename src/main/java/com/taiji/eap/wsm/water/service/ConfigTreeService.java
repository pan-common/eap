package com.taiji.eap.wsm.water.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.wsm.water.bean.ConfigTree;
import java.util.List;

public interface ConfigTreeService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param ConfigTree
     * @return
     */
    int insert(ConfigTree ConfigTree) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    ConfigTree selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param ConfigTree
     * @return
     */
    int updateByPrimaryKey(ConfigTree ConfigTree) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<ConfigTree> list(String searchText) throws Exception;

    List<ConfigTree> selectAll() throws Exception;

     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<ConfigTree> list(int pageNum, int pageSize, String searchText) throws Exception;
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<ConfigTree> listByPid(String parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<ConfigTree> listByPid(String parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<ConfigTree> getPath(String primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<BaseTree> treeView(String parentId) throws Exception;
    /**
    * 选择性插入
    * @param ConfigTree
    * @return
    */
    int insertSelective(ConfigTree ConfigTree);
    /**
    * 选择性修改
    * @param ConfigTree
    * @return
    */
    int updateByPrimaryKeySelective(ConfigTree ConfigTree);
    /**
    * 按条件查询
    * @param ConfigTree
    * @return
    */
    List<ConfigTree> queryAll(ConfigTree ConfigTree);
}