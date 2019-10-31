package com.xr.entity;

import java.util.*;

/** @pdOid 26026a94-fc3c-492c-ba14-2228e22f82b3 */
public class UserRole {
	/**
	 * 主键自动增长
	 * 
	 * @pdOid 435b325f-d5ba-4312-ab01-b7095393fa9d
	 */
	private int id;
	/**
	 * 角色
	 * 
	 * @pdOid 4e828bc2-2e61-4b52-9d3d-00c567d15b93
	 */
	private Role newRole;
	/**
	 * 店员
	 * 
	 * @pdOid 0c34f5c0-9c64-4929-80c4-8a099e8f97fe
	 */
	private Branch newBranch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getNewRole() {
		return newRole;
	}

	public void setNewRole(Role newRole) {
		this.newRole = newRole;
	}

	public Branch getNewBranch() {
		return newBranch;
	}

	public void setNewBranch(Branch newBranch) {
		this.newBranch = newBranch;
	}

}