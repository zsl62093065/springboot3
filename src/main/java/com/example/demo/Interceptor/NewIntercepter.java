package com.example.demo.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * jdk8之后，可以在接口中写方法，属于jdk的新特性
 * springboot2.x之后通过接口的形式引用拦截器
 * @author Administrator
 *
 */
@Configuration
public class NewIntercepter implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截全部接口为
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
		registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
