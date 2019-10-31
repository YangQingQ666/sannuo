package com.xr.biz;

import java.util.List;

import com.xr.entity.Boss;
import com.xr.entity.Project;

public interface ProjectBiz {
	String findProjectByUnscrambleRemoveDuplicates(Boss boss);
	/**
	 * 查询所有检查项目
	 * @return
	 * @throws Exception
	 */
	List<Project> findProjectByProject() throws Exception;
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
