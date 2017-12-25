package com.taiji.eap.common.redis.dao.impl;

import com.taiji.eap.common.redis.dao.RedisGeneratorDao;
import com.taiji.eap.common.redis.service.RedisKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 使用redis缓存列表数据
 * @param <T> 数据类型
 */
@Repository
public class RedisFactoryDao<T extends Serializable> extends RedisGeneratorDao<T>{

    private OnRedisSelectListener<T> listener;
    @Autowired
    private RedisKeyService redisKeyService;

    /**
     * 使用redis缓存列表数据
     * @param key 存储数据的键
     * @param data 存储数据的值
     */
    private void addList(String key, List<T> data){
        addList(key,data,365,null);
    }

    /**
     *
     * @param key 存储数据的键
     * @param data 存储数据的值
     * @param timeout 失效时间
     */
    private void addList(String key, List<T> data,long timeout){
        addList(key,data,timeout,null);
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
            if(unit==null){
                unit = TimeUnit.DAYS;
            }
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
    public List<T> getDatas(String key,String extraKey,long timeout,OnRedisSelectListener listener) throws Exception{
        return getDatas(key,extraKey,timeout,null,listener);
    }

    /**
     * 从缓存中查询结果
     * @param key 存储数据的键
     * @param key 额外的组合键，常量键该参数可用为  “”；
     * @param listener 未在缓存中找到结果的回调函数
     * @return
     * @throws Exception 参数不能为空
     */
    public List<T> getDatas(String key,String extraKey,OnRedisSelectListener listener) throws Exception{
        return  getDatas(key,extraKey,0,null,listener);
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
    public List<T> getDatas(String key,String extraKey,long timeout,TimeUnit unit,OnRedisSelectListener listener) throws Exception{
        boolean isKey = false;
        if("redis:keynames".equals(key)) {
            isKey = true;
        } else {
            List<String> allKeys =  redisKeyService.getAllKeys();
            isKey = allKeys.contains(key);
        }
        if(isKey) {
            String keyName = extraKey!=null&&!extraKey.equals("")?key+":"+extraKey:key;
            ListOperations<String, T> listOperations = redisTemplate.opsForList();
            try {
                boolean flag = listOperations.size(keyName) > 0 ? true : false;
                if (flag) {
                    return listOperations.range(keyName, 0, listOperations.size(keyName));
                } else {
                    List<T> list = listener.fruitless();
                    if(list!=null&&!list.isEmpty()) {
                        if (timeout != 0 && unit != null) {
                            addList(keyName, list, timeout, unit);
                        } else if (timeout != 0) {
                            addList(keyName, list, timeout);
                        } else {
                            addList(keyName, list);
                        }
                    }
                    return list;
                }
            } catch (RedisConnectionFailureException e) {
                e.printStackTrace();
                List<T> list = listener.fruitless();
                return list;
            }
        }else {
            throw new Exception("key名称不正确，Redis缓存失败");
        }
    }

    /**
     * 清除相关key的数据
     * @param key
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 根据通配符删除缓存
     * @param pattern
     */
    public void deleteByPattern(String pattern){
       Set<String> set = redisTemplate.keys(pattern);
       redisTemplate.delete(set);
    }

    public long size(String key) {
       return redisTemplate.opsForList().size(key);
    }

    public interface OnRedisSelectListener<T>{
        /**
         * 未查到结果处理，数据库查询结果在该方法返回
         * @return
         */
        List<T> fruitless();

    }

}
