package com.patrick.action;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.ICostDAO;
import com.patrick.entity.Cost;

public class UpdateCostAction {

	private Cost cost;
	
	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			dao.update(cost);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
}
