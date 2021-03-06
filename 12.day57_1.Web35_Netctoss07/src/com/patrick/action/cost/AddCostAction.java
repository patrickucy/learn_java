package com.patrick.action.cost;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.entity.Cost;

public class AddCostAction {

	//input 
	private Cost cost;
	
	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			dao.insert(cost);
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

