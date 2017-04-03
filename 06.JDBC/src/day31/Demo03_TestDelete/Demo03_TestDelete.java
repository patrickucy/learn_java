package day31.Demo03_TestDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03_TestDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/**
		 *  ********** 1. create connection **********
		 */
		
		
		// ------ Step 1: register oracleDiver class, load driver resource package ------ 
		/** 
		 * Approach #1: 
		 * Fot this approach, it just load the resource, and it doesn't assign any memory
		 */
		Class.forName("oracle.jdbc.OracleDriver"); // trigger static block within "OracleDriver"
		
		/** 
		 * Method #2"
		 * In this approach, you instantiated a instance, it assigned memory to it.
		 */
//		new OracleDriver();
		
		
		
		// ------ Step 2: specify server connection info, account and password ------
		/*
		 *  url needs to specify ip,port and library of Oracle server
		 *  jdbc:oracle:thin:@ServerIP:Port:LibraryName
		 *  
		 *  mysql url = 'jdbc:mysql://ip:3304/lib"
		 */
		
		String url = "jdbc:oracle:thin:@192.168.1.100:1521:patrickucy";
		String user = "system";
		String password = "Yy123123";
		
	
		// ------ Step 3: Get a connection object via DriverManager ------
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		
		
		
		/** 
		 *  ********** 2. get statement, execute insert SQL **********
		 */
		
		// ------ Step 1: define a sql statement ------ 
		String sql = "delete from dept"; // you don't need semicolon !!!!
		System.out.println(sql);
		
		// ------ Step 2: get a statement ------ 
		Statement stat =  con.createStatement();
		
		// ------ Step 3: execureUpdate(insert,delete,update) ------ 
		int size = stat.executeUpdate(sql);
		// size: means how many rows of records you have affected. If you delete 5 records, then it returns 5; 
		
		/**
		 *  ********** 3. disconnect **********
		 */
		con.close();
	}
}



/**
 *  *** in the SQL end ***
 *  
 *  Create Table foo1(
 *     id         number(7) primary key,
 *     name       varchar2(20),
 *     birth_date date,
 *     login_time timestamp);
 *     
 *  Create sequence
 *     
 *     
 *     
 *     
 */

