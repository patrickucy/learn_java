package com.patrick.action;

import com.patrick.dao.ICostDAO;

public class DeleteCostAction {

	private ICostDAO dao;
	
	/**
	 * 自动调用, 将costDao给传入
	 * @param costDao
	 */
	public DeleteCostAction(ICostDAO costDao) {
		this.dao = costDao;
	}
	// 建议加上这个,因为有人会有这种需求
	public DeleteCostAction() {
	}
	
	public String execute(){
		
		System.out.println("Processing delete cost action ...");
		dao.delete();
		return "success";
	}
}
