package com.xr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RedisTest {
	@Test
	public void setTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-redis.xml","applicationContext.xml");
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) context.getBean("jedisTemplate");
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("a", "a");
		System.out.println(opsForValue.get("a"));
	}
	@Test
	public void getTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-redis.xml","applicationContext.xml");
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) context.getBean("jedisTemplate");
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		System.out.println(opsForValue.get("a"));
	}
	@Test
	public void getPoolTest(){
		Jedis jedis=new Jedis("47.103.156.108",6379,2000);
		
		jedis.auth("123456");
		System.out.println(jedis.ping());
		jedis.connect();
		jedis.set("a", "a");
		jedis.close();
		
	/*	JedisPool jedisPool = new JedisPool("47.103.156.108",6379); 
		Jedis jedis = jedisPool.getResource();
		jedis.set("a","a");
		jedis.close();
		jedisPool.close();*/
	}
	
}
