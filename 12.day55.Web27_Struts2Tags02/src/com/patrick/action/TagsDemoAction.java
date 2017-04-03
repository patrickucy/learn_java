package com.patrick.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.patrick.entity.User;


/**
 * introducing struts2 tag technology
 * @author patrickyu
 *
 */
public class TagsDemoAction implements SessionAware {

	private Integer id = 10;
	private String name = "patrick";
	
	private User user = new User();
		
	private List<String> cities = new ArrayList<String>();
	private String[] langs = {"java","c#","php","python","haskell","C++"};
	private Map<String,String> map = new HashMap<String,String>();
	
	
	private List<User> users = new ArrayList<User>();
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String[] getLangs() {
		return langs;
	}

	public void setLangs(String[] langs) {
		this.langs = langs;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public TagsDemoAction() {
		
		System.out.println("instantiating action...");
	}

	public String execute(){
		System.out.println("action execute() ...");
		user.setUsername("patrickyu");
		user.setPassword("12345");
		
		// init collection
		cities.add("beijing");
		cities.add("shanghai");
		cities.add("guangzhou");
		
		
		// init map
		map.put("aaa", "AAA");
		map.put("bbb", "BBB");
		map.put("ccc", "CCC");

		
		//init users
		User u1 = new User();
		u1.setUsername("WangDaChui");
		u1.setPassword("123");
		users.add(u1);
		
		User u2 = new User();
		u2.setUsername("LibaoKu");
		u2.setPassword("abc");
		users.add(u2);
		
		// how to get session object
		// 1. ActionContext
		Map<String,Object> session1 =  ActionContext.getContext().getSession();
		
		// 2. ServletActionContext get Session
		HttpSession session2 = ServletActionContext.getRequest().getSession();
		
		// 3. inject to interface to get session
		// just down below
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		session1.put("aaa", "AAA");
		System.out.println(session1.get("aaa"));
		System.out.println(session2.getAttribute("aaa"));
		System.out.println(session3.get("aaa"));
		
		
		
		return "success";
	}

	private Map<String,Object> session3;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		
		session3 = arg0;
		System.out.println("injecting session via interface...");
	}

	
}
