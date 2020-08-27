package com.example.demo.controller.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

	private  Map<String,Object> params=new HashMap<>();
	
	@RequestMapping(value="/api2/v1/account")
	public Object account() {
		System.out.println("controller中的account方法");
		params.put("money", "1000");
		return params;
	}
}
