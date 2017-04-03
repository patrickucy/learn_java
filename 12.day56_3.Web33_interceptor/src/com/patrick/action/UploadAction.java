package com.patrick.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.patrick.util.FileUtil;

public class UploadAction {

	// to receive upload file, this comes from interceptor, not from action
	private File some;
	/**
	 * define a String property, 以"上传文件属性名+FileName"来命名,这样就可以自动接收原始文件名
	 * 这个事情就是拦截器自动处理的 
	 */
	private String someFileName;
	
	
	

	public String execute(){
		if(some == null ) return "error";
		
		// 1. 定义相对路径, 相对于项目部署的路径,也就是tomcat的那个路径
		String path = "upload/" +someFileName;
		
		// 2. 通过相对路径来计算完整路径
		path = ServletActionContext.getServletContext().getRealPath(path);
		System.out.println("Full path: "+path);
		
		// 3. 将临时文件复制到新的路径上去
		FileUtil.copy(some, new File(path));
		return "success";
	}


	public File getSome() {
		return some;
	}


	public void setSome(File some) {
		this.some = some;
	}
	
	public String getSomeFileName() {
		return someFileName;
	}


	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}
}
