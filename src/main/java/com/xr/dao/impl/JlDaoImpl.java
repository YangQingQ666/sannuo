package com.xr.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xr.dao.JlDao;
import com.xr.entity.Boss;
import com.xr.entity.JL;
import com.xr.util.DataUtil;
import com.xr.util.HibernateUtil;
import com.xr.util.Number;

@Repository
public class JlDaoImpl implements JlDao {
	/**
	 * 超级管理员查看所有店铺月度数据报表
	 */
	@Override
	public Map<String, int[]> adminNumberOfQualified() {
		Session session = HibernateUtil.getSession();
		List<JL> jLs = session.createQuery("FROM JL WHERE time>='"+DataUtil.formatData(DataUtil.getmindate())+"' and time<='"+DataUtil.formatData(DataUtil.getmaxdate())+"'").list();
		System.out.println(jLs);
		Map<String, int[]> qualifiedPersons = Number.qualifiedPersons(jLs);
		for (int i = 0; i < qualifiedPersons.get("pass").length; i++) {
			System.out.print(qualifiedPersons.get("pass")[i]);
		}
		System.out.println("-------------------------");
		for (int i = 0; i < qualifiedPersons.get("pass").length; i++) {
			System.out.print(qualifiedPersons.get("nopass")[i]);
		}
		return qualifiedPersons;
	}
	/**
	 * 总店月度数据报表
	 */
	@Override
	public Map<String, int[]> zdNumberOfQualified() {
		HttpSession session2 = ServletActionContext.getRequest().getSession();
		Boss boss = (Boss) session2.getAttribute("boss");
		Session session = HibernateUtil.getSession();
		System.out.println("FROM JL WHERE time>='"+DataUtil.formatData(DataUtil.getmindate())+"' and time<='"+DataUtil.formatData(DataUtil.getmaxdate())+"' and JL.cids.bids.partid="+boss.getNewBranch().getBid());
		List jLs = session.createSQLQuery("SELECT TB_JL.cid jcid,TB_JL.dgc,TB_JL.ssy,TB_JL.szy,TB_JL.xtang,TB_JL.gysz,TB_JL.xhdb,TB_JL.xns,TB_JL.xton,TB_JL.time,TB_JL.commont,TB_JL.method,TB_CUSTOMER.bid,TB_CUSTOMER.csex,TB_CUSTOMER.cage,TB_BRANCH.bid bbid,TB_BRANCH.partid FROM TB_JL,TB_CUSTOMER,TB_BRANCH WHERE TB_JL.cid=TB_CUSTOMER.cid and TB_CUSTOMER.bid=TB_BRANCH.bid and TB_JL.time>='"+DataUtil.formatData(DataUtil.getmindate())+"' and TB_JL.time<='"+DataUtil.formatData(DataUtil.getmaxdate())+"' and TB_BRANCH.bid="+boss.getNewBranch().getBid()).list();
		List<Map<String, String>> lists=new ArrayList<Map<String,String>>();
		Map<String, String> maps=null;
		Object[] le=null;
		for (int i = 0; i < jLs.size(); i++) {
			maps=new HashMap<String, String>();
			le=(Object[])jLs.get(i);
			maps.put("age", le[0].toString());
			maps.put("dgc", le[1].toString());
			maps.put("ssy", le[2].toString());
			maps.put("szy", le[3].toString());
			maps.put("xtang", le[4].toString());
			maps.put("gysz", le[5].toString());
			maps.put("xhdb", le[6].toString());
			maps.put("xns", le[7].toString());
			maps.put("xton", le[8].toString());
			maps.put("time", le[9].toString());
			maps.put("sex", le[13].toString());
			lists.add(maps);
		}
		Map<String, int[]> qualifiedPersons = Number.qualifiedPersonsDB(lists);
		return qualifiedPersons;
	}
	/**
	 * 分店月度报表
	 */
	@Override
	public Map<String, int[]> fdNumberOfQualified() {
		HttpSession session2 = ServletActionContext.getRequest().getSession();
		Boss boss = (Boss) session2.getAttribute("boss");
		Session session = HibernateUtil.getSession();
		System.out.println("FROM JL WHERE time>='"+DataUtil.formatData(DataUtil.getmindate())+"' and time<='"+DataUtil.formatData(DataUtil.getmaxdate())+"' and JL.cids.bids.partid="+boss.getNewBranch().getBid());
		List jLs = session.createSQLQuery("SELECT TB_JL.cid jcid,TB_JL.dgc,TB_JL.ssy,TB_JL.szy,TB_JL.xtang,TB_JL.gysz,TB_JL.xhdb,TB_JL.xns,TB_JL.xton,TB_JL.time,TB_JL.commont,TB_JL.method,TB_CUSTOMER.bid,TB_CUSTOMER.csex,TB_CUSTOMER.cage,TB_BRANCH.bid bbid,TB_BRANCH.partid FROM TB_JL,TB_CUSTOMER,TB_BRANCH WHERE TB_JL.cid=TB_CUSTOMER.cid and TB_CUSTOMER.bid=TB_BRANCH.bid and TB_JL.time>='"+DataUtil.formatData(DataUtil.getmindate())+"' and TB_JL.time<='"+DataUtil.formatData(DataUtil.getmaxdate())+"' and TB_BRANCH.bid="+boss.getNewBranch().getBid()).list();
		List<Map<String, String>> lists=new ArrayList<Map<String,String>>();
		Map<String, String> maps=null;
		Object[] le=null;
		for (int i = 0; i < jLs.size(); i++) {
			maps=new HashMap<String, String>();
			le=(Object[])jLs.get(i);
			maps.put("age", le[0].toString());
			maps.put("dgc", le[1].toString());
			maps.put("ssy", le[2].toString());
			maps.put("szy", le[3].toString());
			maps.put("xtang", le[4].toString());
			maps.put("gysz", le[5].toString());
			maps.put("xhdb", le[6].toString());
			maps.put("xns", le[7].toString());
			maps.put("xton", le[8].toString());
			maps.put("time", le[9].toString());
			maps.put("sex", le[13].toString());
			lists.add(maps);
		}
		Map<String, int[]> qualifiedPersons = Number.qualifiedPersonsDB(lists);
		return qualifiedPersons;
	}
	@Override
	public List adminMaximumDetection() throws SQLException {
		List list =null;
		try {
			Session session = HibernateUtil.getSession();
			list = session.createSQLQuery("SELECT b.bid, b.bname, (SELECT bname FROM TB_BRANCH WHERE TB_BRANCH.bid = b.partid ) zbname, (SELECT count(*) FROM TB_JL, TB_CUSTOMER WHERE TB_JL.cid = TB_CUSTOMER.cid AND TB_CUSTOMER.bid = b.bid ) count FROM TB_JL j, TB_CUSTOMER c, TB_BRANCH b WHERE j.cid = c.cid AND b.bid = c.cid GROUP BY bid, bname, zbname, count  LIMIT 0,10").list();
			return list;
		} catch (Exception e) {
			throw new SQLException("dao中sql抛出异常转biz");
		}
	}
	@Override
	public List<JL> otherMaximumDetection() throws SQLException {
		List list =null;
		try {
			Session session = HibernateUtil.getSession();
			Boss boss = (Boss) ServletActionContext.getRequest().getSession().getAttribute("boss");
			list = session.createSQLQuery("SELECT b.bid, b.bname, (SELECT bname FROM TB_BRANCH WHERE TB_BRANCH.bid = b.partid ) zbname, (SELECT count(*) FROM TB_JL, TB_CUSTOMER WHERE TB_JL.cid = TB_CUSTOMER.cid AND TB_CUSTOMER.bid = b.bid ) count FROM TB_JL j, TB_CUSTOMER c, TB_BRANCH b WHERE j.cid = c.cid AND b.bid = c.cid AND b.partid="+boss.getNewBranch().getBid() +"GROUP BY bid, bname, zbname, count LIMIT 0,10").list();
			return list;
		} catch (Exception e) {
			throw new SQLException("dao中sql抛出异常转biz");
		}
	}

}
