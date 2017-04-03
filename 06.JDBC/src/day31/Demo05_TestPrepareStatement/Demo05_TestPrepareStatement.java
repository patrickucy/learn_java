package day31.Demo05_TestPrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05_TestPrepareStatement {

	public static void main(String[] args) {
		testAdd("scott","1995-5-5");
		testAdd("tiger","1996-6-6");
		testAdd("hl%%","1995-5-5");

	}
	
	
	public static void testAdd(String name, String birthday) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc.oracle:thin:@192.168.1.105:1521:patrickucy";
			con = DriverManager.getConnection(url,"system","Yy123123");
			String sql = "insert into foo1 "+
			             "(id, name,birth_date,login_time) " + 
                         "values (foo_pk.nextval,?,to_date(?,'yyyy-mm-dd'),systimestamp) ";

			System.out.println(sql);
			
			PreparedStatement pstat = con.prepareStatement(sql);
			
			// set values for those "?" parameter
			pstat.setString(1, name);  // 1 means the first "?" in SQL, SEE here, you mandatorily set name to be a String
			pstat.setString(2, birthday);
			
			// use this method without any parameter
			pstat.executeUpdate();
			
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
			String sql = "select * from where name like ? "; 
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, "%"+letter+"%");
			
			ResultSet rs = pstat.executeQuery();
			
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
}
