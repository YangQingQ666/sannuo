package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.xr.biz.ProjectOrderBiz;
import com.xr.biz.impl.ProjectOrdersBizImpls;
import com.xr.entity.Boss;

public class ParojectOrderAction {
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	private Boss boss=(Boss)session.getAttribute("boss");

	public void findByWhere(){
		response.setCharacterEncoding("UTF-8");
		String fd = request.getParameter("fd");
		String zb=request.getParameter("zb");
		String age=request.getParameter("age");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		System.out.println(fd+zb+age+start+end);
		List<Object> dx=new ArrayList<Object>();
		dx.add(fd);
		dx.add(zb);
		dx.add(age);
		dx.add(start);
		dx.add(end);
		String findProjectOrderByWhere =ProjectOrdersBizImpls.getProjectOrdersBizImpls().findProjectOrderByWhere(dx);
		PrintWriter out=null;
		try {
			out = response.getWriter();
			out.print(findProjectOrderByWhere);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	/**
	 * 查询公开的检测记录
	 * 业务：保护商业机密只能查询公开的记录
	 */
	public void findPublicinspectionRecords(){
		response.setCharacterEncoding("UTF-8");
		String zd=request.getParameter("zd");
		String fd = request.getParameter("fd");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		ProjectOrdersBizImpls projectOrderBizImpls = ProjectOrdersBizImpls.getProjectOrdersBizImpls();
		String findPublicinspectionRecords = projectOrderBizImpls.findPublicinspectionRecords(zd,fd,start,end);
		PrintWriter out=null;
		try {
			out = response.getWriter();
			out.print(findPublicinspectionRecords);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
