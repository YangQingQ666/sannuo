package com.xr.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xr.dao.ProjectDao;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.entity.Project;
import com.xr.util.HibernateUtil;
@Repository
public class ProjectDaoImpl implements ProjectDao{
	@Override
	public List<Project> findProjectByUnscrambleRemoveDuplicates() throws SQLException{
		Session session=null;
		List<Project> projectPublic=null;
		try {
			session = HibernateUtil.getSession();
			projectPublic = session.createQuery("SELECT did,dname FROM Project WHERE unscramble='正常' GROUP BY dname,did").list();
		} catch (Exception e) {
			throw new SQLException("Project_sql异常1");
		}
		return projectPublic;
	}


	public List<Project> findProjectByBranchId(Boss boss) throws SQLException {
		Session session=null;
		List<Project> projectPrivate=null;
		try {
			session=HibernateUtil.getSession();
			projectPrivate = session.createQuery("SELECT did,dname FROM Project WHERE unscramble='正常' AND newBranch="+boss.getNewBranch().getBid()+" GROUP BY dname,did").list();
		} catch (Exception e) {
			throw new SQLException("Project_sql异常2");
		}
		return projectPrivate;
	}


	@Override
	public List<Project> findBigBrachAllProject(List<Branch> branchs) throws SQLException {
		Session session=null;
		List<Project> projects=new LinkedList<Project>();
		try {
			Iterator<Branch> it=branchs.iterator();
			session = HibernateUtil.getSession();
			while(it.hasNext()){
				projects.addAll(session.createQuery("SELECT did,dname FROM Project WHERE unscramble='正常' AND newBranch="+it.next().getBid()+" GROUP BY dname,did").list());
			}
		} catch (Exception e) {
//			/throw new SQLException("Project_sql异常3");
		}
		return projects;
	}

	/**
	 * 查询所有检查项目
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Project> findProjectByProject() throws Exception {
		Session session = HibernateUtil.getSession();
		List<Project> list= session.createQuery("from Project order by dname").list();
		return list;
	}


	@Override
	public List<Project> findProjectBydname(String dname) throws Exception {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Project where dname LIKE ?0 order by dname");
		query.setParameter(0, '%'+dname+'%');
		List<Project> list = query.list();
		return list;
	}


	@Override
	public Project findProjectById(int id) throws Exception {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Project where did=?0");
		query.setParameter(0, id);
		Project p=(Project) query.uniqueResult();
		return p;
	}

	/**
	 * 修改项目信息
	 */
	@Override
	public int upByid(Project project) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql="update Project set method=?0,intervarl=?1,unscramble=?2 where did=?3";
		 Query query = session.createQuery(hql);
		 query.setParameter(0, project.getMethod());
		 query.setParameter(1, project.getIntervarl());
		 query.setParameter(2, project.getUnscramble());
		 query.setParameter(3, project.getDid());
		 int i = query.executeUpdate();
		 transaction.commit();
		 return i;
	}
	
}
