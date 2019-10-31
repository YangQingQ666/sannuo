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
import org.springframework.stereotype.Repository;

import com.xr.dao.JurisdictionDao;
import com.xr.entity.Jurisdiction;
import com.xr.util.HibernateUtil;
@Repository
public class JurisdictionDaoImp implements JurisdictionDao {
	/**
	 * 查权限
	 */
	@Override
	public Map<String, List<Map<String, Object>>> findByJurisdiction(String bname) throws Exception {
		Map<String, List<Map<String, Object>>> map=new HashMap<>();
		List<Map<String, Object>> findByO = findByO(bname);
		List<Map<String, Object>> findByNO = findByNO(bname);
		map.put("wai", findByO);
		map.put("nei", findByNO);
		return map;
	}
	public List<Map<String, Object>> findByNO(String bname){
		Session session = HibernateUtil.getSession();
		String hql="select b.mid,b.account,r.rolename,b.type,b.`comment`,j.jid,j.jname,j.partid,j.url,j.icon from TB_USER_ROLE ur,TB_BOSS b,TB_ROLE_JURISDICTION rj,TB_JURISDICTION j,TB_ROLE r  where b.account=?0  and b.mid=ur.mid and ur.roleid=r.roleid and j.jid=rj.jid and rj.rid=r.roleid and j.partid<>0";
		Query query = session.createSQLQuery(hql);
		query.setParameter(0, bname);
		List<Map<String, Object>> li=new ArrayList<>();
		List list = query.list();
		Iterator<Object[]> it = list.iterator();
		while(it.hasNext()){
			Map<String, Object> map=new HashMap<>();
			Object[] object = it.next();
			map.put("mid", object[0]);
			map.put("account", object[1]);
			map.put("rolename", object[2]);
			map.put("type", object[3]);
			map.put("comment", object[4]);
			map.put("jid", object[5]);
			map.put("jname", object[6]);
			map.put("partid", object[7]);
			map.put("url", object[8]);
			map.put("icon", object[9]);
			li.add(map);
		}
		return li;
	}
	public List<Map<String, Object>> findByO(String bname){
		Session session = HibernateUtil.getSession();
		String hql="select b.mid,b.account,r.rolename,b.type,b.`comment`,j.jid,j.jname,j.partid,j.icon from TB_USER_ROLE ur,TB_BOSS b,TB_ROLE_JURISDICTION rj,TB_JURISDICTION j,TB_ROLE r where b.account=?0 and b.mid=ur.mid and ur.roleid=r.roleid and j.jid=rj.jid and rj.rid=r.roleid  and j.partid=0";
		Query query = session.createSQLQuery(hql);
		query.setParameter(0, bname);
		List<Map<String, Object>> li=new ArrayList<>();
		List list = query.list();
		Iterator<Object[]> it = list.iterator();
		while(it.hasNext()){
			Map<String, Object> map=new HashMap<>();
			Object[] object = it.next();
			map.put("mid", object[0]);
			map.put("account", object[1]);
			map.put("rolename", object[2]);
			map.put("type", object[3]);
			map.put("comment", object[4]);
			map.put("jid", object[5]);
			map.put("jname", object[6]);
			map.put("partid", object[7]);
			map.put("icon", object[8]);
			li.add(map);
		}
		return li;
	}
	/**
	 * 查询所有权限
	 */
	@Override
	public List<Jurisdiction> findByJurisdiction() throws Exception {
		Session session = HibernateUtil.getSession();
		List<Jurisdiction> list = session.createQuery("from Jurisdiction").list();
		return list;
	}
	@Override
	public List<Jurisdiction> findByO() {
		Session session = HibernateUtil.getSession();
		String hql="from Jurisdiction where partid=0 and state=0";
	List<Jurisdiction> list = session.createQuery(hql).list();
		return list;
	}
	@Override
	public  List<Jurisdiction> findByNO() {
		Session session = HibernateUtil.getSession();
		String hql="from Jurisdiction where partid<>0 and state=0";
		List<Jurisdiction> list = session.createQuery(hql).list();
		return list;
	}
	@Override
	public boolean findByJurisdictionNameId(String name, int id) throws Exception {
		Session session = HibernateUtil.getSession();
		String hql="select * from TB_JURISDICTION j,TB_ROLE_JURISDICTION rj where j.jid=rj.jid and rj.rid=?0 and j.jname=?1";
		Query query = session.createSQLQuery(hql);
		query.setParameter(0, id);
		query.setParameter(1, name);
		Object result = query.uniqueResult();
		if(result!=null){
			return true;
		}
		return false;
	}
	/**
	 * 新增菜单
	 */
	@Override
	public int saveMenumanage(Jurisdiction j) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(j);
		transaction.commit();
		if(save!=null){
			return 1;
		}
		return 0;
	}
	@Override
	public Jurisdiction findById(int id) throws Exception {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Jurisdiction where jid=?0");
		query.setParameter(0, id);
		Jurisdiction jurisdiction=(Jurisdiction) query.uniqueResult();
		return jurisdiction;
	}
	@Override
	public int upJurisdictionById(Jurisdiction j) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update Jurisdiction set jname=?0,partid=?1,url=?2,icon=?3 where jid=?4");
		query.setParameter(0, j.getJname());
		query.setParameter(1, j.getPartid());
		query.setParameter(2, j.getUrl());
		query.setParameter(3, j.getIcon());
		query.setParameter(4, j.getJid());
		int i = query.executeUpdate();
		transaction.commit();
		return i;
	}
	@Override
	public int upJurisdistionByState(int id, int state) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update Jurisdiction set state=?0 where jid=?1");
		query.setParameter(0, state);
		query.setParameter(1, id);
		int i = query.executeUpdate();
		transaction.commit();
		return i;
	}
	

}
