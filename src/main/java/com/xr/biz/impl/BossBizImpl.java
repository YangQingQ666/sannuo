package com.xr.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xr.biz.BossBiz;
import com.xr.dao.BossDao;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
@Service
public class BossBizImpl implements BossBiz {
	@Autowired
	private BossDao bossDao;
	/**
	 * 根据账号查询
	 */
	@Override
	public Boss findByBoss(Boss boss) throws Exception {
		return bossDao.findByBoss(boss);
	}
	/**
	 * 查询所登录账号的店铺信息
	 */
	@Override
	public List<Branch> queryBossBranch(Boss boss) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.queryBossBranch(boss);
	}
	//修改密码
	@Override
	public int updatePwd(Boss b) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.updatePwd(b);
	}
	//删除系统账号
	@Override
	public int del(Boss b) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.del(b);
	}
	//增加账号
	@Override
	public int addsys(Boss b) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.addsys(b);
	}
	//查询个人信息
	@Override
	public List<Map<String, Object>> queryinfo(Boss b) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.queryinfo(b);
	}
	//修改个人信息
	@Override
	public int updateInfo(Boss b) throws Exception {
		// TODO Auto-generated method stub
		return bossDao.updateInfo(b);
	}
}
