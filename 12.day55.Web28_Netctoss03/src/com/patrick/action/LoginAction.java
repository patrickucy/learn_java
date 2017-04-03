package com.patrick.action;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.ILoginDAO;
import com.patrick.entity.Administrator;

public class LoginAction {

	// input
	public String adminCode;
	public String password;
	
	
	// output
	private String errorMsg;
	
	
	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public String execute(){
		// 1. verify user name 
		ILoginDAO dao = DAOFactory.getLoginDAO();
		Administrator admin = null;
		try {
			admin = dao.fingByCode(adminCode);
		} catch (DAOException e) {
			e.printStackTrace();
			errorMsg = "Fail to access adminitrator infomation, please contact your contractor";
			return "fail";
		}
		
		if(admin == null){
			// 2. no such administrator, then no such account
			errorMsg = "Account you enter doesn't exist";
			
			return "fail"; // back to login page
		}else {
			// 3. verify password if we have such user account
			String pwd = admin.getPassword();
			if(!pwd.equals(this.password)){
				errorMsg = "You enter a wrong password";
				return "fail"; // back to login page
			}
			
		}
		
		
		// 4. success
		
		return "success"; // go to index.jsp
	}
}
