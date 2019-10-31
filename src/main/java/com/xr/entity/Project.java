package com.xr.entity;

import java.io.Serializable;
import java.util.*;

import org.springframework.stereotype.Component;

/** @pdOid 56459783-4966-4d48-ac0b-81e670c206e4 */
@Component
public class Project implements Serializable{

	/**
	 * 检测项目ID
	 * 
	 * @pdOid d17638c2-2243-463a-ac86-539538b747ad
	 */
	public Integer did;
	/**
	 * 项目名
	 * 
	 * @pdOid aeac247c-5c2f-4078-93de-f280a77d096f
	 */
	private String dname;
	/**
	 * 单位
	 * 
	 * @pdOid 18ca3317-df5b-486c-80d0-fc19421a0aa5
	 */
	private String unit;
	/**
	 * 参考值
	 * 
	 * @pdOid 9cb7e92a-3b54-4a91-a9aa-e333dda44705
	 */
	private String reference;
	/**
	 * 检测方法
	 * 
	 * @pdOid 13bf1b83-3ae8-4098-934d-82151423ed1c
	 */
	private String method;
	/**
	 * 区间
	 * 
	 * @pdOid 1033958d-7e7f-4522-a7fd-e6a66a73d5f2
	 */
	private String intervarl;
	/**
	 * 情况
	 */
	private String unscramble;
	
	/**
	 * 所属店面
	 * 
	 * @pdOid a6f933dc-4e77-41be-87e9-1d5d4776b858
	 */
	private Branch newBranch;
	/**
	 * 结果解读
	 */
	private String commont;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIntervarl() {
		return intervarl;
	}
	public void setIntervarl(String intervarl) {
		this.intervarl = intervarl;
	}
	public String getUnscramble() {
		return unscramble;
	}
	public void setUnscramble(String unscramble) {
		this.unscramble = unscramble;
	}
	public Branch getNewBranch() {
		return newBranch;
	}
	public void setNewBranch(Branch newBranch) {
		this.newBranch = newBranch;
	}
	public String getCommont() {
		return commont;
	}
	public void setCommont(String commont) {
		this.commont = commont;
	}
	

}