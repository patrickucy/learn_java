package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.action.AddCostAction;

public class TestAddCostAction {

	@Test
	public void testAddCostAction(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AddCostAction aca = (AddCostAction) ac.getBean("addCostAction");
		aca.execute();
	}
}
