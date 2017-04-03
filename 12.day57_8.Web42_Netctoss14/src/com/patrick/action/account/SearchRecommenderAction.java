package com.patrick.action.account;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.entity.Account;

/**
 * find recommender action
 */
public class SearchRecommenderAction {

	// input
	private String idcardNo;
	
	// output
	private Account account;

	public String execute(){
		IAccountDAO dao = DAOFactory.getAccountDAO();
		try {
			account =  dao.findByIdcardNo(idcardNo);
		} catch (DAOException e) {
			e.printStackTrace();
			/**
			 * if you can't find the record, you don't need to return "error"
			 * because this is a asyn request, you don't wanna refresh the page,
			 * but you can send a message to web page.
			 */
			account = null;
		}
		
		return "success";
	}
	
	
	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
}
