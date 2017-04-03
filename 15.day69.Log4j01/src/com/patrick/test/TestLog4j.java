package com.patrick.test;

import org.apache.log4j.Logger;


public class TestLog4j {
	
	private static final Logger logger = Logger.getLogger(TestLog4j.class.getName());
	
	
	
	public static void main(String[] args) {
		logger.debug("Debuging info...");
		logger.info("normal info...");
		logger.warn("warning info...");
		logger.error("Error info...");
		logger.fatal("Fatal info...");
	}

}
