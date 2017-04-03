package day31.Demo02_TestSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02_TestSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. connect
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc.oracle:thin:@192.168.1.100:1521:patrickucy";
		Connection con = DriverManager.getConnection(url,"system","Yy123123");


		// 2. get statement
		String sql = "select * from dept order by deptno";
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(sql);


		// 3. get resultSet 
		// a. ResultSet will return a structure with multiple rows and columns according to your SQL
		// b. There is a pointer in ResultSet, and you can return the object with this pointer pointing to it
		// c. In default, the ResultSet has the pointer pointing above its first record.
		// d. use rs.next() to move the pointer to the first record

		// just like iterator here, rs.next() will return false if it reaches the end, normally it turns true
		while ( rs.next() ){
			int no = rs.getInt("DEPTNO"); // the parameter is the name of that column
			String name = rs.getString("DEPTNAME");
			System.out.println("Number: "+ no +" Name: "+ name);
		}
		// 4. disconnect
		con.close();
	}
}
