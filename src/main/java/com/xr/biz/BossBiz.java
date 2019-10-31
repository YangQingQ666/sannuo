package com.xr.biz;

import java.util.List;
import java.util.Map;

import com.xr.entity.Boss;
import com.xr.entity.Branch;

public interface BossBiz {
	// 登录
	Boss findByBoss(Boss boss) throws Exception;

	// 查询所登录账号的店铺信息
	List<Branch> queryBossBranch(Boss boss) throws Exception;

	// 修改密码
	int updatePwd(Boss b) throws Exception;

	// 删除系统账号
	int del(Boss b) throws Exception;

	// 增加系统账号
	int addsys(Boss b) throws Exception;

	// 查询个人信息
	List<Map<String, Object>> queryinfo(Boss b) throws Exception;

	// 修改个人信息
	int updateInfo(Boss b) throws Exception;
}
