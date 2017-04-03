package day32.Demo01_DbUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			
			// real implementation
			String sql = "insert into foo1 (id,name,birth_date,login_time) "
					+ "values (foo1_pk.nextval,?,?,systimestamp) ";
			PreparedStatement pst = con.prepareStatement(sql);
			
			// specify ? parameter
			pst.setString(1, "patrick");
			pst.setDate(2, java.sql.Date.valueOf("1990-1-1"));
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			DbUtil.closeConnection(con);
		}
	}
}
