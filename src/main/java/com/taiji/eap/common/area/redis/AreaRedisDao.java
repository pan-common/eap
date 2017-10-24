package com.taiji.eap.common.area.redis;

import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.redis.dao.RedisGeneratorDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class AreaRedisDao extends RedisGeneratorDao<String,Area>{

    public void add(Area area){

    }

    public void addList(List<Area> area){
        ListOperations<String,Area> listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll("allArea",area);
        redisTemplate.expire("allArea",30, TimeUnit.DAYS);
    }

    public List<Area> getAreas(){
        ListOperations<String,Area> listOperations = redisTemplate.opsForList();
        return listOperations.range("allArea",0,listOperations.size("allArea"));
    }

    public boolean isCache(){
        ListOperations<String,Area> listOperations = redisTemplate.opsForList();
        return listOperations.size("allArea")>0?true:false;
    }

}
