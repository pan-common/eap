package com.taiji.eap.common.redis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.taiji.eap.common.redis.bean.Member;
import com.taiji.eap.common.redis.dao.RedisGeneratorDao;

@Repository
public class MemberDaoImpl extends RedisGeneratorDao<String, Member>{

	public boolean add(final Member member) {
		Assert.notNull(member, "redis持久化对象不可为null");
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key  = serializer.serialize(member.getId());
				byte[] name = serializer.serialize(member.getNickname());
				return connection.setNX(key, name);
			}
		});
		return result;
	}

	public boolean add(final List<Member> list) {
		Assert.notNull(list, "redis持久化对象不可为null");
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for (Member member : list) {
					byte[] key  = serializer.serialize(member.getId());
					byte[] name = serializer.serialize(member.getNickname());
					connection.setNX(key, name);
				}
				return true;
			}
		},false,true);
		return result;
	}

	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}

	public void delete(List<String> keys){
		redisTemplate.delete(keys);
	}

	public boolean update(final Member member){
		String key = member.getId();
		if(get(key)==null){
			throw new NullPointerException("数据不存在，key = "+key);
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key  = serializer.serialize(member.getId());
				byte[] name = serializer.serialize(member.getNickname());
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	public Member get(final String keyId) {
		Member result = redisTemplate.execute(new RedisCallback<Member>() {

			@Override
			public Member doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String nickname = serializer.deserialize(value);
				return new Member(keyId, nickname);
			}
		});
		return result;
	}

}
