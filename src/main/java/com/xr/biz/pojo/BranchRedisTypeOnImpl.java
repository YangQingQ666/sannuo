package com.xr.biz.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.biz.BranchRedisType;
import com.xr.util.RedisPoolUtils;

/**
 * 总店下拉框查询缓存实现类（状态模式）
 * @author Administrator
 *
 */
@Service
public class BranchRedisTypeOnImpl implements BranchRedisType{
	/*@Autowired
	private RedisPoolUtils redisUtil;*/
	@Override
	public String findBranchZdXlk() {
		System.out.println("查询缓存");
		try{
			return new RedisPoolUtils().getString("zdxlk");
		}catch (Exception e) {
			return null;
		}
	}

}
