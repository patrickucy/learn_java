package com.patrick.dao;

import java.util.List;

import com.patrick.entity.Cost;

/**
 * DAO interface for fee module
 * @author patrickyu
 *
 */
public interface ICostDAO {

	List<Cost> findAll() throws DAOException;
}
