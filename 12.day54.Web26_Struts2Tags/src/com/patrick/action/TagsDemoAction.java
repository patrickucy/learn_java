package com.patrick.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.patrick.entity.User;


/**
 * introducing struts2 tag technology
 * @author patrickyu
 *
 */
public class TagsDemoAction {

	private Integer id = 10;
	private String name = "patrick";
	
	private User user = new User();
		
	private List<String> cities = new ArrayList<String>();
	private String[] langs = {"java","c#","php","python","haskell","C++"};
	private Map<String,String> map = new HashMap<String,String>();
	
	
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

	public String execute(){
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

		
		return "success";
	}

	
}
