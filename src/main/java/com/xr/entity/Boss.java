package com.xr.entity;

import java.io.Serializable;
import java.util.*;

import org.springframework.stereotype.Component;

/**
 * 平台管理者表(TB_BOSS) 一个管理者一个店
 * 
 * @pdOid 5a1a1532-e05b-4d66-a5bb-564114c34593
 */
@Component
public class Boss implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 店员ID
	 * 
	 * @pdOid 6821834d-6a3f-4c88-98e7-642693815183
	 */
	private int mid;
	/**
	 * 店铺
	 * 
	 * @pdOid 86cbfb53-7646-4dd0-9cf3-2d71c66474b6
	 */
	private Branch newBranch;
	/**
	 * 账号
	 * 
	 * @pdOid 00810fc5-126c-467b-99ed-fe9a9f6c99be
	 */
	private String account;
	/**
	 * 密码
	 * 
	 * @pdOid 46aabfac-7457-4914-b8b5-ebc2d1ac1217
	 */
	private String password;
	/**
	 * 名字
	 * 
	 * @pdOid 5318d4b4-f2ab-482e-be33-5c78b38cca47
	 */
	private String mname;
	/**
	 * 0:启动 1:关闭
	 * 
	 * @pdOid ff792e7d-67bc-4a05-94fe-6669012d773b
	 */
	private Integer type;
	/** @pdOid ad3725c2-8d4b-4772-9e62-f222395addaa */
	private String comment;



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	public Branch getNewBranch() {
		return newBranch;
	}



	public void setNewBranch(Branch newBranch) {
		this.newBranch = newBranch;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public Integer getType() {
		return type;
	}



	public void setType(Integer type) {
		this.type = type;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	@Override
	public String toString() {
		return "Boss [mid=" + mid + ", newBranch=" + newBranch + ", account=" + account + ", password=" + password
				+ ", mname=" + mname + ", type=" + type + ", comment=" + comment + "]";
	}

	

}