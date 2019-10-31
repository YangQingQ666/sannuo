package com.xr.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xr.dao.CustomerDao;
import com.xr.entity.Boss;
import com.xr.entity.Customer;
import com.xr.util.HibernateUtil;
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getCustomerByRole(Boss boss,String bj) {
		Session session = HibernateUtil.getSession();
		List<Customer> Customers=null;
		if(boss.getNewBranch()!=null){
			 int bid = boss.getNewBranch().getBid();
			 Customers=bj.equals("b") ? session.createQuery("FROM Customer WHERE partid="+bid).list():session.createQuery("FROM Customer WHERE bid="+bid).list();
		}else{
			Customers = session.createQuery("FROM Customer").list();
		}
		return Customers;
	}

	@Override
	public List<Customer> getAllCustomerByWhere(String name, String phone, String zdn, String fdn){
		StringBuffer hql=new StringBuffer("FROM Customer WHERE ");
			//如果是""则不按名称搜索支持模糊查询
			hql.append("".equals(name) ? "":"cname like '%"+name+"%' and ");
			//如果是""则不按名称号码支持模糊查询
			hql.append("".equals(phone) ? "":"phone like '%"+phone+"%' and ");
			if(zdn.equals("a") && fdn.equals("b")){
				
			}else if(zdn.equals("a")&&!fdn.equals("b")||!fdn.equals("b")&&!zdn.equals("a")){
				System.out.println("a!b");
				hql.append("branch.bid="+fdn+" and ");
			}else if(fdn.equals("b")&&!zdn.equals("a")){
				System.out.println("b!a");
				hql.append("branch.partid="+zdn+" and ");
			}
			hql.append("1=1");
			System.out.println(hql);
			Session session = HibernateUtil.getSession();
			List<Customer> customers = session.createQuery(hql.toString()).list();
		return customers;
	}
	/**
	 * 查询登录的检测者
	 */
	@Override
	public Customer findByCustomer(Customer customer) throws Exception {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Customer where phone=?0");
		query.setParameter(0,customer.getPhone());
		Customer customer1=(Customer) query.uniqueResult();
		return customer1;
	}



}
