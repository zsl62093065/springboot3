package com.example.demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener中sessionCreated是新建一个会话时候触发也可以说是客户端第一次和服务器交互时候触发。
 * sessionDestroyed销毁会话的时候，一般来说只有某个按钮触发进行销毁或者配置定时销毁
 * 
 * @author Administrator
 * @WebListener 监听注解
 */
//@WebListener
public class SessionListener implements HttpSessionListener {

	private int onlineCount = 0;// 记录session的数量

	/**
	 * session创建后执行
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		onlineCount++;
		System.out.println("【HttpSessionListener监听器】 sessionCreated, onlineCount:" + onlineCount);
		se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}

	/**
	 * session失效后执行
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if (onlineCount > 0) {
			onlineCount--;
		}
		System.out.println("【HttpSessionListener监听器】 sessionDestroyed, onlineCount:" + onlineCount);
		se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}

}
