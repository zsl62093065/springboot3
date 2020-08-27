package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问地址：http://localhost:8080//v1/test/customs
 * 访问页面的结果:custom servlet
 * @author Administrator
 *
 */
@WebServlet(name="userServlet",urlPatterns = "/v1/test/customs")
public class UserServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		resp.getWriter().print("custom servlet");
		resp.getWriter().flush();
		resp.getWriter().close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);;
	}
	
	
}
