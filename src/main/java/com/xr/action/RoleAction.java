package com.xr.action;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.xr.biz.RoleBiz;
import com.xr.entity.Role;

@Controller
public class RoleAction {
	@Autowired
	private RoleBiz roleBiz;
	/**
	 * 查询所有权限
	 */
	public void findByRole(){
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out=null;
		List<Role> list=null;
		try{
			out=response.getWriter();
			list=roleBiz.findByRole();
			out.print(JSON.toJSONString(list));
		}catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
		}
}
