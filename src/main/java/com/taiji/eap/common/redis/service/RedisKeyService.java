package com.taiji.eap.common.redis.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.redis.bean.RedisKey;
import java.util.List;

public interface RedisKeyService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param redisKey
     * @return
     */
    int insert(RedisKey redisKey) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    RedisKey selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param redisKey
     * @return
     */
    int updateByPrimaryKey(RedisKey redisKey) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<RedisKey> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<RedisKey> list(int pageNum, int pageSize, String searchText) throws Exception;
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<RedisKey> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<RedisKey> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<RedisKey> getPath(Long primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<LayuiTree> treeView(Long parentId) throws Exception;

}