package com.patrick.action;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.login.ILoginDAO;
import com.patrick.entity.Administrator;

public class LoginAction extends BaseAction {

	// input
	private String adminCode;
	private String password;
	private String imageCode;
	
	// output
	private String errorMsg;
	
	// execute
	public String execute(){
		// 0. verify verification code
		String realCode =  (String) session.get("imageCode");
		if(realCode == null || !realCode.equalsIgnoreCase(imageCode)){
			errorMsg = "the verification code you entered is wrong";
			return "fail";
		}
		
		
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
		
		// 4. after success, we register user status to a session
		session.put("admin", admin);
		
		return "success"; // go to index.jsp
	}
	
	

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

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

	
}















