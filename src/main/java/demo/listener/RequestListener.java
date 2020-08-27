package com.example.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
/**
 * 主要用来做资源加载
 * @author Administrator
 * @WebListener 监听注解
 */
//@WebListener
public class RequestListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("-----------requestDestroyed--------------");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("-----------requestInitialized-------------");
	}
}
