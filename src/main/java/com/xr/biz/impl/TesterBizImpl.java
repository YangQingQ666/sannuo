package com.xr.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.biz.TesterBiz;
import com.xr.dao.TesterDao;
import com.xr.dao.impl.TesterDaoImpl;
import com.xr.entity.Customer;
import com.xr.entity.Project;

@Service
public class TesterBizImpl implements TesterBiz{

	@Autowired
	private TesterDao testerdao;

	@Override
	public List<Map<String, Object>> query() {
		// TODO Auto-generated method stub
		return testerdao.query();
	}

	@Override
	public List<Customer> select() {
		// TODO Auto-generated method stub
		return testerdao.select();
	}
	
	
}
