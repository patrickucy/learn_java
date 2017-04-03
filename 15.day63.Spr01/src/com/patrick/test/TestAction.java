package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.action.AddCostAction;
import com.patrick.action.DeleteCostAction;

public class TestAction {

	@Test
	public void testAddCostAction(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AddCostAction addAction =  (AddCostAction) ac.getBean("addCostAction");
		addAction.execute();
	}
	
	
	@Test
	public void testDeleteCostAction(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DeleteCostAction deleteAction =  (DeleteCostAction) ac.getBean("deleteCostAction");
		deleteAction.execute();
	}
}
