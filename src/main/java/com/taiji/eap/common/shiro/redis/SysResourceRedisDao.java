package com.taiji.eap.common.shiro.redis;

import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.redis.dao.RedisGeneratorDao;
import com.taiji.eap.common.shiro.bean.SysResource;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class SysResourceRedisDao extends RedisGeneratorDao<String,SysResource>{

    public void addList(String key, List<SysResource> list){
        ListOperations<String, SysResource> listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll(key,list);
        redisTemplate.expire(key,30, TimeUnit.DAYS);
    }

    public void addList(String key, List<SysResource> list,long timeout,TimeUnit unit){
        ListOperations<String, SysResource> listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll(key,list);
        redisTemplate.expire(key,timeout, unit);
    }

    public List<SysResource> getResources(String key){
        ListOperations<String,SysResource> listOperations = redisTemplate.opsForList();
        return listOperations.range(key,0,listOperations.size(key));
    }

    public boolean isCache(String key){
        ListOperations<String,SysResource> listOperations = redisTemplate.opsForList();
        boolean flag = false;
        try {
            flag = listOperations.size(key)>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
