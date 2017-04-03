package com.patrick.entity;

public class User {

	private String username; // 跟表单组件的name属性一致,这样才能传过来
	private String pwd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
