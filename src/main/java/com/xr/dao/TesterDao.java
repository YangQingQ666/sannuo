package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.Customer;
import com.xr.entity.Project;

public interface TesterDao {
	//����id��ѯ���������
	public List<Map<String, Object>> query();
	
	//����id��ѯ������Ϣ
	public List<Customer> select();
}
