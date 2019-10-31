package com.xr.biz;

import java.util.List;

import com.xr.entity.Role;

public interface RoleBiz {
	/**
	 * 所有角色
	 */
	 List<Role> findByRole() throws Exception;
}
