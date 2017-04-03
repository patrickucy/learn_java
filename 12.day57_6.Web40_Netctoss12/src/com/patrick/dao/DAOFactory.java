package com.patrick.dao;

import com.patrick.dao.account.AccountDAOImpl;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.dao.cost.CostDAOImpl;
import com.patrick.dao.cost.ICostDAO;
import com.patrick.dao.login.ILoginDAO;
import com.patrick.dao.login.LoginDAOImpl;
import com.patrick.dao.role.IRoleDAO;
import com.patrick.dao.role.RoleDAOImpl;
import com.patrick.dao.service.IServiceDAO;
import com.patrick.dao.service.ServiceDAOImpl;

public class DAOFactory {

	private static ICostDAO costdao = new CostDAOImpl();
	private static ILoginDAO logindao = new LoginDAOImpl();
	private static IAccountDAO accountdao = new AccountDAOImpl();
	private static IServiceDAO servicedao = new ServiceDAOImpl();
	private static IRoleDAO roledao = new RoleDAOImpl();
	
	
	public static ICostDAO getCostDAO(){
		return costdao;
	}
	
	public static ILoginDAO getLoginDAO(){
		return logindao;
	}
	
	public static IAccountDAO getAccountDAO(){
		return accountdao;
	}
	
	public static IServiceDAO getServiceDAO(){
		return servicedao;
	}
	
	public static IRoleDAO getRoleDAO(){
		return roledao;
	}
	
}
