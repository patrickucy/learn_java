package com.patrick.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.entity.Cost;

public class Test {
	
	@org.junit.Test
	public void test(){
		// beanFactory" Spring最基本的一个获得bean的接口,
		// applicationContext: 是beanFactory的子接口
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICostDAO costDao = (ICostDAO) factory.getBean("costDao");
		List<Cost> list = costDao.findAll();
		Iterator<Cost> iterator = list.iterator();
		
		while(iterator.hasNext()){
			Cost cost = iterator.next();
			System.out.println(cost);
		}
	}

}
