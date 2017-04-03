package com.patrick.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.patrick.entity.Cost;
import com.patrick.util.DBUtil;

public class CostDAOImpl implements ICostDAO {

	@Override
	public List<Cost> findAll() throws DAOException {
		List<Cost> list = new ArrayList<Cost>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from cost";
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Cost c = createCost(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Fail to query all cost data!", e);
		} finally{
			DBUtil.closeConnection();
		}
		
		return list;
	}

	private Cost createCost(ResultSet rs) throws SQLException {
		Cost c = new Cost();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreateTime(rs.getDate("creatime"));
		c.setStartTime(rs.getDate("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
	
	public static void main(String[] args) throws DAOException {
		ICostDAO dao = new CostDAOImpl();
		List<Cost> list = dao.findAll();
		System.out.println(list);
	}

}
