package com.patrick.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecondInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {

		System.out.println("initializing Second interceptor ...");
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("Second Interceptor before .... ");

		arg0.invoke();
		System.out.println("Second Interceptor after .... ");


		return "error";
	}

}
