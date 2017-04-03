package com.patrick.dao.account;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.entity.Account;

public interface IAccountDAO {

	/**
	 * find records according condition provided
	 * @param idcardNo
	 * @param realName
	 * @param loginName
	 * @param status
	 * @return
	 * @throws DAOException
	 */
	List<Account> findByCondition(String idcardNo,String realName, String loginName, String status,int currentPage,int pageSize) throws DAOException; 
	
	int findTotalPage(String idcardNo,String realName, String loginName, String status, int pageSize) throws DAOException;
	
	/**
	 * start an account
	 * @param id
	 * @throws DAOException
	 */
	void start(int id) throws DAOException;
	
	
	/**
	 * add a new account
	 * @param account
	 * @throws DAOException
	 */
	void insert(Account account) throws DAOException;
	
	
	/**
	 * find record according to idcard number
	 * @param idcardNo
	 * @return
	 * @throws DAOException
	 */
	Account findByIdcardNo(String idcardNo) throws DAOException;
	
	
	Account findById(int id) throws DAOException;
	
	
	/**
	 * modify account 
	 * @param account
	 * @throws DAOException
	 */
	void update(Account account) throws DAOException;
	
	
	
	void pause(int id) throws DAOException;
}
