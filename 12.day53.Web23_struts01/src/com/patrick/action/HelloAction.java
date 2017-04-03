package com.patrick.action;

import com.opensymphony.xwork2.ModelDriven;
import com.patrick.entity.User;

public class HelloAction implements ModelDriven<User>{
	
	
	/**
	 *  #1. use property directly
	 */
//	private String username;
//	private String password;
//	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public HelloAction(){
//		System.out.println("instantiating hello action...");
//		
//	}
	
	
	
	
	/**
	 * use a object to wrap properties
	 */
//	private User user;
//	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	
	/**
	 * use ModelDriven to wrap properties
	 */
	private User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	
	
	
	
	
	
	
	/**
	 * business method, to organize business logic to cater needs.
	 * 1. has to be public method
	 * 2. has to be a return value of String to find the corresponding result
	 * 3. you can define a method on the fly, and configure the "method" property in action 
	 * 4. method parameter list muse be empty
	 * 
	 */
	public String execute(){
		// print a line and simulate our business logic
		System.out.println("hello struts 2 from java");
//		this.username = "patrick";
//		this.password = "12345"; // you can send these properties directly to web page
		
//		System.out.println("username: "+user.getUsername());
//		System.out.println("password: "+user.getPassword());
		return "success";
	}

	
	
	
	
}










