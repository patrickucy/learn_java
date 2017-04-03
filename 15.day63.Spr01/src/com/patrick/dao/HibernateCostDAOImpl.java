package com.patrick.dao;

public class HibernateCostDAOImpl implements ICostDAO {

	public HibernateCostDAOImpl() {
		System.out.println("created a HibernateCostDAOImpl object...");
	}
	
	public void myInit(){
		System.out.println("initialize after object is created");
		
	}
	
	@Override
	public void delete() {
		System.out.println("(Hibernate)delete...");
		
	}@Override
	public void save() {
		System.out.println("(Hibernate)save...");
		
	}
}
