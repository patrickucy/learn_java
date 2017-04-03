package com.patrick.dao.admin;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.vo.AdminVO;

public interface IAdminDAO {

	
	List<AdminVO> findByCondition(Integer roleId, Integer privilegeId, int page, int pageSize) throws DAOException;
	
}
