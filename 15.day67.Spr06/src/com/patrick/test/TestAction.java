package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.action.AddCostAction;
import com.patrick.dao.ICostDAO;

public class TestAction {

	@Test
	public void testAddCostAction(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		AddCostAction action = (AddCostAction) ac.getBean("addCostAction");
		action.execute();
		
	}
	
	@Test
	public void testDao(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl");
		dao.find("套餐A", "100元150小时");
		dao.find("套餐A", "100元150小时"); // 你就试试这个如果是单例的话,就会出现问题
	}
	
}
