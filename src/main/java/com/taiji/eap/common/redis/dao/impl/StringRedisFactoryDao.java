package com.taiji.eap.common.redis.dao.impl;

import com.taiji.eap.common.redis.service.RedisKeyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class StringRedisFactoryDao extends RedisFactoryDao<String>{

    private OnRedisSelectListener listener;
    @Autowired
    private RedisKeyService redisKeyService;

    private void addValue(String key,String value){
        addValue(key,value,0,null);
    }

    private void addValue(String key,String value,long timeout){
        addValue(key,value,timeout,null);
    }

    private void addValue(String key,String value,long timeout,TimeUnit unit){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key,value);
        if(unit==null){
            unit = TimeUnit.DAYS;
        }
        stringRedisTemplate.expire(key,timeout,unit);
    }

    public String getValue(String key,String extraKey,OnRedisSelectListener listener) throws Exception {
        return getValue(key,extraKey,365,null,listener);
    }

    public String getValue(String key,String extraKey,long timeout,OnRedisSelectListener listener) throws Exception {
        return getValue(key,extraKey,timeout,null,listener);
    }

    public String getValue(String key,String extraKey,long timeout,TimeUnit unit,OnRedisSelectListener listener) throws Exception {
        boolean isKey;
        if(key.equals("redis:keynames")){
            isKey = true;
        }else {
            List<String> allKeys =  redisKeyService.getAllKeys();
            isKey = allKeys.contains(key);
        }
        if(isKey) {
            String keyName = StringUtils.isEmpty(extraKey)?key:key+":"+extraKey;
            ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
            try {
                boolean flag = valueOperations.size(keyName)>0?true:false;
                if(flag){
                    return valueOperations.get(keyName, 0, valueOperations.size(keyName));
                }else {
                    String value = listener.fruitless();
                    if(!StringUtils.isEmpty(value)){
                        if (timeout != 0 && unit != null) {
                            addValue(keyName, value, timeout, unit);
                        } else if (timeout != 0) {
                            addValue(keyName, value, timeout);
                        } else {
                            addValue(keyName, value);
                        }
                    }
                    return value;
                }
            } catch (RedisConnectionFailureException e) {
                e.printStackTrace();
                String value = listener.fruitless();
                return value;
            }

        }else {
            throw new Exception("key名称不正确，Redis缓存失败");
        }
    }


    @Override
    public void delete(String key){
        stringRedisTemplate.delete(key);
    }

    @Override
    public void deleteByPattern(String pattern){
        Set<String> set = stringRedisTemplate.keys(pattern);
        stringRedisTemplate.delete(set);
    }

    public interface OnRedisSelectListener{
        /**
         * 未查到结果处理，数据库查询结果在该方法返回
         * @return
         */
        String fruitless();

    }

}
