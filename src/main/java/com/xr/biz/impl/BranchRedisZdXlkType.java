package com.xr.biz.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xr.biz.BranchRedisType;
import com.xr.biz.pojo.BranchRedisTypeOffImpl;
import com.xr.biz.pojo.BranchRedisTypeOnImpl;
/*
 * 总店下拉框当前状态类
 */
@Service
public class BranchRedisZdXlkType {
	//单例模式
	private static BranchRedisZdXlkType branchRedisZdXlkType=new BranchRedisZdXlkType();
	//查询数据库得状态实例
	@Qualifier("branchRedisTypeOffImpl")
	private BranchRedisType branchRedisTypeOffImpl=new BranchRedisTypeOffImpl();
	//查询缓存得状态实例
	@Qualifier("branchRedisTypeOnImpl")
	private BranchRedisType branchRedisTypeOnImpl=new BranchRedisTypeOnImpl();
	//默认实例化查询数据库
	protected BranchRedisType stam=branchRedisTypeOffImpl;
	//修改状态为查询数据库
	private BranchRedisZdXlkType(){
	}
	public static BranchRedisZdXlkType getBranchRedisZdXlkType(){
		if(branchRedisZdXlkType!=null){
			return branchRedisZdXlkType;
		}else{
			return new BranchRedisZdXlkType();
		}
	}
	//修改状态为查询缓存
	public void setStam(BranchRedisType stam){
		this.stam=stam;
	}
	//开始查询
	public String startFind(){
		return stam.findBranchZdXlk();
	}
	public BranchRedisType getBranchRedisTypeOffImpl() {
		return branchRedisTypeOffImpl;
	}
	public void setBranchRedisTypeOffImpl(BranchRedisType branchRedisTypeOffImpl) {
		this.branchRedisTypeOffImpl = branchRedisTypeOffImpl;
	}
	public BranchRedisType getBranchRedisTypeOnImpl() {
		return branchRedisTypeOnImpl;
	}
	public void setBranchRedisTypeOnImpl(BranchRedisType branchRedisTypeOnImpl) {
		this.branchRedisTypeOnImpl = branchRedisTypeOnImpl;
	}
	
}
