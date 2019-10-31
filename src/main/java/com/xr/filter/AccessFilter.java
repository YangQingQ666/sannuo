package com.xr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.xr.entity.Boss;
import com.xr.entity.Customer;

/**
 * 拦截器类用于拦截页面账号是否登录
 * @author Administrator
 *
 */
public class AccessFilter implements Filter{
	@Override
	public void destroy() {
	
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//向下转型
		HttpServletRequest request = (HttpServletRequest)arg0;	
		HttpServletResponse response = (HttpServletResponse)arg1;
		//获取session
		try {
			HttpSession session = request.getSession();
			Boss boss = (Boss) session.getAttribute("boss");
			Customer customer=(Customer) session.getAttribute("customer");
			if(boss==null&&customer==null){
				response.sendRedirect("../login.jsp");
			}else{
				arg2.doFilter(request, response);
			}
		} catch (Exception e) {
			System.out.println("出错");
			response.sendRedirect("login.jsp");
		}
		//TB_001 user = (TB_001) session.getAttribute("user");
	//	if(user!=null){		//如用户已登录
	//		if(user.getName().equals("admin")){
	//			arg2.doFilter(request, response);		//传递请求，继续操作
	//		}else{
	//			request.getRequestDispatcher("login-fail.jsp").forward(request,response);
	//		}
		    
	//	}else{
	//	    request.getRequestDispatcher("login-fail.jsp").forward(request,response);
	//	}
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
