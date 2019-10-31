package com.xr.dao;

import java.util.List;

import com.xr.entity.Role;

public interface RoleDao {
	/**
	 * 角色权限
	 */
	 List<Role> findByRole() throws Exception;
}
