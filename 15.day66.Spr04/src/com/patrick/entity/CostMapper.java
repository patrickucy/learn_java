package com.patrick.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CostMapper implements RowMapper<Cost> {

	@Override // 将rs当前游标的记录转换成实体对象
	public Cost mapRow(ResultSet rs, int index) throws SQLException {
		Cost c = new Cost();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreateTime(rs.getDate("creatime"));
		c.setStartTime(rs.getDate("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
}
