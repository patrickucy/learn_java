package com.patrick.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	
	/**
	 * in fact this is a map
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static{
		Properties props = new Properties();
		try {
			props.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			user = props.getProperty("user");
			password = props.getProperty("password");
			url = props.getProperty("url");
			driver = props.getProperty("driver");
			Class.forName(driver);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to read database configuration file!",e);
		}
	}
	
	public static Connection getConnection(){
		Connection con = tl.get();
		if(con == null){
			try {
				con = DriverManager.getConnection(url,user,password);
				tl.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Fail to connect database!");
			}
			
		}
		return con;
	}
	
	public static void closeConnection(){
		Connection con = tl.get();
		if(con!=null){
			try {
				con.close();
				tl.set(null);
			} catch (Exception e) {
				throw new RuntimeException("Fail to disconnect from database");
			}
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
		closeConnection();
	}
}
