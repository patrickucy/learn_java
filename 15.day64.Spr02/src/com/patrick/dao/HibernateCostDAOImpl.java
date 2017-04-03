package com.patrick.dao;

public class HibernateCostDAOImpl implements ICostDAO {

	public HibernateCostDAOImpl() {
		System.out.println("HibernateCostDAOImpl()...");
	}
	
	public void myInit(){
		System.out.println("HibernateCostDAOImpl myInit()...");
		
	}
	
	@Override
	public void delete() {
		System.out.println("(Hibernate)delete()...");
		
	}@Override
	public void save() {
		System.out.println("(Hibernate)save()...");
		
	}
	
	@Override
	public void findAll() {
		System.out.println("(Hibernate)findAll()...");
	}
	
	@Override
	public void findById() {
		System.out.println("(Hibernate)findById()...");
	}
	
	
	@Override
	public void update() {
		System.out.println("(Hibernate)update()...");
		
	}
	
	
}
