package com.patrick.action;

import com.patrick.dao.ICostDAO;

public class AddCostAction {

	private ICostDAO costDao;
	
	// set injection, Spring会自动调用该方法将CostDAO对象注入 
	public void setCostDao(ICostDAO costDao) {
		this.costDao = costDao;
	}
	
	public String execute(){
		System.out.println("Processing your request...");
		costDao.save();
		return "success";
	}




	
}
