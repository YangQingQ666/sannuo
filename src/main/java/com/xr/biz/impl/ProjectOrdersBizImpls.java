package com.xr.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xr.biz.ProjectOrderBiz;
import com.xr.biz.pojo.ProjectOrderByWhereDB;
import com.xr.biz.pojo.ProjectOrderByWhereRedis;
import com.xr.dao.ProjectOrderDao;
import com.xr.dao.impl.ProjectOrderDaoImpl;
import com.xr.entity.JL;
import com.xr.entity.ProjectOrder;
import com.xr.util.RedisPoolUtils;
@Service
public class ProjectOrdersBizImpls implements ProjectOrderBiz {
	//单例工厂
	private static ProjectOrdersBizImpls projectOrdersBizImpls;
	//数据库状态
	private ProjectOrderBiz projectOrderByWhereDB;
	//缓存状态
	private ProjectOrderBiz projectOrderByWhereRedis;
	//当前状态
	private ProjectOrderBiz stam;
	public static ProjectOrdersBizImpls getProjectOrdersBizImpls(){
		if(projectOrdersBizImpls==null){
			projectOrdersBizImpls=new ProjectOrdersBizImpls();
		}
		return projectOrdersBizImpls;
	}
	private ProjectOrdersBizImpls() {
		projectOrderByWhereDB=new ProjectOrderByWhereDB();
		projectOrderByWhereRedis=new ProjectOrderByWhereRedis();
		stam=projectOrderByWhereDB;
	}
	public void setStam(ProjectOrderBiz stam){
		this.stam=stam;
	}
	@Override
	public String findProjectOrderByWhere(List<Object> list) {
		stam=new RedisPoolUtils().getStringLength("orderAnomalyListFindByWhere") == 0 ? projectOrderByWhereDB: projectOrderByWhereRedis;
		String findProjectOrderByWhere = stam.findProjectOrderByWhere(list);
		return findProjectOrderByWhere;
	}
	/**
	 * 独有的搜索查询无接口
	 */
	public String findPublicinspectionRecords(String zd,String fd,String start,String end){
		ProjectOrderDao projectOrderDaoImpl=new ProjectOrderDaoImpl();
		List<JL> findPublicinspectionRecords = projectOrderDaoImpl.findPublicinspectionRecords(zd,fd,start,end);
		String jsonString = JSON.toJSONString(findPublicinspectionRecords);
		return jsonString;
	}
}
