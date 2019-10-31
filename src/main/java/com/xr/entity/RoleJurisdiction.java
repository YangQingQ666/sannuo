package com.xr.entity;

import java.util.*;

/**
 * 角色权限表(tb_role_jurisdiction)
 * 
 * @pdOid f23c089f-d3a1-40a1-b19c-0dcd5cad6df5
 */
public class RoleJurisdiction {
	/**
	 * 主键自动增长
	 * 
	 * @pdOid 381401e6-8cc2-4fa2-bc86-774a50781eff
	 */
	private int id;
	/**
	 * 权限
	 * 
	 * @pdOid f481419e-7678-4f13-a04f-d52d60b53a97
	 */
	private Jurisdiction newJurisdiction;
	/**
	 * 角色
	 * 
	 * @pdOid e9738b20-9ea7-4192-98ac-4ff532c0ef18
	 */
	private Role newRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jurisdiction getNewJurisdiction() {
		return newJurisdiction;
	}

	public void setNewJurisdiction(Jurisdiction newJurisdiction) {
		this.newJurisdiction = newJurisdiction;
	}

	public Role getNewRole() {
		return newRole;
	}

	public void setNewRole(Role newRole) {
		this.newRole = newRole;
	}

}