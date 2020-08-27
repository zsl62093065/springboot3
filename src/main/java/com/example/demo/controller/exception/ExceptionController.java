package com.example.demo.controller.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.MyException;
import com.example.demo.bean.User;

/**
 * 测试异常
 * 
 * @author Administrator 可以不是用@RestController，使用@RestControllerAdvice
 */
@RestController
//@RestControllerAdvice
@PropertySource("classpath:application.properties")
public class ExceptionController {

	/**
	 * 监听日志
	 */
	private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * 编写一个异常
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/v1/test_exception")
	public Object index() {
		int i = 1 / 0;
		return new User("李明", "35", "高级程序员", "武汉市青山区", 9000, new Date());
	}

	/**
	 * @ExceptionHandler 捕获全局异常，处理所有不可知的异常
	 * @ResponseBody可以注释掉，但是要在类上面添加@RestControllerAdvice，map返回的是json格式
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	Object handleException(MyException e, HttpServletRequest request) {
		log.error("url{},msg{}", request.getRequestURL(), e.getMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", e.getMessage());
		map.put("url", request.getRequestURL());
		return map;
	}

	/**
	 * 自定义异常进行页面跳转
	 * 
	 * @param e
	 * @return
	 */

	@ExceptionHandler(value = MyException.class)
	Object handleMyException(MyException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error.html");
		modelAndView.addObject("msg", e.getMessage());
		return modelAndView;
	}

	/**
	 * 自定义返回json数据
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	/*
	 * @ExceptionHandler(value = MyException.class) Object
	 * handleMyException(MyException e, HttpServletRequest request) {
	 * log.error("url{},msg{}", request.getRequestURL(), e.getMessage());
	 * Map<String, Object> map = new HashMap<>(); map.put("code", e.getCode());
	 * map.put("msg", e.getMsg()); map.put("url", request.getRequestURL()); return
	 * map; }
	 */

	/**
	 * 自定义异常
	 * 
	 * @return
	 */
	@RequestMapping("/api/v1/myexception")
	public Object myException() {
		throw new MyException("500", "my ext异常");
	}

}
