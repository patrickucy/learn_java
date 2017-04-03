package com.patrick.action.role;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.role.IRoleDAO;
import com.patrick.entity.Privilege;
import com.patrick.entity.Role;
import com.patrick.util.PrivilegeReader;

public class ToUpdateRoleAction {

	//input
	private int id;
	private Role role;
	
	// to initialize check box list options
	private List<Privilege> privileges;
	
	
	public String execute(){
		IRoleDAO dao = DAOFactory.getRoleDAO();
		try {
			role = dao.findById(id);
			privileges = PrivilegeReader.getModules();
			
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}



	public List<Privilege> getPrivileges() {
		return privileges;
	}



	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}


	
	
	
}
