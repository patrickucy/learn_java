package com.patrick.util;

import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {

	private static Properties props = new Properties();
	
	static{
		
		try {
			props.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("opt.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getPropertt(String key){
		String val = props.getProperty(key);
		return val;
	}
		
}
