package com.xr.biz.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xr.biz.ProjectOrderBiz;
import com.xr.dao.ProjectOrderDao;
import com.xr.dao.impl.ProjectOrderDaoImpl;
import com.xr.util.RedisPoolUtils;
@Service
public class ProjectOrderByWhereRedis implements ProjectOrderBiz {
	@Autowired
	private RedisPoolUtils redisUtil=new RedisPoolUtils();
	@Override
	public String findProjectOrderByWhere(List<Object> list) {
		String string = redisUtil.getString("orderAnomalyListFindByWhere");
		return string;
	}

}
