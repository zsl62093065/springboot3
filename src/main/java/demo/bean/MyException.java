package com.example.demo.bean;
/**
 * 创建一个自定义的异常类
 * @author Administrator
 *
 */
public class MyException extends RuntimeException{

	/**
	 * 状态码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
}
