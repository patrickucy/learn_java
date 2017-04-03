package com.patrick.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patrick.action.MessageAction;

public class TestMessageAction {
	
	@Test
	public void testMessageAction(){
		
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageAction ma = (MessageAction) ac.getBean("msgAction");
		System.out.println(ma.toString());
		
		
		
	}

}
