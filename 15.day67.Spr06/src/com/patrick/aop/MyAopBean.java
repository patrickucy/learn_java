package com.patrick.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  // 扫描该组件到Spring容器里面
@Aspect  // 将该组件定义成方面
public class MyAopBean {
	// 使用环绕通知作用到指定的目标方法上
	@Around("execution(* add*(..)) ||  execution(* delete*(..))")
	public Object myMethod(ProceedingJoinPoint pjp) throws Throwable{
		
		// 前置处理
		Object reVal = pjp.proceed();
		// 后置处理
		
		System.out.println("[AOP]log tracking...");
		return reVal;
	}

}
