package com.example.demo.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.ServiceSetting;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@Autowired
	private ServiceSetting  setting;
	/**
	 * 接口访问地址：localhost:8080//thymeleaf/hello
	 * 
	 * @return
	 */
	@GetMapping("hello")
	public String index() {
		return "index";//不用加后缀，在配置文件中已经配置了后缀
	}
	
	/**
	 * 接口访问地址：localhost:8080//thymeleaf/info
	 *
	 * @param modelMap
	 * @return
	 */
	@GetMapping("info")
	public String admin(ModelMap modelMap) {
		modelMap.addAttribute("setting",setting);
		return "admin/info";//不用加后缀，在配置文件中已经配置了后缀
	}
}
