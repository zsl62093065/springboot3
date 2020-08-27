package com.example.demo.domain;

import java.io.Serializable;

public class JsonData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//状态码,0表示成功，-1表示失败
		private  int code;
		
		//结果
		private Object data;
		
		//返回错误消息
		private String msg;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public JsonData(int code, Object data, String msg) {
			super();
			this.code = code;
			this.data = data;
			this.msg = msg;
		}
		
		
}
