package com.xr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xr.dao.RoleJurisdictionDao;
import com.xr.entity.Allxx;
import com.xr.entity.Jurisdiction;
import com.xr.entity.Role;
import com.xr.util.HibernateUtil;
@Repository
public class RoleJurisdictionDaoImp implements RoleJurisdictionDao{
	/**
	 * 查询所有角色权限
	 */
	@Override
	public List<Allxx> findByRoleJurisdiction(List<Role> list) throws Exception{
		Session session = HibernateUtil.getSession();
		List<Allxx>  li=new ArrayList<Allxx>();
		for (int i = 0; i < list.size(); i++) { 
			Query query = session.createSQLQuery("select j.jname from TB_ROLE_JURISDICTION rj,TB_JURISDICTION j where rj.jid=j.jid and rj.rid=?0");
			 query.setParameter(0, list.get(i).getRoleid());
			 List list1 = query.list();
			 String jname="";
			 for (int j = 0; j < list1.size(); j++) {
				 if(j==(list1.size()-1)){
					 jname+=list1.get(j);
				 }else{
				 jname+=list1.get(j)+",";
				 }
			}
			 Allxx a=new Allxx();
			 a.setComment(list.get(i).getComment());
			 a.setJname(list.get(i).getRolename());
			 a.setName(jname);
			 a.setRid(list.get(i).getRoleid());
			 a.setState(Integer.parseInt(list.get(i).getState()));
			 li.add(a);
		}
		return li;
	}

	@Override
	public List<Jurisdiction> findByRoleJurisdiction(Role role) throws Exception {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery("SELECT j.* from TB_JURISDICTION j,TB_ROLE_JURISDICTION rj where j.jid=rj.jid and rj.rid=?0");
		List<Jurisdiction> list = query.setParameter(0, role.getRoleid()).list();
		return list;
	}

	

}
