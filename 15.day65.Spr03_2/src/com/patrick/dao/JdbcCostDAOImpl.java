package com.patrick.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.patrick.entity.Cost;
import com.patrick.entity.CostMapper;


@Repository
public class JdbcCostDAOImpl extends JdbcDaoSupport implements ICostDAO {
	

	public JdbcCostDAOImpl() {
		System.out.println("JdbcCostDAOImpl()...");
	}

	/**
	 *  接受注入DataSource对象,然后给DaoSupport传入, 为DaoSupport的template对象提供Connection资源,
	 *  不要尝试去override那个接口方法,试过了都没用
	 * @param dataSource
	 */
	@Resource
	public void setMytDataSource(javax.sql.DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	
	@Override
	public void delete(Cost cost) throws DAOException {
		JdbcTemplate template = super.getJdbcTemplate();
		String sql = "delete from COST where id = ? ";
		Object[] params = {cost.getId()};
		template.update(sql, params);
	}

	@Override
	public List<Cost> findAll() throws DAOException {
		String sql = "select * from COST";
		List<Cost> listOfCost = super.getJdbcTemplate().query(sql, new CostMapper());
		return listOfCost;
	}
	
	@Override
	public Cost findById(Integer id) throws DAOException {
		JdbcTemplate template = super.getJdbcTemplate();
		String sql = "select * from COST where id = ? ";
		Object[] params = {id};
		Cost cost =  template.queryForObject(sql, params, new CostMapper());
		return cost;
	}
	
	@Override
	public void save(Cost cost) throws DAOException {
		
		String sql ="insert into cost values(cost_seq.nextval,?,?,?,?,'0',?,SYSDATE,null,?)";
		Object[] params = {cost.getName(),cost.getBaseDuration(),cost.getBaseCost(),cost.getUnitCost(),cost.getDescr(),cost.getDescr()};
		super.getJdbcTemplate().update(sql,params);
		
		
	}
	@Override
	public void update(Cost cost) throws DAOException {
		String sql = "update cost set name=?,base_duration=?,base_cost=?, unit_cost=?,cost_type=?,descr=? where id=?";
		Object[] params = {
				cost.getName(),
				cost.getBaseDuration(),
				cost.getBaseCost(),
				cost.getUnitCost(),
				cost.getCostType(),
				cost.getDescr(),
				cost.getId()
		};
		super.getJdbcTemplate().update(sql,params);
		
	}


	@Override
	public Integer count() throws DAOException {
		try{
			String sql = "select count(1) from COST "; // more efficient to use count(1) than count(*)
			Integer count = super.getJdbcTemplate().queryForInt(sql);	
			return count;
		}catch(DataAccessException e){
			throw new DAOException("Fail to access database", e);
		}
		
	}











	
	
}
