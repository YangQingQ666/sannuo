package com.xr.biz;

import java.util.List;
import java.util.Map;

import com.xr.entity.Customer;


public interface TesterBiz {
	//����id��ѯ�������
	public List<Map<String, Object>> query();
	
	//����id��ѯ������Ϣ 
	public List<Customer> select();
}
