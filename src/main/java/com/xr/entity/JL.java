package com.xr.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class JL implements Serializable{
	
	@Override
	public String toString() {
		return "JL [id=" + id + ", cid=" + cid + ", cids=" + cids + ", dgc=" + dgc + ", ssy=" + ssy + ", szy=" + szy
				+ ", xtang=" + xtang + ", gysc=" + gysc + ", xhdb=" + xhdb + ", xnc=" + xnc + ", xton=" + xton
				+ ", commont=" + commont + ", time=" + time + "]";
	}
	private Integer id;
	private Integer cid;
	private Customer cids;
	private String dgc;
	private String ssy;
	private String szy;
	private String xtang;
	private String gysc;
	private String xhdb;
	private String xnc;
	private String xton;
	private String commont;
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Customer getCids() {
		return cids;
	}
	public void setCids(Customer cids) {
		this.cids = cids;
	}
	public String getDgc() {
		return dgc;
	}
	public void setDgc(String dgc) {
		this.dgc = dgc;
	}
	public String getSsy() {
		return ssy;
	}
	public void setSsy(String ssy) {
		this.ssy = ssy;
	}
	public String getSzy() {
		return szy;
	}
	public void setSzy(String szy) {
		this.szy = szy;
	}
	public String getXtang() {
		return xtang;
	}
	public void setXtang(String xtang) {
		this.xtang = xtang;
	}
	public String getGysc() {
		return gysc;
	}
	public void setGysc(String gysc) {
		this.gysc = gysc;
	}
	public String getXhdb() {
		return xhdb;
	}
	public void setXhdb(String xhdb) {
		this.xhdb = xhdb;
	}
	public String getXnc() {
		return xnc;
	}
	public void setXnc(String xnc) {
		this.xnc = xnc;
	}
	public String getXton() {
		return xton;
	}
	public void setXton(String xton) {
		this.xton = xton;
	}
	public String getCommont() {
		return commont;
	}
	public void setCommont(String commont) {
		this.commont = commont;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
