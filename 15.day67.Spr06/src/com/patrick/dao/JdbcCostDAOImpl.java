package com.patrick.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.patrick.entity.Cost;

/**
 * dao 里面不会有变量属性,因为,会发生线程安全问题
 * @author patrickyu
 *
 */

@Repository
@Scope
public class JdbcCostDAOImpl implements ICostDAO {

	
	@Override
	public void add(Cost cost) {
		
		System.out.println("Using JDBC Cost DAO ...");
	}
	
	@Override
	public List<Cost> find(String name, String desc) {
		String sql = "select * from cost where 1=1 ";

		if(name != null && !"".equals(name)){
			sql += "and name = ? ";
		}
		if(desc != null && !"".equals(desc)){
			sql += "and desc = ? ";
		}

		System.out.println(sql);	
		return null;
	}
	
	
	@Override
	public void delete(Cost cost) {
		System.out.println("Using JDBC Cost DAO ...");

	}


	

}
