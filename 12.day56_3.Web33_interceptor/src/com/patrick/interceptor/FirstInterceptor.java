package com.patrick.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class FirstInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {

		System.out.println("initializing First interceptor ...");
		
	}

	/**
	 *  the way it intercept, it doesn't mean you can't access your action --
	 *  all traffic have been controlled.
	 *  it means that you can add some code before or after you access your action
	 *  in order to improvement the feature of this action
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("First Interceptor before .... ");
		
		/**
		 *  use reflection mechanism to call action
		 *  if you don't write this line of code, it won't call action.
		 *  Usually we use arg0.invoke(); 
		 */
		arg0.invoke();
		System.out.println("First Interceptor after .... ");

		/**
		 * this return value will only be available when we didn't write the line of code (arg0.invoke();)
		 * then it will go to the "error" result. 
		 * if we did write the "arg0.invoke();", then it will return the String value from that action it is
		 * binding.
		 */
		return "error";
	}

}
