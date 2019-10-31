package com.xr.entity;

import java.io.Serializable;
import java.util.*;

import org.springframework.stereotype.Component;

/**
 * BRANCH(店铺表)
 * 
 * @pdOid 699d6837-21b7-451a-a118-00a6e967636e
 */
@Component
public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bname=" + bname + ", partid=" + partid + ", province=" + province + ", city="
				+ city + ", county=" + county + ", address=" + address + ", gname=" + gname + ", phone=" + phone
				+ ", type=" + type + "]";
	}

	/**
	 * 主键
	 * 
	 * @pdOid daf50979-b3fa-41af-8cca-00c6a3fe53ac
	 */
	private int bid;
	/**
	 * 店名
	 * 
	 * @pdOid a5d7b6ac-5363-4d29-bb86-2a7f6c1f11f1
	 */
	private String bname;
	private Customer cids;
	public Customer getCids() {
		return cids;
	}

	public void setCids(Customer cids) {
		this.cids = cids;
	}

	/**
	 * 总店0
	 * 
	 * @pdOid f40a897b-4afa-471a-874d-fbf4844ec4d3
	 */
	private Integer partid;

	public Integer getPartid() {
		return partid;
	}

	public void setPartid(Integer partid) {
		this.partid = partid;
	}

	/**
	 * 所在省
	 * 
	 * @pdOid 2572d4f5-9fe3-4ea7-837e-f3e36fd3813e
	 */
	private String province;
	

	/**
	 * 所在市
	 * 
	 * @pdOid 4e48a11d-b7e9-476b-a866-cce97b38cce7
	 */
	private String city;
	/**
	 * 所在区/县
	 * 
	 * @pdOid b88d5081-977f-4989-9c90-317e8e07df86
	 */
	private String county;
	/**
	 * 详细地址
	 * 
	 * @pdOid 49af232f-d4b2-452c-a5ca-7bb5b9dbd768
	 */
	private String address;
	/**
	 * 公司名
	 * 
	 * @pdOid 68a23149-640d-4d53-aa12-05f819a2f026
	 */
	private String gname;
	/**
	 * 联系电话
	 * 
	 * @pdOid b307812c-fcc0-465a-b649-122eb0350879
	 */
	private String phone;
	/**
	 * 0:关闭 1：启用
	 * 
	 * @pdOid 98a735bd-f6ec-427f-ba18-cf7e58585b2d
	 */
	private int type;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}





	/** @pdOid 73f8c315-a447-4115-8c13-b3126353fad9 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param newBname
	 * @pdOid 05b15d5f-0440-4514-aa5a-7bd5d42868e7
	 */
	public void setBname(String newBname) {
		bname = newBname;
	}

	/** @pdOid 89f43336-9849-4f1b-90bc-dc5659755d8e */
	public String getProvince() {
		return province;
	}

	/**
	 * @param newProvince
	 * @pdOid a9c50101-87e5-41dc-9e9e-52d136a838bd
	 */
	public void setProvince(String newProvince) {
		province = newProvince;
	}

	/** @pdOid c97c27e4-31c1-404b-93c8-bc0f32e5c1ca */
	public String getCity() {
		return city;
	}

	/**
	 * @param newCity
	 * @pdOid dda1edc9-8462-4eb4-b40a-bfb90ba66549
	 */
	public void setCity(String newCity) {
		city = newCity;
	}

	/** @pdOid a1a8c63f-a7fd-485e-ab18-cd97ea2d7730 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param newCounty
	 * @pdOid 11d9df5e-10bf-43a9-b0d3-399712952122
	 */
	public void setCounty(String newCounty) {
		county = newCounty;
	}

	/** @pdOid 8f4d8575-2187-49e0-afa9-7b230f53c080 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param newAddress
	 * @pdOid f23313ab-23c7-484d-b5fd-378b5eaad43f
	 */
	public void setAddress(String newAddress) {
		address = newAddress;
	}

	/** @pdOid 3e6c0a66-491e-49ed-b9cb-b27a07dacee0 */
	public String getGname() {
		return gname;
	}

	/**
	 * @param newGname
	 * @pdOid 8706489c-ae7d-4fbd-bf58-ac37f6975167
	 */
	public void setGname(String newGname) {
		gname = newGname;
	}

	/** @pdOid ad62a386-0606-4c59-9c9a-ee94a0705ad8 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param newPhone
	 * @pdOid fc28fb34-8cad-4c0a-96f6-56750a3fac58
	 */
	public void setPhone(String newPhone) {
		phone = newPhone;
	}

	/** @pdOid def47512-66d3-47f7-b5c5-f47a06a41375 */
	public int getType() {
		return type;
	}

	/**
	 * @param newType
	 * @pdOid bf6a4c1d-8a6d-4c9c-8425-f1b85a33db47
	 */
	public void setType(int newType) {
		type = newType;
	}

}