package com.patrick.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * check our user login status at every action.
 * @author patrickyu
 *
 */
public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		Map<String,Object> session =  arg0.getInvocationContext().getSession();
		
		// 
		Object admin =  session.get("admin");
		
		if(admin == null){
			// user has not logged in
			return "login"; // find the result to go to login page via "login" string here
		}else {
			//user has logged in
			return arg0.invoke();
		
		}
		
	}

}
