package com.patrick.action.cost;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.entity.Cost;

public class CheckCostNameAction {

	// input
	private String name;
	private Boolean isExist;
	
	
	public String execute() throws DAOException  {
		try { // simulate the case that it needs 3 seconds to access database
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}//
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			Cost cost =  dao.findByName(name);
			if(cost==null){
				isExist = false;
			}else {
				// found the same record
				isExist = true;
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find your record according to the name you provided", e);
		}
		
		
		return "success";
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(Boolean isExist) {
		this.isExist = isExist;
	}
	
	
	
	
	
}

