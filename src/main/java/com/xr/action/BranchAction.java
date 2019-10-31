package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.xr.biz.BranchBiz;
import com.xr.biz.impl.BranchRedisZdXlkType;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.RedisPoolUtils;
import com.xr.util.RedisUtil;
import com.xr.entity.Branch;

public class BranchAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	@Autowired
	private RedisPoolUtils redisUtils;
	@Autowired
	private BranchBiz branchBizImpl;
	// /@Autowired
	private BranchRedisZdXlkType branchRedisZdXlkType = BranchRedisZdXlkType.getBranchRedisZdXlkType();

	/**
	 * 依据总店数据获取分店
	 */
	public void getAllSmallBranch() {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			String allBranchsXLK = null;
			String partid = request.getParameter("partid");
			out = response.getWriter();
			Boss boss = (Boss) request.getSession().getAttribute("boss");
			if ("a".equals(partid)) {
				allBranchsXLK = redisUtils.getStringLength("fdxlk") > 0 ? redisUtils.getString("fdxlk")
						: branchBizImpl.getsmallBranchs(partid);
			} else {
				System.out.println(partid);
				allBranchsXLK = branchBizImpl.getsmallBranch(partid);
			}
			out.print(allBranchsXLK);
			// System.out.println("试试" + redisUtils.getString("xlk"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * 获取总店下拉框
	 */
	public void getAllBigBranch() {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		String allBranchsXLK = null;
		try {
			out = response.getWriter();
			Boss boss = (Boss) request.getSession().getAttribute("boss");
			if (boss.getPassword() == null) {
				allBranchsXLK = redisUtils.getStringLength("zdxlk") > 0 ? redisUtils.getString("xlk")
						: branchBizImpl.getBigBranchs(boss);

				System.out.println("超级管理总店下拉框");
			} else {
				/* allBranchsXLK=branchBizImpl.getBigBranch(boss); */
				allBranchsXLK = branchRedisZdXlkType.startFind();
				System.out.println("管理总店下拉框");
			}

			out.print(allBranchsXLK);
			// System.out.println("试试" + redisUtils.getString("xlk"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * 总店分店二级联动
	 */
	public void secondaryLinkage() {
		String fdXlkJSON = null;
		String selectValue = request.getParameter("selectValue");
		try {
			if ("a".equals("a")) {
				fdXlkJSON = redisUtils.getStringLength("xlk") != 0 ? redisUtils.getString("xlk")
						: branchBizImpl.getBigBranchs();
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
