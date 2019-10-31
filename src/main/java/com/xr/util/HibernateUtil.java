package com.xr.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {
	@Autowired
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> local = new ThreadLocal<Session>();

	/**
	 * 获取Session
	 * @return
	 */
	public static Session getSession() {
		Session session = local.get();
		if(session==null||session.isOpen()){
			if(sessionFactory==null){
				ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
				sessionFactory=(SessionFactory)context.getBean("sessionFactory");
			}
			session = sessionFactory.openSession();
			local.set(session);
		}
		return session;
	}
	/**
	 * 关闭session
	 * 
	 */
	public static void close() {
		Session session=local.get();
		if(session==null||session.isOpen()){
			session.close();
		}
		local.set(null);
	}
}