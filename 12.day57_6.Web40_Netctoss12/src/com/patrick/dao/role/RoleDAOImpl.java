package com.patrick.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.entity.Role;
import com.patrick.util.DBUtil;
import com.patrick.util.PrivilegeReader;
import com.patrick.vo.RoleVO;

public class RoleDAOImpl implements IRoleDAO {

	@Override
	public List<RoleVO> findByPage(int page, int pageSize) throws DAOException {
		List<RoleVO> list = new ArrayList<RoleVO>();
		
		Connection con = DBUtil.getConnection();
		
		// 1. find role in one page
		String sql = " select *  from ( "
				+ "select r.*, rownum rn from role r) "
				+ "where rn < ? and rn > ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, page*pageSize +1);
			ps.setInt(2, (page-1)*pageSize);
			ResultSet rs =  ps.executeQuery();
			
			// 2. enumerate roles
			while(rs.next()){
				RoleVO vo = new RoleVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				
				// 3. find its corresponding privilege id
				String sql2 = "select privilege_id from role_privilege where role_id= ? ";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, vo.getId());
				ResultSet rs2 =  ps2.executeQuery();
				
				String nameStr = "";
				while(rs2.next()){
					int privilgeId = rs2.getInt("privilege_id");
					
					// 4. find module names for that privilege id
					String pname = PrivilegeReader.getModuleNameById(String.valueOf(privilgeId));
					
					// 5. append modules names to a string for this role
					nameStr += "," + pname;
						
				}
				if(nameStr.length() > 0 ){
					nameStr = nameStr.replaceFirst(",","");
					
				}	
				
				vo.setModulesName(nameStr);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find role info ", e);
		} finally {
			
			DBUtil.closeConnection();
		}
		
		return list;
	}
	
	@Override
	public int findTotalPage(int pageSize) throws DAOException {
		// TODO findTotalPage method in roleDaoImpl
		return 0;
	}
	
	
	@Override
	public void insert(Role role) throws DAOException {

		if(role == null){
			return;
		}
		
		// add new role
		Connection con = DBUtil.getConnection();
		String sql = "insert into role values(role_seq.nextval,?) ";

		try {
			con.setAutoCommit(false);
			String[] columns = {"id"}; // define return field from our database
			PreparedStatement ps = con.prepareStatement(sql,columns);
			
			/**
			 * mysql is slightly different, it is as follow
			 * PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			 */
			
			ps.setString(1, role.getName());
			ps.executeUpdate();
			
			// get id for new role, the result at the first column,is the defined return column
			ResultSet rs =  ps.getGeneratedKeys();
			Integer roleId = null;
			if(rs.next()){
				roleId = rs.getInt(1);
				
			}
			
			// insert to intermedia table
			List<String> privilegesIds = role.getPrivilegeIds();
			if(privilegesIds !=null && privilegesIds.size() >0){
				String sql2 = "insert into role_privilege values(?,?) ";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				for(String privilegeId : privilegesIds){
					ps2.setInt(1, roleId);
					ps2.setInt(2, Integer.valueOf(privilegeId));
					ps2.addBatch();
				}
				ps2.executeBatch();
			}
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("Fail to add new role ", e);
		} finally {
			DBUtil.closeConnection();
		}

	}
	
	
	
	public static void main(String[] args) throws Exception {
		IRoleDAO dao = new RoleDAOImpl();
		
//		List<RoleVO> vos = dao.findByPage(2, 2);
//		for( RoleVO vo : vos ){
//			System.out.println(vo);
//		}
		
		
		Role r = new Role();
		r.setName("aaa");
		List<String> pids = new ArrayList<String>();
		pids.add("6");
		pids.add("7");
		r.setPrivilegeIds(pids);
		dao.insert(r);
	}
	
}
