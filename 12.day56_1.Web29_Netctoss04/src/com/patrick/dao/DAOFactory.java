package com.patrick.dao;

public class DAOFactory {

	private static ICostDAO costdao = new CostDAOImpl();
	private static ILoginDAO logindao = new LoginDAOImpl();
	
	
	public static ICostDAO getCostDAO(){
		return costdao;
	}
	
	public static ILoginDAO getLoginDAO(){
		return logindao;
	}
	
}
