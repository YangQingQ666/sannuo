package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.xr.biz.ProjectBiz;
import com.xr.biz.impl.ProjectBizImpl;
import com.xr.entity.Boss;
import com.xr.entity.Project;
import com.xr.util.RedisPoolUtils;

public class ProjectAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	@Autowired
	private RedisPoolUtils redisUtils;
	@Autowired
	private ProjectBiz projectBizImpl;
	@Autowired
	private Project project;
	/**
	 * 指标下拉框
	 */
	public void anomalyIndex(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
			Boss boss = (Boss) session.getAttribute("boss");
			String anomalyIndex = redisUtils.getStringLength("anomalyIndex")==0?projectBizImpl.findProjectByUnscrambleRemoveDuplicates(boss):redisUtils.getString("anomalyIndex");
			System.out.println(anomalyIndex);
			out.print(anomalyIndex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.close();
		}
	}
	
	/**
	 * 查询所有检查项目
	 * @return
	 * @throws Exception
	 */
	public void findProjectByProject(){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out=response.getWriter();
			List<Project> list=null;
			try {
				list = projectBizImpl.findProjectByProject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.print(JSON.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	/**
	 * 按项目名查询查询
	 */
	public void findProjectBydname(String dname){
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out=response.getWriter();
			List<Project> list=null;
			try {
				list = projectBizImpl.findProjectBydname(dname);
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.print(JSON.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	/**
	 * 查询单个项目
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void findProjectById(){
		response.setCharacterEncoding("UTF-8");
		String itemid = request.getParameter("did");
		PrintWriter out=null;
		Project project=null;
		try {
			out = response.getWriter();
			project = projectBizImpl.findProjectById(Integer.parseInt(itemid));
			out.print(JSON.toJSONString(project));
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
		
	}
	public void upByid(){
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		String intervarl=request.getParameter("intervarl");
		String unscramble=request.getParameter("unscramble");
		String did=request.getParameter("did");
		project.setDid(Integer.parseInt(did));
		project.setMethod(method);
		project.setIntervarl(intervarl);
		project.setUnscramble(unscramble);
		PrintWriter out=null;
		try {
			out = response.getWriter();
			int i = projectBizImpl.upByid(project);
			out.print(JSON.toJSONString(i));
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
}
