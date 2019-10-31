package com.xr.biz.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.xr.biz.JlBiz;
import com.xr.dao.JlDao;
import com.xr.util.RedisPoolUtils;

@Service
public class JlBizImpl implements JlBiz {
	@Autowired
	private JlDao jlBizImpl;
	@Autowired
	private RedisPoolUtils redisUtil;

	@Override
	public String adminNumberOfQualifiedDB() {
		Map<String, int[]> adminNumberOfQualified = jlBizImpl.adminNumberOfQualified();
		String jsonString = JSON.toJSONString(adminNumberOfQualified);
		redisUtil.setString("adminNumberOfQualified", jsonString);
		return jsonString;
	}

	@Override
	public String adminNumberOfQualifiedRedis() {
		return redisUtil.getString("adminNumberOfQualified");
	}

	@Override
	public String zdNumberOfQualifiedDB() {
		Map<String, int[]> zdNumberOfQualified = jlBizImpl.zdNumberOfQualified();
		String jsonString = JSON.toJSONString(zdNumberOfQualified);
		redisUtil.setString("zdNumberOfQualified", jsonString);
		return jsonString;
	}

	@Override
	public String zdNumberOfQualifiedRedis() {
		// TODO Auto-generated method stub
		return redisUtil.getString("zdNumberOfQualified");
	}

	@Override
	public String fdNumberOfQualifiedDB() {
		Map<String, int[]> fdNumberOfQualified = jlBizImpl.fdNumberOfQualified();
		String jsonString = JSON.toJSONString(fdNumberOfQualified);
		redisUtil.setString("fdNumberOfQualified", jsonString);
		return jsonString;
	}

	@Override
	public String fdNumberOfQualifiedRedis() {
		// TODO Auto-generated method stub
		return redisUtil.getString("fdNumberOfQualified");
	}

	@Override
	@Transactional
	public String adminMaximumDetectionDB() {
		try {
			List adminMaximumDetection = jlBizImpl.adminMaximumDetection();
			String jsonString = JSON.toJSONString(adminMaximumDetection);
			redisUtil.setString("adminMaximumDetection", jsonString);
			return jsonString;
		} catch (SQLException e) {
			return adminMaximumDetectionRedis();
		}
	}

	@Override
	@Transactional
	public String otherMaximumDetectionDB() {
		try {
			List otherMaximumDetection = jlBizImpl.otherMaximumDetection();
			String jsonString = JSON.toJSONString(otherMaximumDetection);
			redisUtil.setString("otherMaximumDetection", jsonString);
			return jsonString;
		} catch (SQLException e) {
			return otherMaximumDetectionRedis();
		}
	}

	@Override
	@Transactional
	public String adminMaximumDetectionRedis() {
		try {
			String string = redisUtil.getString("adminMaximumDetection");
			return string;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public String otherMaximumDetectionRedis() {
		try {
			String string = redisUtil.getString("otherMaximumDetection");
			return string;
		} catch (Exception e) {
			return null;
		}
	}
}
