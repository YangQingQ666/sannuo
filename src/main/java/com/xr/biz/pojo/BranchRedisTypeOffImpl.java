package com.xr.biz.pojo;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xr.biz.BranchRedisType;
import com.xr.biz.impl.BranchRedisZdXlkType;
import com.xr.dao.BranchDao;
import com.xr.dao.impl.BranchDaoImpl;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.RedisPoolUtils;
/**
 * 总店下拉框查询数据库实现类（状态模式）
 * @author Administrator
 *
 */
@Service
public class BranchRedisTypeOffImpl implements BranchRedisType{
	@Autowired
	private BranchDao branchDaoImpl;
	public BranchRedisTypeOffImpl() {
		
		branchDaoImpl=new BranchDaoImpl();
	}
	@Override
	public String findBranchZdXlk() {
		BranchRedisZdXlkType branchRedisZdXlkType=BranchRedisZdXlkType.getBranchRedisZdXlkType();
		Boss boss = (Boss) ServletActionContext.getRequest().getSession().getAttribute("boss");
		List<Branch> zdBranchs=null;
		try {
			System.out.println("查询数据库");
			System.out.println(boss);
			zdBranchs = branchDaoImpl.getBigBranchByBid(boss);
			String zdZlkStr = JSON.toJSONString(zdBranchs);
			//修改状态为查询缓存
			branchRedisZdXlkType.setStam(branchRedisZdXlkType.getBranchRedisTypeOnImpl());
			new RedisPoolUtils().setString("zdxlk", zdZlkStr);
			return zdZlkStr;
		} catch (SQLException e) {
			return null;
		}

		
	}



}
