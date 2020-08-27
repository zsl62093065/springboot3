package com.example.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.RestController;

/*
 * @SpringBootApplication public class Springboot2Application {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(Springboot2Application.class, args); }
 * 
 * }
 */


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@ServletComponentScan
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})//无数据库运行
@RestController
@Configuration
public class Springboot3Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Springboot3Application.class);
	}

	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("Springboot2Application run!");
		System.out.println("------------------------------------------");
		SpringApplication.run(Springboot3Application.class, args);
	}
	
	
	/**
	 * 设置上传文件的类型
	 * 注意MultipartConfigElement中的方法MaxFileSize和MaxRequestSize都是DataSize中的类型，需要转换，可以用ctrl来查看MultipartConfigFactory和DataSize中的方法
	 * @return
	 */
	@Bean
	public MultipartConfigElement multpartConfigElement() {
		 MultipartConfigFactory factory = new MultipartConfigFactory();
	        //单个文件大小200mb
	        factory.setMaxFileSize(DataSize.ofMegabytes(200L));
	        //设置总上传数据大小1GB
	        factory.setMaxRequestSize(DataSize.ofGigabytes(1L));
	        return factory.createMultipartConfig();

	}
}
