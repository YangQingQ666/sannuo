package com.xr.biz;

import java.util.List;
import java.util.Map;

import com.xr.entity.Customer;


public interface TesterBiz {
	//根据id查询检测数据
	public List<Map<String, Object>> query();
	
	//根据id查询个人信息 
	public List<Customer> select();
}
