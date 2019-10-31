package com.xr.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xr.dao.BranchDao;
import com.xr.dao.impl.*;
import com.alibaba.fastjson.JSON;
import com.xr.biz.BranchBiz;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.RedisPoolUtils;
import com.xr.util.RedisUtil;

@Service
public class BranchBizImpl implements BranchBiz {
	@Autowired
	private BranchDao branchDaoImpl;
	@Autowired
	private RedisPoolUtils redisUtils;

	@Override
	@Transactional
	public String getBigBranchs(Boss boss) throws SQLException {
		System.out.println("查数据库");
		// 将总店下拉框数据查询出来放入map
		List<Branch> zdBranchs = branchDaoImpl.getBigBranchByBid(boss);

		String zdZlkStr = JSON.toJSONString(zdBranchs);
		// TODO: handle exception
		/* redisUtils.close(); */
		// 放入缓存
		redisUtils.setString("zdxlk", zdZlkStr);
		return zdZlkStr;
	}
	@Transactional
	public String getBigBranch(Boss boss) throws SQLException {
		System.out.println("查数据库");
		// 将总店下拉框数据查询出来放入map
		List<Branch> zdBranchs = branchDaoImpl.getBigBranchByBid(boss);
System.out.println(zdBranchs.size());
		String zdZlkStr = JSON.toJSONString(zdBranchs);
		// TODO: handle exception
		/* redisUtils.close(); */
		// 放入缓存
		return zdZlkStr;
	}

	@Override
	public String getsmallBranchs(String partid) throws SQLException {
		// 将分店下拉框数据查询出来放入map
		System.out.println("标记"+partid);
		List<Branch> fdBranchs = "a".equals(partid) ? branchDaoImpl.findAllBigBranch()
				: branchDaoImpl.getBigBranchByBid(partid);
		String fdZlkStr = JSON.toJSONString(fdBranchs);
		// 放入缓存
		redisUtils.setString("fdxlk", fdZlkStr);
		return fdZlkStr;
	}
	@Override
	public String getsmallBranch(String partid) throws SQLException {
		// 将分店下拉框数据查询出来放入map
		System.out.println("标记"+partid);
		List<Branch> fdBranchs = "a".equals(partid) ? branchDaoImpl.findAllBigBranch()
				: branchDaoImpl.getBigBranchByBid(partid);
		String fdZlkStr = JSON.toJSONString(fdBranchs);
		// 放入缓存
		return fdZlkStr;
	}

	@Override
	public String getBigBranchs() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
