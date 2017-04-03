package com.patrick.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Results;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.entity.Administrator;
import com.patrick.util.DBUtil;
import com.patrick.vo.AdminVO;

public class AdminDAOImpl implements IAdminDAO {

	
	@Override
	public List<AdminVO> findByCondition(Integer roleId, Integer privilegeId,int page, int pageSize) throws DAOException {
		List<Object> params = new ArrayList<Object>();
		
		StringBuffer sb = new StringBuffer();
		// outer query
		sb.append("select * from ( ");
		sb.append("  select ai.*, rownum r from admin_info ai ");
		sb.append("  where 1=1");
		// first condition
		if(roleId != null){
			sb.append("  and id in( ");
			sb.append("    select admin_id from admin_role ar ");
			sb.append("    inner join role ri on ri.id = ar.role_id ");
			sb.append("    where ri.id = ? ");
			sb.append("  ) ");
			params.add(roleId);
		}
		
		if(privilegeId != null){
			// second condition 
			sb.append("  and id in( ");
			sb.append("    select admin_id from admin_role ar ");
			sb.append("    inner join role ri on ri.id = ar.role_id ");
			sb.append("    inner join role_privilege rp on ri.id = rp.role_id ");
			sb.append("    where rp.privilege_id = ? ");
			sb.append("  ) ");
			params.add(privilegeId);
		}
		// in page format
		sb.append(") where r < ? and r > ? ");
		params.add(page*pageSize+1);
		params.add((page-1)*pageSize);
		
		Connection con = DBUtil.getConnection();
		List<AdminVO> vos = new ArrayList<AdminVO>();
		try {
			PreparedStatement ps = con.prepareStatement(sb.toString());
			for(int i = 0; i<params.size(); i++){
				ps.setObject(i+1, params.get(i));
			}
			ResultSet rs =  ps.executeQuery();
			while(rs.next()){
				AdminVO adminvo = createAdminVO(rs);
				// query its role
				String sql2 = "select name from role "
						+ "where id in( "
						+ "  select role_id from admin_role "
						+ "  where admin_id = ? "
						+ ") ";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, adminvo.getId());
				ResultSet rs2 = ps2.executeQuery();
				String nameStr = "";
				while(rs2.next()){
					String name = rs2.getString(1);
					nameStr +=","+name;
				}
				if(nameStr.length() > 0){
					nameStr = nameStr.replaceFirst(",","");
				}
				adminvo.setRolesName(nameStr);
				vos.add(adminvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find administrator !", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		
		return vos;
	}
	
	
	
	private AdminVO createAdminVO(ResultSet rs) throws SQLException {
		AdminVO adminvo = new AdminVO();
		adminvo.setId(rs.getInt("id"));
		adminvo.setAdminCode(rs.getString("admin_code"));
		adminvo.setPassword(rs.getString("password"));
		adminvo.setName(rs.getString("name"));
		adminvo.setTelephone(rs.getString("telephone"));
		adminvo.setEmail(rs.getString("email"));
		adminvo.setEnrollData(rs.getDate("enrolldate"));
		return adminvo;

	}
	
	
	
	
	
	
	
	@Override
	public void resetPasswords(String[] ids) throws DAOException {
		if(ids == null){
			return;
		}
		
		String sql = "update admin_info set password = '123456' "
				+ "where id in( "
				+ "";
		for(int i = 0; i< ids.length; i++){
			if(i == 0) 
				sql += "?";
			else 
				sql += ",?";
		}
		sql += ")";
		
		
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			
			for(int i = 0; i < ids.length ; i++){
				ps.setObject(i+1, ids[i]);
			}
			
			ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOException("Fail to reset your passwords", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		
	}
	
	public static void main(String[] args) throws DAOException {
		IAdminDAO dao = new AdminDAOImpl();
//		List<AdminVO> vos = dao.findByCondition(null, null, 1, 5);
//		for(AdminVO vo : vos){
//			System.out.println(vo);
//		}
		
		String[] ids = new String[]{"2000","3000"};
		dao.resetPasswords(ids);
		
	}
}
