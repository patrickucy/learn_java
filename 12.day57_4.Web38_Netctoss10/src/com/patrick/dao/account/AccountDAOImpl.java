package com.patrick.dao.account;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.patrick.dao.DAOException;
import com.patrick.entity.Account;
import com.patrick.util.DBUtil;

public class AccountDAOImpl implements IAccountDAO {

	@Override
	public List<Account> findByCondition(
			String idcardNo, 
			String realName, 
			String loginName, 
			String status,
			int currentPage,
			int pageSize) throws DAOException {
		
		/**
		 * 定义存储参数值的集合, 在拼条件的同时记录其值, 
		 * 那么当所有的条件if都执行完以后, 条件中拼了几个?
		 * 那么集合中就存在几个值, 并且该集合中的数据是和?
		 * 的顺序一致,并且就是对应的?的取值
		 * 
		 * 这样就可以动态的拼过滤条件出来了
		 */
		List<Object> params = new ArrayList<Object>();
		
		StringBuffer stringbf = new StringBuffer();
		stringbf.append("select a.*, rownum r from account a where 1=1");
		if(idcardNo != null && idcardNo.length() > 0){
			stringbf.append("and idcard_no = ?");
			params.add(idcardNo);
		}
		if(realName != null && realName.length() > 0){
			stringbf.append("and real_name = ?");
			params.add(realName);
		}
		if(loginName !=null && loginName.length() >0 ){
			stringbf.append("and login_name = ?");	
			params.add(loginName);
		}
		if(status !=null && !status.equals("-1")){
			// 下拉选,默认空选项其value为-1, 空选项是不拼条件的
			stringbf.append("and status = ?");
			params.add(status);
		}
		
		
		String sql = " select * from (" + stringbf.toString() +") where r < ? and r > ?";
		params.add( currentPage*pageSize+1 );
		params.add( (currentPage-1)*pageSize );
		List<Account> list = new ArrayList<Account>();
		Connection con = DBUtil.getConnection();
		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i=0; i<params.size(); i++){
				/**
				 * 设置参数的下标(SQL)从1开始,而i是从0开始循环, 因此,这里传入i+1
				 */
				ps.setObject(i+1,params.get(i));	
			}
			ResultSet rs =  ps.executeQuery();
			while(rs.next()){
				Account a = createAccount(rs);
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find your records according you conditions providede", e);
		}
		
