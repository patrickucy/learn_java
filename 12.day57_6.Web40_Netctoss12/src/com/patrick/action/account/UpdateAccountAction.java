package com.patrick.action.account;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.entity.Account;

public class UpdateAccountAction {

	private Account account;

	public String execute(){
		IAccountDAO dao = DAOFactory.getAccountDAO();
		try {
			dao.update(account);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
