package com.example.demo.bean;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 * @JsonIgnore不返回字段
	 */
	@JsonIgnore
	private String sex;
	/**
	 * 工作
	 */
	
	private String work;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 存款
	 * @JsonProperty("account")  不返回真实的字段给别人，返回别名给别人
	 */
	@JsonProperty("account")
	private int deposit;
	/**
	 * 创建时间
	 * @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")  转换时间格式
	 */
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date createTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User(String name, String sex, String work, String address, int deposit, Date createTime) {
		super();
		this.name = name;
		this.sex = sex;
		this.work = work;
		this.address = address;
		this.deposit = deposit;
		this.createTime = createTime;
	}
}
