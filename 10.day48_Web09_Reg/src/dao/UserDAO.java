package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.User;

public class UserDAO {

	public User findByUsername(String username) throws Exception{

		User user = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("select * from t_user where username=?");
			stat.setString(1, username);
			rst = stat.executeQuery();
			
			if(rst.next()){
				user = new User();
				user.setUsername(username);
				user.setPwd(rst.getString("pwd"));
				user.setName(rst.getString("name"));
				user.setId((rst.getInt("id")));
				user.setGender(rst.getString("gender"));
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if(rst!=null){
				rst.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
			DBUtil.close(conn);

		}
		
		
		return user;
	}
	
	public void addUser(User user) throws Exception{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("insert into t_user(username,pwd,name,gender) values(?,?,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPwd());
			stat.setString(3, user.getName());
			stat.setString(4, user.getGender());
			stat.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			
		} finally {

			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
			DBUtil.close(conn);
		}
	}
	
	
}
