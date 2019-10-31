package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xr.biz.BossBiz;
import com.xr.biz.impl.BranchRedisZdXlkType;
import com.xr.biz.pojo.BranchRedisTypeOffImpl;
import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.util.EncryptionUtil;
import com.xr.util.RedisPoolUtils;

@Controller
public class BossAction extends ActionSupport implements ModelDriven<Boss> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Boss boss;
	@Autowired
	private BossBiz bossBiz;

	@Override
	public Boss getModel() {
		return boss;
	}

	/**
	 * 登录的方法,将查到的值进行判断,账号密码对的就放进session里,错误的就返回错误的提醒
	 */
	public void findByBoss() {
		Boss findByBoss = null;
		try {
			findByBoss = bossBiz.findByBoss(boss);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String mi = "";
		try {
			mi = EncryptionUtil.toencode(findByBoss.getPassword());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		findByBoss.setPassword(mi);
		if (findByBoss != null && findByBoss.getPassword().equals(boss.getPassword())) {
			HttpServletRequest req = ServletActionContext.getRequest();
			HttpSession session = req.getSession();
			// session.invalidate();
			session.setAttribute("boss", findByBoss);
			RedisPoolUtils redis = new RedisPoolUtils();
			// 关闭状态
			BranchRedisZdXlkType.getBranchRedisZdXlkType().setStam(new BranchRedisTypeOffImpl());
			redis.cleanDB();
			out.print("1");
		} else {
			out.print("0");
		}
	}

	/**
	 * 查询登录账号的所有店铺信息
	 */
	public void queryBossBranch() {
		// 从session中取出所登录用户
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Boss boss = (Boss) session.getAttribute("boss");
		PrintWriter out = null;
		try {
			List<Branch> list = bossBiz.queryBossBranch(boss);
			HttpServletResponse resp = ServletActionContext.getResponse();
			out = resp.getWriter();
			out.print(JSON.toJSONString(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.close();
		}
	}

	/**
	 * 查询登录账号的个人信息
	 */
	public void queryInfo() {

		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Boss b = (Boss) session.getAttribute("boss");
		PrintWriter out = null;
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		try {
			List<Map<String, Object>> list = bossBiz.queryinfo(b);
			out = resp.getWriter();
			String json = JSON.toJSONString(list);
			out.print(json);
			System.out.println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.close();
		}
	}

	/**
	 * 修改个人信息
	 */
	public void updateInfo() {
		// 取参数
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		// 获得对象
		HttpSession session = request.getSession();
		Boss boss = (Boss) session.getAttribute("boss");
		boss.setMname(name);
		boss.getNewBranch().setPhone(phone);

		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			int i = bossBiz.updateInfo(boss);
			if (i > 0) {
				out = response.getWriter();
				out.print(1);
			} else {
				out.print(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.close();
		}
	}

	/**
	 * 判断输入的密码是否正确
	 */
	public void queryMm() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		// 取出jsp页面传过来的密码
		String pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		Boss b = (Boss) session.getAttribute("boss");
		String password = b.getPassword();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		if (pwd.equals(password)) {
			try {
				out = response.getWriter();
				out.print(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.close();
			}
		}
	}

	// 修改密码
	public void updateMm() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Boss b = (Boss) session.getAttribute("boss");
		String pwd = request.getParameter("pwd");
		b.setPassword(pwd);
		try {
			int i = bossBiz.updatePwd(b);
			if (i > 0) {

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 停用账号
	public void del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Boss b = (Boss) session.getAttribute("boss");
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			int i = bossBiz.del(b);
			out = resp.getWriter();
			out.print(JSON.toJSONString(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.close();
		}
	}

}
