package com.xr.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xr.dao.RoleDao;
import com.xr.entity.Role;
import com.xr.util.HibernateUtil;
@Repository
public class RoleDaoImp implements RoleDao{
	/**
	 * 角色权限
	 */
	public  List<Role> findByRole(){
		 Session session = HibernateUtil.getSession();
		 List<Role> list = session.createQuery("from Role").list();
		 return list;
	 }
}
