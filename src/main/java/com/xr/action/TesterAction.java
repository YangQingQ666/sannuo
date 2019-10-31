package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xr.biz.TesterBiz;
import com.xr.entity.Customer;
import com.xr.entity.Project;


public class TesterAction extends ActionSupport implements ModelDriven<Project>{

	@Autowired
	private TesterBiz testerbiz;
	
	@Autowired
	private Project project;
	
	@Autowired
	private Customer customer;
	private final HttpServletRequest request = ServletActionContext.getRequest();
	private final HttpServletResponse response = ServletActionContext.getResponse();
	@Override
	public Project getModel() {
		// TODO Auto-generated method stub'
		
		return null;
	}
		
	//����id��ѯ�������
	public void  query(){
		//����biz��
		List<Map<String, Object>> list = testerbiz.query();
		//����ѯ�������ݴ��͵�jspҳ��
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		String json = JSON.toJSONString(list);
		try {
			 out = response.getWriter();
			 out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println(json);
			out.close();
			
		}
	}
	public void select(){
		System.out.println("nihao  ");
		//����biz��
				List<Customer> list = testerbiz.select();
				//����ѯ�������ݴ��͵�jspҳ��
				response.setCharacterEncoding("utf-8");
				PrintWriter out=null;
				String mjson = JSON.toJSONString(list);
				try {
					 out = response.getWriter();
					 out.print(mjson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					System.out.println(mjson);
					out.close();
				}
	}
}
