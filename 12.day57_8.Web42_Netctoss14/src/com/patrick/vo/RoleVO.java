package com.patrick.vo;

import com.patrick.entity.Role;

public class RoleVO extends Role {
	
	private String modulesName;
	
	

	public String getModulesName() {
		return modulesName;
	}

	public void setModulesName(String modulesName) {
		this.modulesName = modulesName;
	}

	@Override
	public String toString() {
		return "RoleVO [modulesName=" + modulesName + "]";
	}
	

}
