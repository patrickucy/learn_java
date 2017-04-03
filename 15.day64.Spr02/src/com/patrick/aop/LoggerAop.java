package com.patrick.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.patrick.util.PropertiesUtil;

/**
 * 充当方面组件,记录用户记录
 * @author patrickyu
 *
 */
public class LoggerAop {

	/**
	 * 你想用这个获得目标组件连接点就必须要用环绕通知才行
	 * @param pjp 正在执行的连接点对象
	 * @throws Throwable 
	 */
	public Object execute(ProceedingJoinPoint pjp) throws Throwable{
		
		// --- 这就是分界线 ---
		Object obj =  pjp.proceed(); // 执行目标组件的方法
		// --- 这就是分界线 ---
		// 以下就是后置的内容
		
		String targetClass = pjp.getTarget().getClass().getName();
		String method = pjp.getSignature().getName();
		// 获取要执行方法,根据方法名判断用户做了哪些操作
		System.out.println("User has called ["+ targetClass+"] class and its ["+method+"] method  )");
		
		// 将类名,方法名 当做key,去opt.properties 中提取操作名
		String key = targetClass+"."+method;
		String val = PropertiesUtil.getPropertt(key);
		// TODO 可以从Session中获取用户名
		// ActionContext.getContext().getSession()
		System.out.println("User just do "+val);
		
		return obj;
	}
}
