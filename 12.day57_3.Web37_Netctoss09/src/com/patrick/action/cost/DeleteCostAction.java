package com.patrick.action.cost;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.cost.ICostDAO;

public class DeleteCostAction {

	// input 
	private int id;
	
	// output -> none
	
	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			dao.delete(id);
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
	
	
	
}