		return list;
	}
	
	private Account createAccount(ResultSet rs) throws SQLException{
		Account a = new Account();
		a.setId(rs.getInt("id"));
		/**
		 *  if you just write user getInt(), if this field is null. it will return 0, thus this "0" will
		 *  be passed to our dao, when writing a update code, this filed has a foreign key restriction. and
		 *  this 0 never exist in our database, then we will have a foreign key exception, this is why we alter
		 *  a little as bellow
		 */
		a.setRecommenderId(rs.getObject("recommender_id") == null? null: rs.getInt("recommender_id"));
		a.setLoginName(rs.getString("login_name"));
		a.setLoginPasswd(rs.getString("login_passwd"));
		a.setStatus(rs.getString("status"));
		a.setCreateDate(rs.getDate("create_date"));
		a.setPauseDate(rs.getDate("pause_date"));
		a.setCloseDate(rs.getDate("close_date"));
		a.setRealName(rs.getString("real_name"));
		a.setIdcardNo(rs.getString("idcard_no"));
		a.setBirthdate(rs.getDate("birthdate"));
		a.setGender(rs.getString("gender"));
		a.setOccupation(rs.getString("occupation"));
		a.setTelephone(rs.getString("telephone"));
		a.setEmail(rs.getString("email"));
		a.setMailaddress(rs.getString("mailaddress"));
		a.setZipcode(rs.getString("zipcode"));
		a.setQq(rs.getString("qq"));
		a.setLastLoginTime(rs.getDate("last_login_time"));
		a.setLastLoginIp(rs.getString("last_login_ip"));	
		return a;
	}
	
	
	

	@Override
	public int findTotalPage(String idcardNo, String realName,
			String loginName, String status, int pageSize) throws DAOException {
		
		List<Object> params = new ArrayList<Object>();
		
		StringBuffer stringbf = new StringBuffer();
		stringbf.append("select count(*) from account where 1=1");
		if(idcardNo != null && idcardNo.length() > 0){
			stringbf.append("and idcard_no = ?");
			params.add(idcardNo);
		}
		if(realName != null && realName.length() > 0){
			stringbf.append("and real_name = ?");
			params.add(realName);
		}
		if(loginName !=null && loginName.length() >0 ){
			stringbf.append("and login_name = ?");	
			params.add(loginName);
		}
		if(status !=null && !status.equals("-1")){
			// 下拉选,默认空选项其value为-1, 空选项是不拼条件的
			stringbf.append("and status = ?");
			params.add(status);
		}
		
		
		String sql = stringbf.toString();
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i+1, params.get(i));
			}
			ResultSet rs =  ps.executeQuery();
			if(rs.next()){
				int rows = rs.getInt(1);
				//  calculate total pages
				if(rows%pageSize == 0){
					return rows/pageSize;
				}else {
					return rows/pageSize+1;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
		
		
		return 0;
	}
	
	
	
	
	
	
	
	@Override
	public void start(int id) throws DAOException {
		String sql = "update account set status='0', pause_date=null where id=?";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DAOException("Fail to recover you data", e);
			}
			throw new DAOException("Fail to start an account", e);
		}finally {
			DBUtil.closeConnection();
		}
		
	}
	
	
	
	
	@Override
	public void insert(Account account) throws DAOException {
		
		if(account == null){
			return;
		}
		String sql = "insert into account values (account_seq.nextval,?,?,?,'0',sysdate, null, null,?,?,?,?,?,?,?,?,?,?,null,null)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			// prevent a null value, this is why using set object
			ps.setObject(1, account.getRecommenderId());
			ps.setObject(2, account.getLoginName());
			ps.setObject(3, account.getLoginPasswd());
			ps.setObject(4, account.getRealName());
			ps.setObject(5, account.getIdcardNo());
			ps.setObject(6, account.getBirthdate());
			ps.setObject(7, account.getGender());
			ps.setObject(8, account.getOccupation());
			ps.setObject(9, account.getTelephone());
			ps.setObject(10, account.getEmail());
			ps.setObject(11, account.getMailaddress());
			ps.setObject(12, account.getZipcode());
			ps.setObject(13, account.getQq());
			ps.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("Fail to add a new account", e);
		} finally {
			DBUtil.closeConnection();
		}
		
	}
	
	
	
	
	
	@Override
	public Account findByIdcardNo(String idcardNo) throws DAOException {
		if(idcardNo == null){
			return null;
		}
		
		String sql = "select * from account where idcard_no=?";
		
		Connection con = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, idcardNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Account acc = createAccount(rs);
				return acc;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find record by id card number", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	@Override
	public Account findById(int id) throws DAOException {
		String sql = "select * from account where id=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Account acc = createAccount(rs);
				if(acc.getRecommenderId() != null){
					String sql2= "select idcard_no from account where id=?";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, acc.getRecommenderId());
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()){
						String idcardNo = rs2.getString(1);
						acc.setRecommenderIdcardNo(idcardNo);
						
					}
				}
				
				return acc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail to find account record by id", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		
		return null;
	}
	
	
	
	@Override
	public void update(Account account) throws DAOException {
		if(account ==null) return;
		
		String sql = "update account set real_name=?,"
				+ "telephone=?, recommender_id=?,email=?,"
				+ " occupation=?,gender=?,mailaddress=?,"
				+ "zipcode=?,qq=?,login_passwd =? where id=?";
		
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, account.getRealName());
			ps.setObject(2, account.getTelephone());
			ps.setObject(3, account.getRecommenderId());
			ps.setObject(4, account.getEmail());
			ps.setObject(5, account.getOccupation());
			ps.setObject(6, account.getGender());
			ps.setObject(7, account.getMailaddress());
			ps.setObject(8, account.getZipcode());
			ps.setObject(9, account.getQq());
			ps.setObject(10, account.getLoginPasswd());
			ps.setObject(11, account.getId());
			ps.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new DAOException("Fail to modify your account !", e);
		} finally {
			DBUtil.closeConnection();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws DAOException {
		IAccountDAO dao = new AccountDAOImpl();
//		int page = 1;
//		int size = 5;
//		List<Account> accs = dao.findByCondition(null, null, null, null, page, size);
//		
//		for(Account acc : accs ){
//			System.out.println(acc);
//		}

//		System.out.println( dao.findTotalPage(null, null, null, null, size));
		
//		dao.start(1019);
		
//		Account a = new Account();
//
//		a.setRealName("ZhangSan");
//		a.setIdcardNo("42230110087");
//		a.setLoginName("aaa");
//		a.setLoginPasswd("123");
//		a.setBirthdate(Date.valueOf("2015-10-1"));
//		a.setGender("0");
//		a.setTelephone("911");
//		dao.insert(a);
		
		
		
//		Account acc = dao.findByIdcardNo("350581200201010322");
//		System.out.println(acc);
		
//		System.out.println( dao.findById(1011) +"\n" +dao.findById(1011).getRecommenderIdcardNo());
		Account a = dao.findById(1019);
		a.setRealName("zhubajie");
		a.setMailaddress("California");
		a.setLoginName("zbj");
		dao.update(a);
		
		
	}

	
		
}



















