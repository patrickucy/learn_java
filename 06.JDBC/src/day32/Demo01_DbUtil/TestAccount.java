package day32.Demo01_DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestAccount {

	public static void main(String[] args) {
		boolean ok = change(1001, 1002, 200);
		if(ok){
			System.out.println("transfer succeeded !");
		}else{
			System.out.println("transfer failed !");
		}
	}
	
	public static boolean change(int formID, int toID, double money){
		Connection con = null;
		
		try {
			con = DbUtil.getConnection();
			// shut down auto commit  (TCL Application)
			con.setAutoCommit(false);
			
			// receiving money
			String sql = "update d_account set money=money+? where id=?";
			
			// transfering money
			String sql1 = "update d_account set money=money-? where id=?";
			
			// execute SQL
			// from user
			PreparedStatement pstat =  con.prepareStatement(sql);
			pstat.setDouble(1, money);
			pstat.setInt(2, formID);
			int i = pstat.executeUpdate();
			
			// to user
			PreparedStatement pstat1 = con.prepareStatement(sql1);
			pstat1.setDouble(1, money);
			pstat1.setInt(2, toID);
			int j = pstat1.executeUpdate();
			
			// commit transaction   (TCL Application)
			if(i==1 && j==1){
				con.commit();
				return true;
			} else {
				con.rollback(); // roll back to last "committed point"
				return false;
			}
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally{
			DbUtil.closeConnection(con); // this line of code will always be executed after return
		}
	}
}
