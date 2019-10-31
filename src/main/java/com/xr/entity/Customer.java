package com.xr.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 检测者（顾客）表 branchid(分店ID)列的主键表是branchid(分店表)
 * 
 * @pdOid 9b773283-414d-4079-b54c-39214f87b2cb
 */
@Component
public class Customer implements Serializable{
	/**
	 * 检测者id
	 * 
	 * @pdOid 90bbacf9-97bd-4ffd-bb72-a1f06962c160
	 */
	private Integer cid;
	private JL jl;
	public JL getJl() {
		return jl;
	}
	public void setJl(JL jl) {
		this.jl = jl;
	}
	/** 所属店铺
	 * @pdOid 403d3510-ce19-4577-8c3c-46b2c60e3d69 
	 * */
	private Branch branch;
	private Branch bids;
	public Branch getBids() {
		return bids;
	}
	public void setBids(Branch bids) {
		this.bids = bids;
	}
	/**
	 * 姓名
	 * 
	 * @pdOid c1dd5bd3-2098-4a65-86c2-814531470d2f
	 */
	private String cname;
	/**
	 * 性别
	 * 
	 * @pdOid 7d9927a0-ddb0-4118-9306-e02af0d13e38
	 */
	private String csex;
	/**
	 * 年龄
	 * 
	 * @pdOid 29c8096c-c55e-4790-ac36-2d473eaa9c44
	 */
	private int cage;
	/**
	 * 联系方式
	 * 
	 * @pdOid 38409f91-1393-473e-8be0-fff9f1693c87
	 */
	private String phone;
	/**
	 * 身份证号码
	 * 
	 * @pdOid a32e072f-1d21-4537-8291-94d682ae6c6f
	 */
	private String identificationcad;
	/**
	 * 检查次数
	 * 
	 * @pdOid df68209f-8bbc-4d63-9878-1bb6130ff18f
	 */
	private int count;
	/**
	 * 最后检测时间
	 * 
	 * @pdOid 1f6762b9-9c92-4230-aefe-bdfbcaf34bc8
	 */
	private Date lasttime;
	public long getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentificationcad() {
		return identificationcad;
	}
	public void setIdentificationcad(String identificationcad) {
		this.identificationcad = identificationcad;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", branch=" + branch + ", cname=" + cname + ", csex=" + csex + ", cage=" + cage
				+ ", phone=" + phone + ", identificationcad=" + identificationcad + ", count=" + count + ", lasttime="
				+ lasttime + "]";
	}

}