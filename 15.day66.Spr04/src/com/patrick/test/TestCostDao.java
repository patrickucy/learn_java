package com.patrick.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.dao.DAOException;
import com.patrick.dao.ICostDAO;
import com.patrick.entity.Cost;

public class TestCostDao {

	@Test
	public void testAdd(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); // 虽然名字是一样的,但是第一个字母必须小写(这他妈都行)
		// 你会发现这里就是调用的动态代理类,当你用AOP的话
		System.out.println(dao.getClass().getName());
//		dao.save();
//		dao.findAll();
//		dao.findById();
//		dao.update();
//		dao.delete();
	}
	
	@Test
	public void testDelete() throws DAOException{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); 
		Cost cost = new Cost();
		cost.setId(12);
		dao.delete(cost);
		System.out.println("finished deleting...");
	}
	
	@Test
	public void testFindById() throws DAOException{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); 
		Cost cost = dao.findById(1);
		System.out.println(cost);
		
	}
	
	@Test
	public void testFindAll() throws DAOException{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); 
		List<Cost> list = dao.findAll();
		for(Cost cost: list){
			System.out.println(cost);
		}	
	}
	
	
	@Test
	public void testCount() throws DAOException{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); 
		System.out.println("there are ["+dao.count()+"] records in database");
	}
	
	@Test
	public void testFindAllHibernate(){
		// 没有反应的原因是表不对,因为你没有用xml把之前的配置表联系起来
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("hibernateCostDAOImpl"); 
		List<Cost> list = dao.findAll();
		for(Cost cost: list){
			System.out.println(cost);
		}	
	}
	
	public List<Cost> testFindPage() throws DAOException{
		return null;
	}
}
