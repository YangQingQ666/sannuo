package com.xr.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.biz.JurisdictionBiz;
import com.xr.dao.JurisdictionDao;
import com.xr.entity.Jurisdiction;
@Service
public class JurisdictionBizImp implements JurisdictionBiz{
	@Autowired
	private JurisdictionDao jurisdictionDao; 
	/**
	 * 查询权限
	 */
	@Override
	public Map<String, List<Map<String, Object>>> findByJurisdiction(String bname) throws Exception {
		return jurisdictionDao.findByJurisdiction(bname);
	}
	/**
	 * 查询所有权限
	 */
	@Override
	public List<Jurisdiction> findByJurisdiction() throws Exception {
		return jurisdictionDao.findByJurisdiction();
	}
	@Override
	public List<Jurisdiction> findByO() {
		return jurisdictionDao.findByO();
	}
	@Override
	public List<Jurisdiction> findByNO() {
		return jurisdictionDao.findByNO();
	}
	@Override
	public boolean findByJurisdictionNameId(String name, int id)  {
		 boolean b=false;
		try {
			b = jurisdictionDao.findByJurisdictionNameId(name, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 新增权限
	 */
	@Override
	public int saveMenumanage(Jurisdiction j) throws Exception {
		return jurisdictionDao.saveMenumanage(j);
	}
	/**
	 * 根据id找权限
	 */
	@Override
	public Jurisdiction findById(int id) throws Exception {
		return jurisdictionDao.findById(id);
	}
	/**
	 * 修改权限
	 */
	@Override
	public int upJurisdictionById(Jurisdiction j) throws Exception {
		return jurisdictionDao.upJurisdictionById(j);
	}
	/**
	 * 修改权限状态
	 */
	@Override
	public int upJurisdistionByState(int id, int state) throws Exception {
		return jurisdictionDao.upJurisdistionByState(id, state);
	}
	
}
