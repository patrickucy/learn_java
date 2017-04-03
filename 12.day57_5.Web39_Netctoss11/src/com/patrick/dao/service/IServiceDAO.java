package com.patrick.dao.service;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.entity.Service;
import com.patrick.vo.ServiceVO;

public interface IServiceDAO {

	/**
	 * 
	 * @param osUserName
	 * @param unixHost
	 * @param idcardNo
	 * @param status
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	List<ServiceVO> findByCondition(String osUserName, String unixHost, String idcardNo, String status,int page, int pageSize) throws DAOException;
	
	
	
	int findTotalPage(String osUserName, String unixHost, String idcardNo, String status, int pageSize) throws DAOException;
	
	void pause(int id) throws DAOException;
	
	List<Service> findByAccountId(int accountId) throws DAOException;
	
}
