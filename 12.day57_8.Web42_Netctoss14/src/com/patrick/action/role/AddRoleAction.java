package com.patrick.action.role;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.role.IRoleDAO;
import com.patrick.entity.Role;

public class AddRoleAction {

	private Role role;

	public String execute(){
		IRoleDAO dao = DAOFactory.getRoleDAO();
		try {
			dao.insert(role);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
		
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
