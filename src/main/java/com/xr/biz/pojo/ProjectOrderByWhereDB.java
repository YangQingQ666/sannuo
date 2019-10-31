package com.xr.biz.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xr.biz.ProjectOrderBiz;
import com.xr.biz.impl.ProjectOrdersBizImpls;
import com.xr.dao.ProjectOrderDao;
import com.xr.dao.impl.ProjectOrderDaoImpl;
import com.xr.util.RedisPoolUtils;
@Service
public class ProjectOrderByWhereDB implements ProjectOrderBiz {
	@Autowired
	private RedisPoolUtils redisUtil=new RedisPoolUtils();
	@Override
	public String findProjectOrderByWhere(List<Object> list) {
		ProjectOrderDao paoDao=new ProjectOrderDaoImpl();
		Map<String, Map<String, Integer>> findByWhere = paoDao.findByWhere(list);
		String jsonString = JSON.toJSONString(findByWhere);
		System.out.println(jsonString);
		//redisUtil.setString("orderAnomalyListFindByWhere", jsonString);
		
		//ProjectOrdersBizImpls.getProjectOrdersBizImpls().setStam(new ProjectOrderByWhereRedis());
		return jsonString;
	}

}
