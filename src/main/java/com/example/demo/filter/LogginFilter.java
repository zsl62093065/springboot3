package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/api/*",filterName = "LogginFilter")
public class LogginFilter implements Filter{

	/**
	 * 容器加载的时候调用
	 */
	@Override
	public void init(FilterConfig filterConfig)throws ServletException {
		System.out.println("init loginFilter");
	}
	
	/**
	 * 容器拦截的时候调用
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse serletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("doliter loginFilter");
		HttpServletRequest rec=(HttpServletRequest)servletRequest;
		HttpServletResponse resp=(HttpServletResponse) serletResponse;
		String  username=rec.getParameter("username");
		if("李明".equals(username)) {
			filterChain.doFilter(servletRequest, serletResponse);
		}
		/*
		 * 拦截器的作用
		 * else { resp.sendRedirect("/index.html"); return; }
		 */
	}
	
	/**
	 * 容器销毁的时候调用
	 */
	@Override
	public void destroy() {
		System.out.println("destroy loginFilter");
	}

	
}
