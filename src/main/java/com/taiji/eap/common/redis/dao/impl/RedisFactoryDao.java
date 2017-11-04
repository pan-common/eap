package com.taiji.eap.common.redis.dao.impl;

import com.taiji.eap.common.redis.dao.RedisGeneratorDao;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用redis缓存列表数据
 * @param <T> 数据类型
 */
@Repository
public class RedisFactoryDao<T extends Serializable> extends RedisGeneratorDao<String,T>{

    private OnRedisSelectListener<T> listener;

    /**
     * 使用redis缓存列表数据
     * @param key 存储数据的键
     * @param data 存储数据的值
     */
    private void addList(String key, List<T> data){
        try {
            ListOperations<String,T> listOperations = redisTemplate.opsForList();
            listOperations.rightPushAll(key,data);
            redisTemplate.expire(key,30, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param key 存储数据的键
     * @param data 存储数据的值
     * @param timeout 失效时间
     */
    private void addList(String key, List<T> data,long timeout){
        try {
            ListOperations<String,T> listOperations = redisTemplate.opsForList();
            listOperations.rightPushAll(key,data);
            redisTemplate.expire(key,timeout, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param key 存储数据的键
     * @param data 存储数据的值
     * @param timeout 失效时间
     * @param unit 时间单位 例如：TimeUnit.DAYS
     */
    private void addList(String key, List<T> data,long timeout,TimeUnit unit){
        try {
            ListOperations<String,T> listOperations = redisTemplate.opsForList();
            listOperations.rightPushAll(key,data);
            redisTemplate.expire(key,timeout, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从缓存中查询结果
     * @param key 存储数据的键
     * @param timeout 失效时间
     * @param listener 未在缓存中找到结果的回调函数
     * @return
     * @throws Exception
     */
    public List<T> getDatas(String key,long timeout,OnRedisSelectListener listener) throws Exception{
        if(listener==null){
            throw new Exception("OnRedisSelectListener参数不能为空");
        }
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        boolean flag = listOperations.size(key)>0?true:false;
        if(flag){
            return listOperations.range(key,0,listOperations.size(key));
        }else {
            List<T> list = listener.fruitless();
            addList(key,list,timeout);
            return list;
        }
    }

    /**
     * 从缓存中查询结果
     * @param key 存储数据的键
     * @param timeout 失效时间
     * @param unit 时间单位 例如：TimeUnit.DAYS
     * @param listener  未在缓存中找到结果的回调函数
     * @return
     * @throws Exception
     */
    public List<T> getDatas(String key,long timeout,TimeUnit unit,OnRedisSelectListener listener) throws Exception{
        if(listener==null){
            throw new Exception("OnRedisSelectListener参数不能为空");
        }
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        boolean flag = listOperations.size(key)>0?true:false;
        if(flag){
            return listOperations.range(key,0,listOperations.size(key));
        }else {
            List<T> list = listener.fruitless();
            addList(key,list,timeout,unit);
            return list;
        }
    }

    /**
     * 从缓存中查询结果
     * @param key 存储数据的键
     * @param listener 未在缓存中找到结果的回调函数
     * @return
     * @throws Exception 参数不能为空
     */
    public List<T> getDatas(String key,OnRedisSelectListener listener){
        ListOperations<String,T> listOperations = redisTemplate.opsForList();

        try {
            boolean flag = listOperations.size(key)>0?true:false;
            if(flag){
                return listOperations.range(key,0,listOperations.size(key));
            }else {
                List<T> list = listener.fruitless();
                addList(key,list);
                return list;
            }
        } catch (RedisConnectionFailureException e) {
            e.printStackTrace();
            List<T> list = listener.fruitless();
            return list;
        }
    }

    public interface OnRedisSelectListener<T>{
        /**
         * 未查到结果处理，数据库查询结果在该方法返回
         * @return
         */
        List<T> fruitless();
    }

}
