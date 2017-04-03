package com.patrick.action.cost;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.entity.Cost;

public class ToUpdateCostAction {

	// input
	private int id;
	
	// output
	private Cost cost;

	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			cost = dao.findByID(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	
	
}
