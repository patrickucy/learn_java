package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.dao.ICostDAO;
import com.patrick.dao.JdbcCostDAOImpl;

public class TestAop {

	@Test
	public void test(){
		System.out.println("hello?");
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		ICostDAO dao = (ICostDAO) ac.getBean(JdbcCostDAOImpl.class.getName());
		System.out.println(dao);
		dao.add(null);
		dao.find("Combo", "description");
		dao.delete(null);
	}
}
