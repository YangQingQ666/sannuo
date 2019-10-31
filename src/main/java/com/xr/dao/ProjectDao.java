package com.xr.dao;

import java.sql.SQLException;
import java.util.List;

import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.entity.Project;

public interface ProjectDao {
	List<Project> findProjectByUnscrambleRemoveDuplicates() throws SQLException;
	List<Project> findProjectByBranchId(Boss boss) throws SQLException;
	List<Project> findBigBrachAllProject(List<Branch> branchs) throws SQLException;
	/**
	 * 查询所有检查项目
	 * @return
	 * @throws Exception
	 */
	List<Project> findProjectByProject() throws Exception;
	/**
	 * 根据项目名查询
	 * @param dname
	 * @return
	 * @throws Exception
	 */
	List<Project> findProjectBydname(String dname) throws Exception;
	/**
	 * 根据id查询项目
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Project findProjectById(int id)throws Exception;
	/**
	 * 修改项目信息
	 */
	int upByid(Project project) throws Exception;
}
