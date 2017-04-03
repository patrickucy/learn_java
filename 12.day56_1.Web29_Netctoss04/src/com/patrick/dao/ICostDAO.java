package com.patrick.dao;

import java.util.List;

import com.patrick.entity.Cost;

/**
 * DAO interface for fee module
 * @author patrickyu
 *
 */
public interface ICostDAO {

	/**
	 * find all records
	 * @return
	 * @throws DAOException
	 */
	List<Cost> findAll() throws DAOException;
	
	/**
	 * query records by page
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	List<Cost> findByPage(int currentPage,int pageSize) throws DAOException;
	
	/**
	 * get the total amount of records and calculate to get how many pages
	 * 1. row/pageSize can be divided? return rows/pageSize
	 * 2. or when we have remains 
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	int findTotalPages(int pageSize) throws DAOException;
	
	
	
	/**
	 * delete a record according to its id
	 * @param id
	 * @throws DAOException
	 */
	void delete(int id) throws DAOException;
	
	/**
	 * add a new cost data
	 * @param cost
	 * @throws DAOException
	 */
	void insert(Cost cost) throws DAOException;
	
	
	/**
	 * find cost by its name 
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	Cost findByName(String name) throws DAOException;
}
