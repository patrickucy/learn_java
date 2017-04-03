package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * first para: encoding use utf8
			 * second para: decoding using utf8
			 */
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patrickdb?"
					+ "useUnicode=true&characterEncoding=utf8", "root","1234");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
	}
}
