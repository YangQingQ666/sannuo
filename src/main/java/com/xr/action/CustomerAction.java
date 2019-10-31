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
import com.opensymphony.xwork2.ModelDriven;
import com.xr.biz.CustomerBiz;
import com.xr.entity.Boss;
import com.xr.entity.Customer;
import com.xr.util.MessageUtils;
import com.xr.util.RedisPoolUtils;
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = 1L;
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	private Boss boss = (Boss) request.getSession().getAttribute("boss");
	//@Autowired
	//private AccountCurrentStatus accountCurrentStatus;
	@Autowired
	private RedisPoolUtils redisUtil;
	@Autowired
	private CustomerBiz customerBizImpl;
	@Autowired
	private Customer customer;
	@Autowired
	private MessageUtils messageUtils;
	/**
	 * 根据检测指标统揽条件查询
	 */
	public void findByWhere(){
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String zdn = request.getParameter("zdn");
		String fdn = request.getParameter("fdn");
		List<Customer> customers = customerBizImpl.getAllCustomerByWhere(name, phone, zdn, fdn);
		String customersJSON = JSON.toJSONString(customers);
		try {
			out=response.getWriter();
			out.print(customersJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	public void getDataAndCountload() {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		String parameter = request.getParameter("zdid");
		System.out.println(parameter);
		String customers = redisUtil.getStringLength("Custom")>0  ?  redisUtil.getString("Custom"):customerBizImpl.getAllCustomerByRole(boss, parameter);
		try {
			out = response.getWriter();
			out.print(customers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	/**
	 * 检测者登录的方法,将查到的值进行判断,账号密码对的就放进session里发送验证码,错误的就返回错误的提醒
	 */
	public void findByCustomer(){
			Customer customer1=null;
			try {
				customer1 = customerBizImpl.findByCustomer(customer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			HttpServletResponse resp = ServletActionContext.getResponse();
			PrintWriter out=null;
			try {
				out = resp.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(customer1!=null){
				HttpServletRequest req = ServletActionContext.getRequest();
				HttpSession session = req.getSession();
				session.setAttribute("customer", customer1);
				RedisPoolUtils redis=new RedisPoolUtils();
				redis.cleanDB();
				String code = messageUtils.verificationCode(customer1.getPhone());
				out.print(code);
			}else{
				out.print("0");
			}
	}
	
	@Override
	public Customer getModel() {
		
		return customer;
	}

}
