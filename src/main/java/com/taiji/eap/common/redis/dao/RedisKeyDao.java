package com.taiji.eap.common.redis.dao;

import com.taiji.eap.common.redis.bean.RedisKey;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface RedisKeyDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param redisKey
     * @return
     */
    int insert(RedisKey redisKey);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    RedisKey selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param redisKey
     * @return
     */
    int updateByPrimaryKey(RedisKey redisKey);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<RedisKey> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<RedisKey> selectAll();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<RedisKey> listByPid(@Param("parentId") Long parentId,@Param("searchText") String searchText);

}