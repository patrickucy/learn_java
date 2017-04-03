package com.patrick.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.patrick.dao.ICostDAO;

/**
 * action 是框架在调用,所以,你就不用写接口了,而DAO是你自己写的,所以最好定义接口
 * @author patrickyu
 *
 */
@Controller
@Scope("prototype")
public class AddCostAction {
	
	@Resource
	private ICostDAO dao;
	
//	// set注入
//	public void setDao(ICostDAO dao) {
//		this.dao = dao;
//	}
	
	
	public String execute(){
		System.out.println("processing add cost operation...");
		dao.add(null);
		return "success";
	}




	
	
}
