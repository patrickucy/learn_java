package com.patrick.action.service;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.entity.Cost;

public class ToAddServiceAction {

	// input
	
	// output
	private List<Cost> costs;

	
	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			costs = dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		
		
		return "success";
	}
	
	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
	
}
