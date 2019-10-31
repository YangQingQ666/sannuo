package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xr.biz.JurisdictionBiz;
import com.xr.entity.Boss;
import com.xr.entity.Jurisdiction;
import com.xr.util.RedisPoolUtils;

@Controller
public class JurisdictionAction {
	@Autowired
	private JurisdictionBiz jurisdictionBiz;
	@Autowired
	private RedisPoolUtils redisPoolUtils;
	private Jurisdiction jurisdiction=new Jurisdiction();
	/**
	 * 首页初始化
	 */
	public void findJurisdiction() {

		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Boss boss = (Boss) session.getAttribute("boss");
		Map<String, List<Map<String, Object>>> findByJurisdiction = null;
		String str = "";
		if (redisPoolUtils.getStringLength("firstPage") == 0) {
			try {
				findByJurisdiction = jurisdictionBiz.findByJurisdiction(boss.getAccount());
				str = JSON.toJSONString(findByJurisdiction, SerializerFeature.DisableCircularReferenceDetect);
				redisPoolUtils.setString("firstPage", str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			str = redisPoolUtils.getString("firstPage");
		}

		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(str);
	}
	/**
	 * 查询所有权限
	 */
	public void findByJurisdiction(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			List<Jurisdiction> list=null;
			try {
				list = jurisdictionBiz.findByJurisdiction();
				out.print(JSON.toJSONString(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	/**
	 * 查询二级菜单
	 */
	public void finByJurisdictionTwo(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			List<Jurisdiction> list=null;
			try {
				list = jurisdictionBiz.findByO();
				out.print(JSON.toJSONString(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	/**
	 * 新增菜单
	 */
	public void saveMenumanage(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		String jname = req.getParameter("jname");
		String url = req.getParameter("url");
		String partid = req.getParameter("partid");
		String icon = req.getParameter("icon");
		jurisdiction.setIcon(icon);
		jurisdiction.setJname(jname);
		jurisdiction.setPartid(Integer.parseInt(partid));
		jurisdiction.setUrl(url);
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			try {
				 int i = jurisdictionBiz.saveMenumanage(jurisdiction);
				out.print(JSON.toJSONString(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	/**
	 * 根据id查询权限
	 */
	public void findById(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			try {
				 Jurisdiction byId = jurisdictionBiz.findById(Integer.parseInt(id));
				out.print(JSON.toJSONString(byId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	public void upJurisdictionById(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		String jname = req.getParameter("jname");
		String url = req.getParameter("url");
		String partid = req.getParameter("partid");
		String icon = req.getParameter("icon");
		String id = req.getParameter("jid");
		jurisdiction.setIcon(icon);
		jurisdiction.setJname(jname);
		jurisdiction.setPartid(Integer.parseInt(partid));
		jurisdiction.setUrl(url);
		jurisdiction.setJid(Integer.parseInt(id));
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			int i = jurisdictionBiz.upJurisdictionById(jurisdiction);
			out.print(JSON.toJSONString(i));
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
	public void upJurisdictionByState(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		String state = req.getParameter("state");
		String id = req.getParameter("id");
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			int i = jurisdictionBiz.upJurisdistionByState(Integer.parseInt(id), Integer.parseInt(state));
			out.print(JSON.toJSONString(i));
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
	
}
