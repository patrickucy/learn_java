package com.patrick.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.util.DBUtil;
import com.patrick.vo.ServiceVO;


public class ServiceDAOImpl implements IServiceDAO {
	
	@Override
	public List<ServiceVO> findByCondition(String osUserName, String unixHost,
			String idcardNo, String status, int page, int pageSize)
			throws DAOException {
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from ( ");
		sb.append("		select s.*, a.idcard_no, a.real_name, c.name, c.descr, rownum r from service s ");
		sb.append("		inner join account a on s.account_id=a.id ");
		sb.append("		inner join cost c on s.cost_id= c.id ");
		sb.append("		where 1=1 ");
		if(osUserName != null && osUserName.length() > 0 ){
			sb.append("		and s.os_username = ? ");
			params.add(osUserName);
		}
		if(unixHost != null && unixHost.length() > 0){
			sb.append("		and s.unix_host = ?  ");	
			params.add(unixHost);
		}
		if(idcardNo != null && idcardNo.length() > 0){
			sb.append("		and a.idcard_no = ? ");
			params.add(idcardNo);
		}
		if(status != null && !status.equals("-1")){
			sb.append("		and s.status = ? ");
			params.add(status);
		}
		sb.append(") where r < ? and r > ? ");
		params.add( page*pageSize+1 );
		params.add( (page-1)*pageSize );
		
		String sql = sb.toString();
		
		List<ServiceVO> list = new ArrayList<ServiceVO>();
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i+1, params.get(i));
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ServiceVO vo = createServiceVO(rs);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find service with given conditions", e);
			
		} finally {
			DBUtil.closeConnection();	
		}
		return list;
	}
	
	private ServiceVO createServiceVO(ResultSet rs) throws SQLException{
		ServiceVO vo = new ServiceVO();
		vo.setId(rs.getInt("id"));
		vo.setAccountId(rs.getInt("account_id"));
		vo.setUnixHost(rs.getString("unix_host"));
		vo.setOsUserName(rs.getString("os_username"));
		vo.setLoginPassword(rs.getString("login_passwd"));
		vo.setStatus(rs.getString("status"));
		vo.setCreateDate(rs.getDate("create_date"));
		vo.setCloseDate(rs.getDate("close_date"));
		vo.setCostId(rs.getInt("cost_id"));
		vo.setIdcardNo(rs.getString("idcard_no"));
		vo.setRealName(rs.getString("real_name"));
		vo.setCostName(rs.getString("name"));
		vo.setCostDescr(rs.getString("descr"));
		
		return vo;	
	}
	
	
	
	
	@Override
	public int findTotalPage(String osUserName, String unixHost,
			String idcardNo, String status, int pageSize) throws DAOException {
		// TODO Auto-generated method stub
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("		select count(*) from service s ");
		sb.append("		inner join account a on s.account_id=a.id ");
		sb.append("		inner join cost c on s.cost_id= c.id ");
		sb.append("		where 1=1 ");
		if(osUserName != null && osUserName.length() > 0 ){
			sb.append("		and s.os_username = ? ");
			params.add(osUserName);
		}
		if(unixHost != null && unixHost.length() > 0){
			sb.append("		and s.unix_host = ?  ");	
			params.add(unixHost);
		}
		if(idcardNo != null && idcardNo.length() > 0){
			sb.append("		and a.idcard_no = ? ");
			params.add(idcardNo);
		}
		if(status != null && !status.equals("-1")){
			sb.append("		and s.status = ? ");
			params.add(status);
		}
		
		
		String sql = sb.toString();
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i+1, params.get(i));	
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int rows = rs.getInt(1);
				if(rows%pageSize == 0){
					return  rows / pageSize;
				}else {
					return rows / pageSize +1;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find the total page of service", e);
		} finally {
			DBUtil.closeConnection();
			
		}
		
		
		
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("--start--");
		IServiceDAO dao = new ServiceDAOImpl();
		try {
			List<ServiceVO> list  =  dao.findByCondition(null, null, null, null, 2, 5);
			for(ServiceVO vo : list){
				System.out.println(vo);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(dao.findTotalPage(null, null, null, null, 5));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--end--");
	}

}
