package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 主要用来做统计
 * @author Administrator
 * @WebListener 是一个监听注解
 */
//@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sre) {
		System.out.println("-----------contextDestroyed--------------");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sre) {
		System.out.println("-----------contextInitialized-------------");
	}

}
