package com.xr.dao;

import java.util.List;


import com.xr.entity.Boss;
import com.xr.entity.Customer;
public interface CustomerDao {
	List<Customer> getCustomerByRole(Boss boss,String bj);
	List<Customer> getAllCustomerByWhere(String name,String phone,String zdn,String fdn);
	Customer findByCustomer(Customer customer) throws Exception;
	
}
