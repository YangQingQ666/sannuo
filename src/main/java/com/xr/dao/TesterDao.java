package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.Customer;
import com.xr.entity.Project;

public interface TesterDao {
	//根据id查询检测者数据
	public List<Map<String, Object>> query();
	
	//根据id查询个人信息
	public List<Customer> select();
}
