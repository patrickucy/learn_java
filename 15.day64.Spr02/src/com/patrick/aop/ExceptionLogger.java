package com.patrick.aop;

public class ExceptionLogger {

	public void logger(Exception ex){
		
		System.out.println("Exception Happens! Exception : ["+ex +"] {"+ex.getStackTrace()[0] +"}");
		// 将ex信息利用写文件操作记录下来
	}
}
