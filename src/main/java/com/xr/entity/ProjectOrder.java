package com.xr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import org.springframework.stereotype.Component;

/**
 * 检测项目表(TB_PROJECT_ORDER)
 * 
 * 
 * @pdOid ec781bdf-3cb3-4b2c-8b60-07e7ae10bbcd
 */
@Component
public class ProjectOrder implements Serializable{
	/**
	 * 检测记录id
	 * 
	 * @pdOid c36df8d8-8767-46d1-800f-62034f53c15f
	 */
	private long oid;
	/** 检测者
	 * @pdOid 9314886a-244e-4e6d-803a-4e7ff072c4ab 
	 * */
	private List<Customer> newCustomer;
	/**
	 * 检测项目
	 * 
	 * @pdOid d39e7d43-6f82-4c66-9821-dae61ed12173
	 */
	private List<Project> newProject;
	/**
	 * 检测结果
	 * 
	 * @pdOid a9244ca7-c0b4-4c53-8197-7f9c8bc32a97
	 */
	private String result;
	private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}


	public List<Customer> getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(List<Customer> newCustomer) {
		this.newCustomer = newCustomer;
	}

	public List<Project> getNewProject() {
		return newProject;
	}

	public void setNewProject(List<Project> newProject) {
		this.newProject = newProject;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}