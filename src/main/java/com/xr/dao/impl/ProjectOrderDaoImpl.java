package com.xr.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xr.dao.ProjectOrderDao;
import com.xr.entity.JL;
import com.xr.entity.Project;
import com.xr.entity.ProjectOrder;
import com.xr.util.HibernateUtil;
import com.xr.util.Number;

public class ProjectOrderDaoImpl implements ProjectOrderDao {
	private static Map<String, List<Integer>> mMaps;

	private void a(List<Object> list) {
		mMaps = findAllByWhere(list);
	}

	@Override
	public Map<String, Map<String, Integer>> findByWhere(List<Object> list) {
		a(list);
		Map<String, Map<String, Integer>> maps = new HashMap<String, Map<String, Integer>>();
		// 加入低标准数据
		maps.put("OnTheLowSide", OnTheLowSide());
		// 加入正常人数数据
		maps.put("normal", normal());
		// 加入数值偏高人数数据
		maps.put("OnTheHighSide", OnTheHighSide());
		// 加入数值特高高人数数据
		maps.put("veryHigh", veryHigh());
		return maps;
	}

	private Map<String, Integer> veryHigh() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		List<Integer> lists1 = mMaps.get("boy");
		int boyCount = 0;
		for (Integer a : lists1) {
			if (!Number.isPrime(a) && a % 2 != 0) {
				boyCount++;
			}
		}
		maps.put("boy", boyCount);
		boyCount = 0;
		List<Integer> lists2 = mMaps.get("gily");
		for (Integer a : lists2) {
			if (!Number.isPrime(a) && a % 2 != 0) {
				boyCount++;
			}
		}
		maps.put("gily", boyCount);
		return maps;
	}

	/**
	 * 计算数值偏高的人数
	 * 
	 * @return
	 */
	private Map<String, Integer> OnTheHighSide() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		List<Integer> lists1 = mMaps.get("boy");
		int boyCount = 0;
		for (Integer a : lists1) {
			if (!Number.isPrime(a) && a % 2 == 0) {
				boyCount++;
			}
		}
		maps.put("boy", boyCount);
		boyCount = 0;
		List<Integer> lists2 = mMaps.get("gily");
		for (Integer a : lists2) {
			if (!Number.isPrime(a) && a % 2 == 0) {
				boyCount++;
			}
		}
		maps.put("gily", boyCount);
		return maps;
	}

	/**
	 * 计算正常数值男女人数
	 * 
	 * @return
	 */
	private Map<String, Integer> normal() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		List<Integer> lists1 = mMaps.get("boy");
		int boyCount = 0;
		for (Integer a : lists1) {
			if (a < 0) {
				boyCount++;
			}
		}
		maps.put("boy", boyCount);
		boyCount = 0;
		List<Integer> lists2 = mMaps.get("gily");
		for (Integer a : lists2) {
			if (a < 0) {
				boyCount++;
			}
		}
		maps.put("gily", boyCount);
		return maps;
	}

	/**
	 * 计算过低指数男女人数
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, Integer> OnTheLowSide() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		List<Integer> lists1 = mMaps.get("boy");
		int boyCount = 0;
		for (Integer a : lists1) {
			if (Number.isPrime(a) && a % 2 != 0) {
				boyCount++;
			}
		}
		maps.put("boy", boyCount);
		boyCount = 0;
		List<Integer> lists2 = mMaps.get("gily");
		for (Integer a : lists2) {
			if (Number.isPrime(a) && a % 2 != 0) {
				boyCount++;
			}
		}
		maps.put("gily", boyCount);
		return maps;
	}

	/**
	 * 根据条件查询
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, List<Integer>> findAllByWhere(List<Object> list) {
		StringBuffer boyhql = new StringBuffer(
				"SELECT TB_PROJECT_ORDER.did FROM TB_PROJECT_ORDER LEFT JOIN TB_CUSTOMER ON TB_PROJECT_ORDER.cid = TB_CUSTOMER.cid LEFT JOIN TB_PROJECT ON TB_PROJECT_ORDER.did = TB_PROJECT.did WHERE TB_CUSTOMER.csex = '男'");
		// select ProjectOrder.newProject from ProjectOrder left join Customer
		// on ProjectOrder.newCustomer=Customer.cid left join Project on
		// ProjectOrder.newProject=Project.did where Customer.csex='男'
		StringBuffer gilyhql = new StringBuffer(
				"SELECT TB_PROJECT_ORDER.did FROM TB_PROJECT_ORDER LEFT JOIN TB_CUSTOMER ON TB_PROJECT_ORDER.cid = TB_CUSTOMER.cid LEFT JOIN TB_PROJECT ON TB_PROJECT_ORDER.did = TB_PROJECT.did WHERE TB_CUSTOMER.csex = '女'");
		if (!"b".equals(list.get(0))) {
			boyhql.append(" AND TB_CUSTOMER.bid=" + list.get(0));
			gilyhql.append(" AND TB_CUSTOMER.bid=" + list.get(0));
		}
		if (!"c".equals(list.get(1))) {
			boyhql.append(" AND TB_PROJECT_ORDER.did<>" + list.get(1));
			gilyhql.append(" AND TB_PROJECT_ORDER.did<>" + list.get(1));
		}
		if (!"全部".equals(list.get(2))) {
			boyhql.append(" AND TB_CUSTOMER.cage");
			gilyhql.append(" AND TB_CUSTOMER.cage");
			if ("婴幼儿(0-6)".equals(list.get(2))) {
				boyhql.append("<=6");
				gilyhql.append("<=6");
			} else if ("老年(≥50)".equals(list.get(2))) {
				boyhql.append(">=50");
				gilyhql.append(">=50");
			} else {
				// 剪切
				String ages = list.get(2).toString().substring(list.get(2).toString().indexOf("(") + 1,
						list.get(2).toString().lastIndexOf("") - 1);
				String[] age = ages.split("-");
				boyhql.append(">=" + age[0] + " AND TB_CUSTOMER.cage<" + age[1]);
				gilyhql.append(">=" + age[0] + " AND TB_CUSTOMER.cage<" + age[1]);
			}
		}
		if ("".equals(list.get(3)) && !"".equals(list.get(3))) {
			boyhql.append(" AND TB_PROJECT_ORDER.time between '2019-10-26' and '" + list.get(4) + "'");
			gilyhql.append(" AND TB_PROJECT_ORDER.time between '2019-10-26' and '" + list.get(4) + "'");
		} else if (!"".equals(list.get(3)) && "".equals(list.get(3))) {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			boyhql.append(" AND TB_PROJECT_ORDER.time between '" + list.get(3) + "' and '" + format + "'");
			gilyhql.append(" AND TB_PROJECT_ORDER.time between '" + list.get(3) + "' and '" + format + "'");
		} else if (!"".equals(list.get(3)) && !"".equals(list.get(3))) {
			boyhql.append(" AND TB_PROJECT_ORDER.time between '" + list.get(3) + "' and '" + list.get(4) + "'");
			gilyhql.append(" AND TB_PROJECT_ORDER.time between '" + list.get(3) + "' and '" + list.get(4) + "'");
		}
		Session session = HibernateUtil.getSession();
		System.out.println(boyhql);
		List<Integer> boy = session.createSQLQuery(boyhql.toString()).list();
		List<Integer> gily = session.createSQLQuery(gilyhql.toString()).list();
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("boy", boy);
		map.put("gily", gily);
		return map;
	}

	public List<Project> findByProjectAllByBoy() {
		Session session = HibernateUtil.getSession();

		List<Project> list = session
				.createQuery(
						"SELECT * From ProjectOrder po,Customer c,Project p WHERE po.newCustomer=c.cid AND po.did=p.did AND c.csex='男'")
				.list();
		return list;
	}

	public List<Project> findByProjectAllByGily() {
		Session session = HibernateUtil.getSession();
		List<Project> list = session
				.createQuery(
						"SELECT * From ProjectOrder po,Customer c,Project p WHERE po.newCustomer=c.cid AND po.did=p.did AND c.csex='女'")
				.list();
		return list;
	}

	@Override
	public List<JL> findPublicinspectionRecords(String zd,String fd, String start, String end) {
		Session session = HibernateUtil.getSession();
		System.out.println(zd+fd+start+end);
		StringBuilder hql=new StringBuilder("SELECT	TB_JL.*,TB_CUSTOMER.cid as csid,TB_CUSTOMER.bid,TB_CUSTOMER.cname,TB_CUSTOMER.csex,TB_CUSTOMER.cage,TB_CUSTOMER.phone,TB_CUSTOMER.count,TB_CUSTOMER.lasttime FROM TB_JL,TB_CUSTOMER,TB_BRANCH WHERE TB_JL.cid=TB_CUSTOMER.cid AND TB_BRANCH.bid=TB_CUSTOMER.bid and");
		StringBuilder hql2=null;
		if(zd.equals("a")&&!fd.equals("b")){
			hql.append(" TB_BRANCH.bid="+fd+" and ");
		}else if(!zd.equals("a")&&fd.equals("b")){
			hql.append(" TB_BRANCH.partid="+zd+" and");
		}else if(!zd.equals("a")&&!fd.equals("b")){
			hql.append(" TB_BRANCH.partid="+zd+" and ");
			hql2=new StringBuilder("SELECT TB_JL.*,TB_CUSTOMER.cid as csid,TB_CUSTOMER.bid,TB_CUSTOMER.cname,TB_CUSTOMER.csex,TB_CUSTOMER.cage,TB_CUSTOMER.phone,TB_CUSTOMER.count,TB_CUSTOMER.lasttime FROM TB_JL, TB_CUSTOMER, TB_BRANCH WHERE TB_JL.cid = TB_CUSTOMER.cid AND TB_BRANCH.bid = TB_CUSTOMER.bid and TB_BRANCH.bid="+zd+" and ");
		}
		if(start.equals("")&&!end.equals("")){
			hql.append(" TB_JL.time >='2010-10-10' and TB_JL.time<"+"'"+end+"' and");
			if(hql2!=null){
				hql2.append("TB_JL.time >='2010-10-10' and TB_JL.time<"+"'"+end+"' and");
			}
		}else if(!start.equals("")&&end.equals("")){
			String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			hql.append(" TB_JL.time >="+start+" and TB_JL.time<"+"'"+format+"' and ");
			if(hql2!=null){
				hql2.append(" TB_JL.time >="+start+" and TB_JL.time<"+"'"+format+"' and ");
			}
		}else if(!start.equals("")&&!end.equals("")){
			hql.append(" TB_JL.time >="+start+" and TB_JL.time<"+"'"+end+"' and ");
			if(hql2!=null){
				hql2.append(" TB_JL.time >="+start+" and TB_JL.time<"+"'"+end+"' and ");
			}
		}
		hql.append(" 1=1 order by TB_JL.id desc");
		List<JL> JLs = session.createSQLQuery(hql.toString()).list();
		System.out.println(hql);
		if(hql2!=null){
			hql2.append(" 1=1 order by TB_JL.id desc");
			List<JL> JLs2 = session.createSQLQuery(hql2.toString()).list();
			JLs.addAll(JLs2);
			System.out.println(hql2);
		}
		System.out.println(JLs);
		return JLs;
	}

}
