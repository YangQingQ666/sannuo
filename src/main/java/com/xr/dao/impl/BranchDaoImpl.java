package com.xr.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xr.dao.BranchDao;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.HibernateUtil;
@Repository
public class BranchDaoImpl implements BranchDao{

	@Override
	public List<Branch> getBigBranchByBid(Boss boss) throws SQLException {
		Session session = HibernateUtil.getSession();
		List<Branch> zdBranch=null;
		try {
			/**null是超级管理员直接查询不，非null按是不是总店管理员查*/
			if(boss.getNewBranch()!=null){
				int bid = boss.getNewBranch().getBid();
				Integer partid = boss.getNewBranch().getPartid();
				zdBranch=boss.getNewBranch().getPartid()==0?session.createQuery("SELECT bid,bname,partid FROM Branch WHERE bid="+bid).list():session.createQuery("SELECT bid,bname,partid FROM Branch WHERE bid="+partid).list();
			}else{
				zdBranch=findAllSmallBranch();
			}
		} catch (Exception e) {
			throw new SQLException("Branch——sql错误");
		}
		System.out.println(zdBranch.size());
		return zdBranch;
	}

	/*@Override
	public List<Branch> getMysamllBranchBypartId(Boss boss) throws SQLException {
		Session session = HibernateUtil.getSession();
		List<Branch> fdBranch=null;
		try {
			*//**null是超级管理员直接查询不，非null按是不是总店管理员查*//*
			if(boss.getNewBranch()!=null){
				Long bid = boss.getNewBranch().getBid();
				Integer partid = boss.getNewBranch().getPartid();
				System.out.println(boss.getNewBranch());
				fdBranch = boss.getNewBranch().getPartid() == 0 ? session.createQuery("SELECT bid,bname,partid FROM Branch WHERE partid="+bid).list():session.createQuery("SELECT bid,bname,partid FROM Branch WHERE bid="+bid).list();
			}else{
				fdBranch=findAllBigBranch();
			}
		} catch (Exception e) {
			throw new SQLException("Branch——sql错误");
		}
		return fdBranch;
	}*/

	@Override
	public List<Branch> findAllBigBranch() throws SQLException {
		Session session = null;
		List<Branch> zdBranch=null;
		try {
			session=HibernateUtil.getSession();
			zdBranch = session.createQuery("SELECT bid,bname,partid FROM Branch").list();
			
		} catch (Exception e) {
			throw new SQLException("Branch_sql错误");
		}finally{
			//HibernateUtil.close();
		}
		return zdBranch;
	}

	@Override
	public List<Branch> findAllSmallBranch() throws SQLException {
		Session session = null;
		List<Branch> zdBranch=null;
		try {
			session=HibernateUtil.getSession();
			zdBranch = session.createQuery("SELECT bid,bname,partid FROM Branch WHERE partid=0").list();
			
		} catch (Exception e) {
			throw new SQLException("Branch_sql错误");
		}finally{
			//HibernateUtil.close();
		}
		return zdBranch;
	}



	@Override
	public List<Branch> getBigBranchByBid(String partid) throws SQLException {
		Session session = null;
		List<Branch> zdBranch=null;
			session=HibernateUtil.getSession();
			zdBranch = session.createQuery("SELECT bid,bname,partid FROM Branch WHERE partid="+Integer.valueOf(partid)).list();
			
		return zdBranch;
	}

	/**
	 * 增加总店
	 */
	@Override
	public int allBigBranch(Branch b) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Serializable save = session.save(b);
		if (save!=null) {
			return 1;
		}
		return 0;
	}

	

}
