package day32.Demo01_DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBatch {

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		testPrepareStatement();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		
		
		testStatement();
	}
	
	public static void testPrepareStatement(){
		Connection con = null;
		try {
			// insert 1K records as a batch, and these 1k transaction is consider as one transaction
			con = DbUtil.getConnection();
			// shut down auto commit
			con.setAutoCommit(false);
			
			String sql = "insert into d_account "+
						"(id, name, money) values (?,?,?) ";
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			for (int i = 0; i < 1000; i++) {
				pst.setInt(1, i);
				pst.setString(2, "scott"+i);
				pst.setDouble(3, i+1000);
				// put all these into a batch
				pst.addBatch();
				
				// collect 20 batches and execute. Bigger i doesn't mean better
				if(i%20 == 0){
					pst.executeBatch();
				}
				pst.executeBatch();
			}
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DbUtil.closeConnection(con);
		}
	}
	
	
	public static void testStatement(){
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			Statement stat = con.createStatement();
			int size = 0;
			for(int i = 1008; i<2008; i++){
				String sql = "insert into d_account (id, name, money) values ("+i+",'tom',1000.0) ";
				//put sql to batch
				stat.addBatch(sql);
				size++;
				if(size%20 == 0){
					stat.executeBatch();
				}
				// if you don't have 20 batches at the end of this process
				stat.executeBatch();
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DbUtil.closeConnection(con);
		}
	}
}
