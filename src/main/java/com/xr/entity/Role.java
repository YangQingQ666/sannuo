package com.xr.entity;

import java.util.*;

/**
 * 角色表(tb_role)
 * 
 * @pdOid 85e9d2b9-1d7b-42a9-aaa7-37e2638398c6
 */
public class Role {
	/**
	 * 角色id
	 * 
	 * @pdOid beec17e5-6b03-4e2b-9898-0bc971060042
	 */
	private int roleid;
	/**
	 * 角色名
	 * 
	 * @pdOid 568ea4fc-3daf-47cc-8c92-d8c8036aac3e
	 */
	private String rolename;
	private String comment;
	private String state;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}