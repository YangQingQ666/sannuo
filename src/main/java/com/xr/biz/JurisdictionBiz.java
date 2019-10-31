package com.xr.biz;

import java.util.List;
import java.util.Map;

import com.xr.entity.Jurisdiction;

public interface JurisdictionBiz {
	/**
	 * 查询权限
	 * @param bname
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
	 /**
	  * 判断是否有过*权限
	  * @param name
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 boolean findByJurisdictionNameId(String name,int id);
	 /**
	  * 新增菜单
	  */
	 int saveMenumanage(Jurisdiction j)throws Exception;
	 /**
	  * 根据id查询权限
	  */
	 public Jurisdiction findById(int id) throws Exception;
	 /**
	  * 修改权限
	  * @param j
	  * @return
	  * @throws Exception
	  */
	 public int upJurisdictionById(Jurisdiction j) throws Exception;
	 /**
	  * 修改权限状态
	  * @param id
	  * @param state
	  * @return
	  * @throws Exception
	  */
	 public int upJurisdistionByState(int id, int state) throws Exception;
}
