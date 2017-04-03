package com.patrick.dao;

public class DAOFactory {

	private static ICostDAO costdao = new CostDAOImpl();
	
	public static ICostDAO getCostDAO(){
		return costdao;
	}
}
