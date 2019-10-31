package com.xr.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xr.dao.BossDao;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.EncryptionUtil;
import com.xr.util.HibernateUtil;

@Repository
public class BossDaoImpl implements BossDao{
	/**
	 * 登录账号查找
	 */
	@Override
	public Boss findByBoss(Boss boss) throws Exception{
		Session session = HibernateUtil.getSession();
		//Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Boss where account=?0");
		query.setParameter(0, boss.getAccount());
		Boss b1 = (Boss)query.uniqueResult();
		return b1;
	}

	/**
	 * 查询所登录的账号的店铺信息
	 */
	@Override
	public List<Branch> queryBossBranch(Boss boss) throws Exception {
		// TODO Auto-generated method stub
		//获取登录的账号查询他的角色
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(" r.rolename from TB_USER_ROLE u,TB_ROLE r,TB_BOSS b where b.mid=u.mid and r.roleid=u.roleid and b.mid=?0");
		query.setParameter(0,boss.getMid());
		String b = (String)query.uniqueResult();
		if (b.equals("超级管理员")) {
			//显示所有店铺数据
			Query query2 = session.createSQLQuery("select * from TB_BRANCH");
			List<Branch> list =query2.list();
			return list;
		}else if (b.equals("总店管理员")) {
			//显示自己分店的数据
			Query query2 = session.createSQLQuery("select * from select * from TB_BRANCH where partid=0?");
			query2.setParameter(0, boss.getNewBranch().getBid());
			Object result = query2.list();
		}
		return null;
	}
	/**
	 * 按条件查询系统账号
	 */
	@Override
	public List<Branch> queryByThree(Object[]... object) throws Exception {
	// TODO Auto-generated method stub
		/*if (phone.equals("")) {
			
		}*/
		return null;
	}
	/**
	 * 修改密码
	 */
	@Override
	public int updatePwd(Boss b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update Boss set password =?0 where mid=?1");
		query.setParameter(0, EncryptionUtil.encode(b.getPassword()));
		query.setParameter(1, b.getMid());
		int i = query.executeUpdate();
		transaction.commit();
		return i;
	}
	/**
	 * 删除系统账号
	 * 
	 */

	@Override
	public int del(Boss b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("update Boss set type=1 where mid=?0");
		query.setParameter(0, b.getMid());
		int i = query.executeUpdate();
		if (1>0) {
			return 1;
		}
		return 0;
	}
	//增加系统账号
	@Override
	public int addsys(Boss b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Serializable save = session.save(b);
		if (save!=null) {
			return 1;
		}
		return 0;
	}
	
	//修改个人信息
	@Override
	public int updateInfo(Boss b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery("update TB_BOSS set mname=?0 where mid=?1 ");
		query.setParameter(0, b.getMname());
		query.setParameter(1, b.getMid());		
		int i = query.executeUpdate();
		
		Query q = session.createSQLQuery("update TB_BRANCH set phone=?0 where bid=?1");
		q.setParameter(0, b.getNewBranch().getPhone());
		q.setParameter(1, b.getNewBranch().getBid());
		int j = q.executeUpdate();
		transaction.commit();
		if (i>0&&j>0) {
			return 1;
		}		
		return 0;
	}

	//查询个人信息
	@Override
	public List<Map<String, Object>> queryinfo(Boss b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery("select account,mname,phone from TB_BOSS,TB_BRANCH where TB_BOSS.bid=TB_BRANCH.bid and TB_BOSS.mid=?0");
		query.setParameter(0, b.getMid());
		List list = query.list();
		List<Map<String, Object>> maps = new ArrayList<>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] object = (Object[])it.next();
			Map<String, Object> map=new HashMap<>();
			map.put("zh", object[0]);
			map.put("mz", object[1]);
			map.put("dh", object[2]);
			maps.add(map);
			System.out.println(maps);
		}
		return maps;
	}
}
