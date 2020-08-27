package com.example.demo.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.JsonData;



@Controller
@PropertySource("classpath:application.properties")
public class FileController {
	@RequestMapping(value="/api/v1/index")
	public Object index() {
		return "index";
	}
	/**
	 * 文件存储路径，可以自定义,我存到的是项目中的image中
	 * 登陆地址：localhost:8080/js/upload.html
	 * filePath 是文件注入路径
	 */
//	private static final  String filePath="G:\\study_tool\\maven_workspace\\demo\\src\\main\\resources\\static\\image\\";
//	private static final  String filePath="G:\\study_tool\\maven_workspace\\images\\";
	
	@Value("${web.file.path}")
	private   String filePath;
	/**
	 * MultipartFile对象的transferTo的效率和操作要比原先的FileOutStream方便和高效
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="upload")
	@ResponseBody
	public JsonData upload(@RequestParam("head_img")MultipartFile file,HttpServletRequest request) {
		
		System.out.println("配置文件注入打印，文件路径为："+filePath);
		
		//获取用户名
		String name=request.getParameter("name");
		System.out.println("用户名："+name);
		
		//获取文件名
		String fileName=file.getOriginalFilename();
		System.out.println("上传的文件名为："+fileName);
		
		//获取文件的后缀
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传的后缀名为："+suffixName);
		
		//文件上传前的路径
		fileName=UUID.randomUUID()+suffixName;
		System.out.println("上传前的文件："+fileName);
		
		File dest=new File(filePath+fileName);
		try {
			file.transferTo(dest);
			return new JsonData(0,fileName,null);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		
		return new JsonData(-1,"file save faile",null);
		
	}
	
	
}
