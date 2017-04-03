package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.dao.ICostDAO;

public class TestCostDao {

	@Test
	public void testAdd(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao = (ICostDAO) ac.getBean("jdbcCostDAOImpl"); // 虽然名字是一样的,但是第一个字母必须小写(这他妈都行)
		// 你会发现这里就是调用的动态代理类,当你用AOP的话
		System.out.println(dao.getClass().getName());
		dao.save();
		dao.findAll();
		dao.findById();
		dao.update();
		dao.delete();
	}
}
