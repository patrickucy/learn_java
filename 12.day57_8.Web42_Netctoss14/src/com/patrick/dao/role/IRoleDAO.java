package com.patrick.dao.role;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.entity.Role;
import com.patrick.vo.RoleVO;

public interface IRoleDAO {

	/**
	 * Find role info
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	List<RoleVO> findByPage(int page, int pageSize) throws DAOException;

	/**
	 * you don't have to care about xml right now
	 * 
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	int findTotalPage(int pageSize) throws DAOException;
	
	
	void insert(Role role) throws DAOException;
	
	
	
	Role findById(int id) throws DAOException;
	
	
	
	void update(Role role) throws DAOException;
	
}



