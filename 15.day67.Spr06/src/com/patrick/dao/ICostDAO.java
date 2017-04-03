package com.patrick.dao;

import java.util.List;

import com.patrick.entity.Cost;



public interface ICostDAO {

	public void add(Cost cost);
	public List<Cost> find(String name, String desc);
	public void delete(Cost cost);
}
