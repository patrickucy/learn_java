package com.patrick.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.patrick.entity.Administrator;
import com.patrick.util.DBUtil;

public class LoginDAOImpl implements ILoginDAO {

	@Override
	public Administrator fingByCode(String adminCode) throws DAOException {
		
		if(adminCode == null) return null;
		
		Administrator admin = null;
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin_info where admin_code=?";
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, adminCode);
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				admin = createAdmin(rs);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find your account name",e);
			
		} finally {
			DBUtil.closeConnection();
		}
		
		
		return admin;
	}

	private Administrator createAdmin(ResultSet rs) throws SQLException {
		Administrator admin = new Administrator();
		admin.setId(rs.getInt("id"));
		admin.setAdminCode(rs.getString("admin_code"));
		admin.setPassword(rs.getString("password"));
		admin.setName(rs.getString("name"));
		admin.setTelephone(rs.getString("telephone"));
		admin.setEmail(rs.getString("email"));
		admin.setEnrollData(rs.getDate("enrolldate"));
		return admin;

	}

	public static void main(String[] args) throws Exception{
		ILoginDAO dao = new LoginDAOImpl();
		Administrator a = dao.fingByCode("admin");
		System.out.println(a);
	}
}
