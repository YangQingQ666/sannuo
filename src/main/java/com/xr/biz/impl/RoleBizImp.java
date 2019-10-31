package com.xr.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.biz.RoleBiz;
import com.xr.dao.RoleDao;
import com.xr.entity.Role;
@Service
public class RoleBizImp implements RoleBiz{
	@Autowired
	private RoleDao roleDaoImp;
	@Override
	public List<Role> findByRole() throws Exception {
		return roleDaoImp.findByRole();
	}

}
