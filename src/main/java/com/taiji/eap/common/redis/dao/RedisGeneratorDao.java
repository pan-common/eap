package com.taiji.eap.common.redis.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class RedisGeneratorDao<V extends Serializable> {

	@Resource
	protected RedisTemplate<String, V> redisTemplate;
	
	public void setRedisTemplate(RedisTemplate<String, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	protected RedisSerializer<String> getRedisSerializer(){
		return redisTemplate.getStringSerializer();
	}
	
}
