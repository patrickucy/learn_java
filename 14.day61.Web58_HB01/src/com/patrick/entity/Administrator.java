package com.patrick.entity;

import java.util.HashSet;
import java.util.Set;

public class Administrator {

	private Integer id;
	private String adminCode;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private java.sql.Date enrollData;
	
	private Set<Role> roles = new HashSet<Role>();
	
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", adminCode=" + adminCode
				+ ", password=" + password + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrollData=" + enrollData
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.sql.Date getEnrollData() {
		return enrollData;
	}
	public void setEnrollData(java.sql.Date enrollData) {
		this.enrollData = enrollData;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
