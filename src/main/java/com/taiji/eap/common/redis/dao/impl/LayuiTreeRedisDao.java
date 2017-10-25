package com.taiji.eap.common.redis.dao.impl;

import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.redis.dao.RedisGeneratorDao;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class LayuiTreeRedisDao extends RedisGeneratorDao<String,LayuiTree> {

    public void addList(String key,List<LayuiTree> layuiTrees){
        try {
            ListOperations<String,LayuiTree> listOperations = redisTemplate.opsForList();
            listOperations.rightPushAll(key,layuiTrees);
            redisTemplate.expire(key,30, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addList(String key,List<LayuiTree> layuiTrees,long timeout,TimeUnit unit){
        ListOperations<String,LayuiTree> listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll(key,layuiTrees);
        redisTemplate.expire(key,timeout, unit);
    }

    public List<LayuiTree> getAreas(String key){
        ListOperations<String,LayuiTree> listOperations = redisTemplate.opsForList();
        return listOperations.range(key,0,listOperations.size(key));
    }

    public boolean isCache(String key){
        ListOperations<String,LayuiTree> listOperations = redisTemplate.opsForList();
        boolean flag = false;
        try {
            flag = listOperations.size(key)>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
