package com.xr.util;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;
@Component
public class RedisPool {
	private static Jedis jedis;
	static{
		// 比较特殊的是，redis连接池的配置首先要创建一个连接池配置对象
	    JedisPoolConfig config = new JedisPoolConfig();
	    // 当然这里还有设置属性的代码
	    // 创建Jedis连接池对象
	    JedisPool jedisPool = new JedisPool(config, "47.103.156.108", 6379, 2000, "123456", false);//config, "47.103.156.108", "6379", 2000, "123456", false
	    // 获取连接
	    jedis = jedisPool.getResource();
	}
	private static void loadRedis(){
		synchronized (jedis) {
			// 比较特殊的是，redis连接池的配置首先要创建一个连接池配置对象
		    JedisPoolConfig config = new JedisPoolConfig();
		    config.setMaxIdle(100);
		    config.setTimeBetweenEvictionRunsMillis(3000);
		    try {
				config.wait(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    config.setTestOnBorrow(true);
		    config.setTestOnReturn(true);
		    // 当然这里还有设置属性的代码
		    // 创建Jedis连接池对象
		    JedisPool jedisPool = new JedisPool(config, "47.103.156.108", 6379, 2000, "123456", false);//config, "47.103.156.108", "6379", 2000, "123456", false
		    // 获取连接
		    jedis = jedisPool.getResource();
		}
		
	}
	
	public static Jedis getredis(){
		try{
			if(jedis==null){
				loadRedis();
			}
		}catch (Exception e) {
			loadRedis();
		}
	    return jedis;
	}
	

   

	// 关闭，归还连接到连接池
	public void close(){
		if(jedis!=null){
			jedis.close();
		}
	}
}
