package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.Jurisdiction;

public interface JurisdictionDao {
	/**
	 * 查询权限
	 * @param bname
	 * @return	Map<String, Object>
	 * @throws Exception
	 */
	Map<String, List<Map<String, Object>>> findByJurisdiction(String bname) throws Exception;
	/**
	 * 查找所有的权限
	 * @return
	 * @throws Exception
	 */
	List<Jurisdiction> findByJurisdiction() throws Exception;
	/**
	 * 主菜单
	 */
	 List<Jurisdiction> findByO() ;
	 List<Jurisdiction> findByNO();
	 boolean findByJurisdictionNameId(String name,int id) throws Exception;
	 /**
	  * 新增菜单
	  */
	 int saveMenumanage(Jurisdiction j)throws Exception;
	 /**
	  * 根据id查找权限
	  */
	 Jurisdiction findById(int id) throws Exception;
	 /**
	  * 修改权限
	  * @param j
	  * @return
	  * @throws Exception
	  */
	 int upJurisdictionById(Jurisdiction j) throws Exception;
	 /**
	  * 修改状态
	  * @param id
	  * @param state
	  * @return
	  * @throws Exception
	  */
	 int upJurisdistionByState(int id,int state) throws Exception;
}
