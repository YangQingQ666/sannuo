package com.xr.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.xr.biz.CustomerBiz;
import com.xr.dao.CustomerDao;
import com.xr.entity.Boss;
import com.xr.entity.Customer;
import com.xr.util.RedisPoolUtils;
@Service
public class CustomerBizImpl implements CustomerBiz {
	@Autowired
	private CustomerDao customerDaoImpl;
	@Autowired
	private RedisPoolUtils redisUtil;
	@Override
	@Transactional
	public String getAllCustomerByRole(Boss boss,String bj) {
		List<Customer> customers=null;
		String jsonStr=null;
		System.out.println("进入数据库");
		try {
			customers = customerDaoImpl.getCustomerByRole(boss,bj);
			jsonStr = JSON.toJSONString(customers);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			/*redisUtil.close();*/
		}
		//缓存
		redisUtil.setString("Custom", jsonStr);
		return jsonStr;
	}
	@Override
	@Transactional
	public List<Customer> getAllCustomerByWhere(String name, String phone, String zdn, String fdn) {
		List<Customer> customers = customerDaoImpl.getAllCustomerByWhere(name, phone, zdn, fdn);
		
		return customers;
	}
	@Override
	public Customer findByCustomer(Customer customer) throws Exception {
		return customerDaoImpl.findByCustomer(customer);
	}

	

}
