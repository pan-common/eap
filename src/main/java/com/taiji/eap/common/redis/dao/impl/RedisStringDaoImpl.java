package com.taiji.eap.common.redis.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.taiji.eap.common.redis.dao.RedisGeneratorDao;

@Repository
public class RedisStringDaoImpl extends RedisGeneratorDao<String, String>{

	/**
	 * 设置键值对
	 * @param key
	 * @param value
	 */
	public void add(String key,String value){
		redisTemplate.opsForValue().set(key, value);
	}
	/**
	 * 设置键值对并设置超时时间
	 * @param key
	 * @param value
	 * @param timeout
	 * @param unit
	 */
	public void add(String key,String value,long timeout,TimeUnit unit){
		redisTemplate.opsForValue().set(key, value, timeout, unit);
	}
	/**
	 * 根据键获取值
	 * @param key
	 * @return
	 */
	public String get(String key){
		return redisTemplate.opsForValue().get(key);
	}
	/**
	 * 设置新值并返回旧值
	 * @param key
	 * @param value
	 * @return
	 */
	public String getAndSet(String key,String value){
		return redisTemplate.opsForValue().getAndSet(key, value);
	}
	
}
