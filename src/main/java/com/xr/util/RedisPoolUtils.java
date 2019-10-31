package com.xr.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
@Component
public class RedisPoolUtils {
	@Autowired
	private RedisPool pool;
	
	/**
	 * 判断是否有这个key
	 * @param key
	 * @return
	 */
	public Boolean hasKey(String key){
		Jedis redis=null;
		Boolean exists=null;
		try {
			redis = RedisPool.getredis();
			exists = redis.exists(key);
		} catch (Exception e) {
			return false;
		}
		return exists;
	}
	/**
	 * 清除所有key
	 */
	public void cleanDB(){
		Jedis redis = RedisPool.getredis();
		String flushDB = redis.flushDB();
		System.out.println("清除redis："+flushDB);
	}
	/**
	 * 往redis中存值，其他类型转换成json格式在传入即可
	 * @param key 键
	 * @param values 值
	 */
	public void setString(String key,String values){
		Jedis redis=null;
		//try{
			redis = RedisPool.getredis();
			redis.set(key, values);
			System.out.println("已存入缓存");
			redis.expire(key, 60);
			
		/*}catch (Exception e) {
			System.out.println("缓存失败");
		}*/
	}
	/**
	 * 获取redis中得值
	 * @param key 键
	 * @return
	 */
	public String getString(String key){
		Jedis redis=null;
		String values=null;
		try {
			redis = RedisPool.getredis();
			values = redis.get(key);
		} catch (Exception e) {
			return null;
		}
		System.out.println("进入缓存");
		return values;
	}
	/**
	 * 根据键获取值得长度
	 * @param key 键
	 * @return
	 */
	public Long getStringLength(String key){
		Jedis redis=null;
		Long length=0L;
		try {
			redis = RedisPool.getredis();
			length = redis.strlen(key);
		} catch (Exception e) {
			redis.del(key);
		}finally{
			
			length=0L;
		}
		return length;
	}
	/**
	 * 删除键
	 * @param key
	 */
	public void delString(String key){
		Jedis redis=null;
		try{
			redis = RedisPool.getredis();
			redis.del(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void close(){
		synchronized (this) {
			Jedis redis = RedisPool.getredis();
			redis.close();
		}
	}
}
