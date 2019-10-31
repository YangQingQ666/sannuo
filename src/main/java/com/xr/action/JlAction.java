package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xr.biz.JlBiz;
import com.xr.entity.Boss;
import com.xr.entity.Customer;
import com.xr.util.RedisPoolUtils;

public class JlAction extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = 1L;
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	private final Boss boss = (Boss) request.getSession().getAttribute("boss");
	@Autowired
	private JlBiz jlBizImpl;
	@Autowired
	private RedisPoolUtils redisUtil;
	public void enquiriesOnQualifiedPersons(){
		response.setCharacterEncoding("UTF-8");
		String numberOfQualified=null;
		PrintWriter out=null;
		try {
			out = response.getWriter();
			//根据权限
			System.out.println("-------------------------------------------");
			if(boss.getNewBranch()==null){
				numberOfQualified = redisUtil.getStringLength("adminNumberOfQualified")==0? jlBizImpl.adminNumberOfQualifiedDB():jlBizImpl.adminNumberOfQualifiedRedis();
			}else{
				numberOfQualified =redisUtil.getStringLength("zdNumberOfQualified")==0? jlBizImpl.zdNumberOfQualifiedDB():redisUtil.getString("zdNumberOfQualified");
			}
			System.out.println(numberOfQualified);
			out.print(numberOfQualified);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	public void maximumDetection(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		String result=null;
		try {
			out = response.getWriter();
			if(boss.getNewBranch()==null){
				result=redisUtil.getStringLength("adminMaximumDetection")==0?jlBizImpl.adminMaximumDetectionDB():jlBizImpl.adminMaximumDetectionRedis();
			}else{
				result=redisUtil.getStringLength("otherMaximumDetection")==0?jlBizImpl.otherMaximumDetectionDB():jlBizImpl.otherMaximumDetectionRedis();
			}
			System.out.println(result);
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
