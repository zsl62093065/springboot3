package com.example.demo.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 旧版本的拦截器（springboot2.x之前的拦截器）,不建议使用，我的版本是2.3.3，所以这里WebMvcConfigurerAdapter是横线
 * @author Administrator
 *
 */
//@Configuration
public class OldIntercepter extends WebMvcConfigurerAdapter{

	/**
	 * 添加旧版拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api/*/**");
		super.addInterceptors(registry);
	}

}
