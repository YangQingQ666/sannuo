package com.xr.entity;

import java.util.*;

/**
 * 权限表(tb_jurisdiction)
 * 
 * @pdOid db0a9835-ae45-499a-a1df-03702890d48d
 */
public class Jurisdiction {
	/**
	 * 权限ID
	 * 
	 * @pdOid d4bb4a46-ddf9-45cd-9e97-e50375212c88
	 */
	private int jid;
	/**
	 * 权限名字
	 * 
	 * @pdOid 0611d3c2-f6d9-43e4-a2ad-e3f21fbcabd6
	 */
	private String jname;
	/**
	 * 所属权限（最高权限为0）
	 * 
	 * @pdOid 86b006a9-c9c4-4260-afd9-53fa4829f1ab
	 */
	private Jurisdiction newJurisdiction;
	/**
	 * 权限地址
	 * 
	 * @pdOid 635fb1ee-51c8-4dc6-bc2c-ee0edc9a36e0
	 */
	private String url;
	/**
	 * 图标
	 * 
	 * @pdOid 7e9f6931-3541-4057-9d19-eaa908c743ec
	 */
	private String icon;
	private  int partid;
	
	public int getPartid() {
		return partid;
	}

	public void setPartid(int partid) {
		this.partid = partid;
	}

	private int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public Jurisdiction getNewJurisdiction() {
		return newJurisdiction;
	}

	public void setNewJurisdiction(Jurisdiction newJurisdiction) {
		this.newJurisdiction = newJurisdiction;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}