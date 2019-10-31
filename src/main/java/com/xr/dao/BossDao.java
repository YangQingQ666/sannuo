package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.Boss;
import com.xr.entity.Branch;

public interface BossDao {
	//登录
	Boss findByBoss(Boss boss) throws Exception;
	// 登陆后查询
	// 查询所登录账号的店铺信息
	List<Branch> queryBossBranch(Boss boss) throws Exception;
	//按条件查询
	List<Branch> queryByThree(Object[]... object) throws Exception;
	//修改密码
	int updatePwd(Boss b) throws Exception;
	//删除系统账号（修改状态为1）
	int del(Boss b) throws Exception;
	//增加系统账号
	int addsys(Boss b)throws Exception;
	//修改个人信息
	int updateInfo(Boss b) throws Exception;
	//查询个人信息
	List<Map<String,Object>> queryinfo(Boss b) throws Exception;
}
