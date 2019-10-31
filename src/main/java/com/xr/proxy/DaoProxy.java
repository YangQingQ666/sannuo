package com.xr.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xr.util.HibernateUtil;


@Aspect
@Component
public class DaoProxy {
	
	@Pointcut("execution(* com.xr.dao.*.*(..))")
	public void daoProxy(){}
	
	@After(value="daoProxy()")
	public void daoProxyClose(){
		HibernateUtil.close();
		System.out.println("session已关闭");
	}
}
