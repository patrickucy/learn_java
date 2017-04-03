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
	
	
	
	
	
	
	@Override
	public List<Cost> findByPage(int currentPage, int pageSize) throws DAOException {
		List<Cost> list = new ArrayList<Cost>();
		
		Connection con = DBUtil.getConnection();
		String sql = "select * from( select c.*, rownum r from cost c where rownum < ?) where r > ?";
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, currentPage*pageSize +1);
			pstat.setInt(2, (currentPage-1)*pageSize);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Cost c = createCost(rs);
				list.add(c);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to fetch data by page from database", e);
		} finally{
			DBUtil.closeConnection();
		}
			
		return list;
	}
	
	
	
	
	

	@Override
	public int findTotalPages(int pageSize) throws DAOException {
		Connection con = DBUtil.getConnection();
		String sql = "select count(*) from cost";
		int count = 0;
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs =  pstat.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(count%pageSize == 0){
			return count/pageSize;
		}else{
			return count/pageSize +1;
		}
		
	}

	
	
	/**
	 * you got a problem here with the database side
	 */
	@Override
	public void delete(int id) throws DAOException {
		Connection con = DBUtil.getConnection();
		String sql = "delete from cost where id=?";
		try {
			con.setAutoCommit(false);
			PreparedStatement pstat = con.prepareStatement(sql);
			
			pstat.setInt(1, id);
			pstat.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DAOException("Fail to rallback your data", e);
			}
			throw new DAOException("Fail to delete this records", e);
		} finally {
			DBUtil.closeConnection();
		}
		
				
	}
	
	
	
	
	
	
	

	@Override
	public void insert(Cost cost) throws DAOException {
		if(cost == null) return;
		
		Connection con = DBUtil.getConnection();
		String sql ="insert into cost values(cost_seq.nextval,?,?,?,?,'0',?,SYSDATE,null,?)";
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			/**
			 * !!!!!
			 * later if you want to set a number, please use setObject, because it can prevent
			 * the case that we get a null number
			 * 
			 * in short, user setObject for all setNumber()
			 */
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DAOException("Fail to rallback you data", e);
			}
			throw new DAOException("Fail to add new cost data", e);
		}
	}
	
	
	
	

	@Override
	public Cost findByName(String name) throws DAOException {
		if(name == null)return null;
		
		Connection con = DBUtil.getConnection();
		String sql = "select * from cost where name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Cost cost = createCost(rs);
				return cost;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find cost according to your provided name", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}

	public static void main(String[] args) throws DAOException {
		ICostDAO dao = new CostDAOImpl();
//		List<Cost> list = dao.findByPage(2, 2);
//		System.out.println(list);
//		System.out.println(dao.findTotalPages(5));
		
//		Cost c = new Cost();
//		c.setName("aaa");
//		c.setBaseDuration(50);
//		c.setBaseCost(5.00);
//		c.setUnitCost(0.1);
//		c.setStatus("1");
//		c.setDescr("AAAA");
//		c.setCostType("3");
//		dao.insert(c);
		
		System.out.println(dao.findByName("aaa"));
		
				
	}

}
