package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.Role;
import com.xr.entity.Allxx;
import com.xr.entity.Jurisdiction;
public interface RoleJurisdictionDao {
	/**
	 * 查询所有角色权限
	 */
	List<Allxx> findByRoleJurisdiction(List<Role> list) throws Exception;
	/**
	 * 根据角色查权限
	 * @param role
	 * @return
	 * @throws Exception
	 */
	List<Jurisdiction> findByRoleJurisdiction(Role role) throws Exception;
}
