package com.patrick.dao;

public class JdbcCostDAOImpl implements ICostDAO {

	public JdbcCostDAOImpl() {
		System.out.println("created JdbcCostDAOImpl object... ");
	}
	
	@Override
	public void save() {
		System.out.println("(JDBC)Save...");
	}

	@Override
	public void delete() {
		System.out.println("(JDBC)delete...");
	}

}
