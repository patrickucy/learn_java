package com.patrick.action.role;

import java.util.List;

import com.patrick.entity.Privilege;
import com.patrick.util.PrivilegeReader;

public class ToAddRoleAction {

	// output
	private List<Privilege> privileges;

	public String execute(){
		
		privileges = PrivilegeReader.getModules();
		
		
		return "success";
	}
	
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
