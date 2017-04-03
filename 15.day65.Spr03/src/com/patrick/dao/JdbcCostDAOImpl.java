package com.patrick.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope //等价scope属性
public class JdbcCostDAOImpl implements ICostDAO {

	@PostConstruct // 相当于 init-method属性作用
	public void myinit(){
		
	}
	
	@PreDestroy // 等价于 destroy-method属性作用
	public void mydestroy(){
		
	}
	
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
		System.out.println("(JDBC)findAll()... ");
	}
	
	@Override
	public void findById() {
		System.out.println("(JDBC)findById()... ");
	}
	
	@Override
	public void update() {
		System.out.println("(JDBC)update()...");
	}

	
}
