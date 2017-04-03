package com.patrick.entity;

import java.util.List;

public class Role {

	private Integer id;
	private String name;
	
	// selected module id
	private List<String> privilegeIds;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(List<String> privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
