package com.xr.filter;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
/**
 * 写一个初始化token过滤器
 * @author Administrator
 *
 */
public class TokenFilter implements Filter{
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Token");
		String token = UUID.randomUUID().toString();//创建令牌,全局标识符
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("token", token);//绑定到session里
	}
}
