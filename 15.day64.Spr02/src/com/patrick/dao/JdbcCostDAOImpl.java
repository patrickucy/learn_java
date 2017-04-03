package com.patrick.dao;

public class JdbcCostDAOImpl implements ICostDAO {

	public JdbcCostDAOImpl() {
		System.out.println("JdbcCostDAOImpl()...");
	}
	
	@Override
	public void save() {
		System.out.println("(JDBC)Save()...");
	}

	@Override
	public void delete() {
		System.out.println("(JDBC)delete()...");
		String s = null;
		s.length(); // 模拟一个异常在这里
	}
	
	@Override
	public void findAll() {
		System.out.println("(JDBC) findAll()... ");
		
	}
	
	@Override
	public void findById() {
		System.out.println("(JDBC) findById()... ");
	}
	
	@Override
	public void update() {
		System.out.println("(JDBC) update()...");
		
	}

	
}
