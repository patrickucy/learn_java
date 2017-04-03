package com.patrick.dao;

import com.patrick.dao.account.AccountDAOImpl;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.dao.cost.CostDAOImpl;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.dao.login.ILoginDAO;
import com.patrick.dao.login.LoginDAOImpl;

public class DAOFactory {

	private static ICostDAO costdao = new CostDAOImpl();
	private static ILoginDAO logindao = new LoginDAOImpl();
	private static IAccountDAO accountdao = new AccountDAOImpl();
	
	public static ICostDAO getCostDAO(){
		return costdao;
	}
	
	public static ILoginDAO getLoginDAO(){
		return logindao;
	}
	
	public static IAccountDAO getAccountDAO(){
		return accountdao;
	}
	
	
}
