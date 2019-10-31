package com.xr.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.biz.RoleJurisdictionBiz;
import com.xr.dao.RoleJurisdictionDao;
import com.xr.entity.Allxx;
import com.xr.entity.Jurisdiction;
import com.xr.entity.Role;
@Service
public class RoleJurisdictionBizImp implements RoleJurisdictionBiz{
	@Autowired
	private RoleJurisdictionDao roleJurisdictionDao;
	@Override
	public List<Allxx> findByRoleJurisdiction(List<Role> list) throws Exception {
		return roleJurisdictionDao.findByRoleJurisdiction(list);
	}
	@Override
	public List<Jurisdiction> findByRoleJurisdiction(Role role) throws Exception {
		return roleJurisdictionDao.findByRoleJurisdiction(role);
	}

}
