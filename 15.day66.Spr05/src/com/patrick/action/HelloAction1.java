package com.patrick.action;


import com.patrick.dao.MessageDao;
/**
 * 假设你的配置名字要写成struts那样的,然后还是想要Spring容器来帮你创建,下面的setJdbcMessageDao()是有必要的
 * 交由StrutsSpringObjectFactory创建
 * @author patrickyu
 *
 */
public class HelloAction1 {

	private String msg;
	private MessageDao dao;
	
	// * 将Spring容器中id名与setXXX 一致的bean对象注入
	public void setJdbcMessageDao(MessageDao dao){
		this.dao = dao;
		
	}
	
	public String execute(){
		msg = dao.getMsg();
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
