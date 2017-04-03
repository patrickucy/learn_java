package com.patrick.dao;

import java.util.List;

import com.patrick.entity.Cost;

public interface ICostDAO {

	public Integer count() throws DAOException;
	public void save(Cost cost) throws DAOException ;
	public void update(Cost cost) throws DAOException;
	public void delete(Cost cost) throws DAOException;
	public Cost findById(Integer id) throws DAOException;
	public List<Cost> findAll() throws DAOException;
	
}

