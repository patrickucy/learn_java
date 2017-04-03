package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.dao.ICostDAO;

public class TestBean {

	@Test
	public void testGetBean(){
		// 获取Spring框架容器对象的实例
		// BeanFactory --> ApplicationContext(推荐)
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

		// 从Spring容器获取bean对象
		ICostDAO dao =  (ICostDAO) ac.getBean("costDao");
		dao.save();
		dao.delete();
		
	}
	
	@Test
	public void testCreate(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ICostDAO dao1 = (ICostDAO) ac.getBean("costDao");
		ICostDAO dao2 = (ICostDAO) ac.getBean("costDao");
		System.out.println(dao1);
		System.out.println(dao2);
	}
}

