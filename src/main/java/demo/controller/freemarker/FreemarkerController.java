package com.example.demo.controller.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.ServiceSetting;
/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

	@Autowired
	private  ServiceSetting  serviceSetting;
	/**
	 * 访问地址：localhost:8080//freemarker/hello
	 * @param modelMap
	 * @return
	 */
	@GetMapping("hello")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("serviceSetting",serviceSetting);
		return "fm/index";
	}
	
	
}
