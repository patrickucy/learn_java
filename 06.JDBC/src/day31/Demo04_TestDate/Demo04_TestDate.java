package day31.Demo04_TestDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04_TestDate {

	public static void main(String[] args) {
		testAdd("scott","1995-5-5");
		testAdd("tiger","1996-6-6"); // imagine you pass a sun'ny here as the first parameter

		testFind("m");
		
		testFind1("'tom' or '1' = '1'"); // this will always return all records
	}
	
	
	public static void testAdd(String name, String birthday) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc.oracle:thin:@192.168.1.105:1521:patrickucy";
			con = DriverManager.getConnection(url,"system","Yy123123");
			// execute SQL, add a space at every segment of SQL statement, be extra cautous about SQL 
			String sql = "insert into foo1 "+
			             "(id, name,birth_date,login_time) " + 
                         "values (foo_pk.nextval,'"+name+"',to_date('"+birthday+"','yyyy-mm-dd'),systimestamp) ";
			/**
			 *  sometimes you might waste the "foo_pk.nextval". Let's say you insert a wrong record
			 */
			System.out.println(sql);
			
			Statement stat = con.createStatement();
			stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e2){
			e2.printStackTrace();
			System.out.println("Driver loading error");
		} finally {
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static void testFind(String letter){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDiver");
			String url = "jdbc:oracle:thin:@192.168.1.100:1521:patrickucy";
			con = DriverManager.getConnection(url,"system","Yy123123");
			String sql = "select * from where name like '%"+letter+"%'"; // don't contain any "%" in "letter"
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()){ // it will move its own pointer
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				java.sql.Date birth = rs.getDate("BIRTH_DATE");
				java.sql.Timestamp time =  rs.getTimestamp("LOGIN_TIME");
				
				System.out.println(id+" "+name+" "+birth+" "+time);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con!=null){
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	
	
	public static void testFind1(String name){
		String sql = "select * from foo1 Where name="+name;
	                 
	}
}


/**
* 
*
*
*
*/