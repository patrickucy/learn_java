package com.patrick.dao;

import org.springframework.dao.DataAccessException;

public class DAOException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String message, Throwable cause) {
        super(message, cause);
        
        
    }
}
