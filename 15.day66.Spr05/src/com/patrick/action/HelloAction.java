package com.patrick.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.patrick.dao.MessageDao;

@Service
@Scope("prototype")
public class HelloAction {

	private String msg;
	@Resource
	private MessageDao dao;
	
	public String execute(){
		
		msg = "{msg}Hello Action!";
		System.out.println("Execute helloAction");
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
