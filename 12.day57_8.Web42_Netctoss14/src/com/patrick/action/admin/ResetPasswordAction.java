package com.patrick.action.admin;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.admin.IAdminDAO;

public class ResetPasswordAction {

	//input
	/**
	 * this is a asyn action, in our web page javascrip(js array) can only pass string to our back-end java, it cannot pass an array
	 */
	private String idsString;
	
	private boolean ok;

	public String execute(){
		IAdminDAO dao = DAOFactory.getAdminDAO();
		String[] ids = idsString.split(",");
		try {
			dao.resetPasswords(ids);
			ok = true;
		} catch (DAOException e) {
			e.printStackTrace();
			ok = false;
		}
		
		
		return "success";
	}
	
	
	
	
	public String getIdsString() {
		return idsString;
	}

	public void setIdsString(String idsString) {
		this.idsString = idsString;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	
	
	
}
