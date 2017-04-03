package com.patrick.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {

	@AfterThrowing(throwing="ex",pointcut="within(com.patrick.dao..*)")
	public void logger(Exception ex){
		
		System.out.println("Exception Happens! Exception : ["+ex +"] {"+ex.getStackTrace()[0] +"}");
		// 将ex信息利用写文件操作记录下来
	}
}
