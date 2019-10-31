package com.xr.biz.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.xr.biz.ProjectBiz;
import com.xr.dao.BranchDao;
import com.xr.dao.ProjectDao;
import com.xr.entity.Boss;
import com.xr.entity.Project;
import com.xr.util.RedisPoolUtils;
@Service
public class ProjectBizImpl implements ProjectBiz {
	@Autowired
	private RedisPoolUtils redisUtils;
	@Autowired
	private ProjectDao projectDaoImpl;
	@Autowired
	private BranchDao BranchDaoImpl;
	
	@Override
	@Transactional
	public String findProjectByUnscrambleRemoveDuplicates(Boss boss) {
		List<Project> findProjectByUnscrambleRemoveDuplicates=null;
		try {
			findProjectByUnscrambleRemoveDuplicates = projectDaoImpl.findProjectByUnscrambleRemoveDuplicates();
			List<Project> projects=boss.getNewBranch()==null?projectDaoImpl.findBigBrachAllProject(BranchDaoImpl.findAllBigBranch()):projectDaoImpl.findProjectByBranchId(boss);
			findProjectByUnscrambleRemoveDuplicates.addAll(projects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String findProjectByUnscrambleRemoveDuplicatesJson = JSON.toJSONString(findProjectByUnscrambleRemoveDuplicates);
		redisUtils.setString("anomalyIndex", findProjectByUnscrambleRemoveDuplicatesJson);
		return findProjectByUnscrambleRemoveDuplicatesJson;
	}
	/**
	 * 查询所有检查项目
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Project> findProjectByProject() throws Exception {
		return projectDaoImpl.findProjectByProject();
	}
	@Override
	public List<Project> findProjectBydname(String dname) throws Exception {
		return projectDaoImpl.findProjectBydname(dname);
	}
	@Override
	public Project findProjectById(int id) throws Exception {
		return projectDaoImpl.findProjectById(id);
	}
	@Override
	public int upByid(Project project) throws Exception {
		return projectDaoImpl.upByid(project);
	}
}
