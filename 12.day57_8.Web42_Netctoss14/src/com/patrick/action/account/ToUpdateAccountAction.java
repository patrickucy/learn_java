package com.patrick.action.account;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.entity.Account;

public class ToUpdateAccountAction {

	// input
	private int id;
	
	// output
	private Account account;

	
	public String execute(){
		IAccountDAO dao = DAOFactory.getAccountDAO();
		
		try {
			account = dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return  "error";
		}
		
		
		return "success";
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}

