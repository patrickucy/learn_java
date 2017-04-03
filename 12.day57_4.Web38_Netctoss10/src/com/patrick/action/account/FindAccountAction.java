package com.patrick.action.account;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.entity.Account;

public class FindAccountAction {

	//input 
	private String idcardNo;
	private String realName;
	private String loginName;
	private String status;
	private int page=1;
	private int pageSize;
	
	//output
	private List<Account> accounts;
	private int totalPage;

	public String execute(){
		try {
			accounts =  DAOFactory.getAccountDAO().findByCondition(idcardNo, realName, loginName, status, page, pageSize);
			totalPage = DAOFactory.getAccountDAO().findTotalPage(idcardNo, realName, loginName, status, pageSize);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	
	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
