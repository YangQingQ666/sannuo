package com.xr.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xr.dao.TesterDao;
import com.xr.entity.Customer;
import com.xr.entity.Project;
import com.xr.util.HibernateUtil;

@Repository
public class TesterDaoImpl implements TesterDao{

	@Override
	public List<Map<String, Object>> query() {
		Session session = HibernateUtil.getSession();
		  Query query = session.createSQLQuery("select j.dgc,j.ssy,j.szy,j.xtang,j.gysz,j.xhdb,j.xns,j.xton,j.time,j.commont,j.method,b.bname from  TB_JL j,TB_BRANCH  b,TB_CUSTOMER  c where c.cid=2 and c.cid=j.cid and c.bid=b.bid ");
		  List list = query.list();
		  List<Map<String, Object>> maps=new ArrayList<>();
		  Iterator it = list.iterator();
		  while(it.hasNext()){
			  Object[] objs = (Object[])it.next();
				System.out.println(objs[0]+"  "+objs[1]+"  "+objs[2]+"  "+objs[3]+"   "+objs[4]+"   "+objs[5]+"   "+objs[6]+"   "+objs[7]+"   "+objs[8]+"   "+objs[9]+"   "+objs[10]+"   "+objs[11]);
				
				Map<String, Object> map = new HashMap<>();
				map.put("dgc", objs[0]);
				map.put("ssy", objs[1]);
				map.put("szy", objs[2]);
				map.put("xtang", objs[3]);
				map.put("gysz", objs[4]);
				map.put("xhdb", objs[5]);
				map.put("xns", objs[6]);
				map.put("xton", objs[7]);
				map.put("time", objs[8]);
				map.put("commont", objs[9]);
				map.put("method", objs[10]);
				map.put("bname", objs[11]);
				maps.add(map);
		  }
		return maps;
	}
	
	
	@Override
	public List<Customer> select() {
		Session session = HibernateUtil.getSession();
		  Query query = session.createQuery("FROM Customer where cid=4");
		  List<Customer> list = query.list();
		  while (list!=null) {
			return list;
		}
		return null;
	}

}
