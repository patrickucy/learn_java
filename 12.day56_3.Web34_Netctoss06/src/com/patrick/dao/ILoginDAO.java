package com.patrick.dao;

import com.patrick.entity.Administrator;

public interface ILoginDAO {

	/**
	 * verify administrator according to account 
	 * @param adminCode
	 * @return
	 * @throws DAOException
	 */
	Administrator fingByCode(String adminCode) throws DAOException;
}
