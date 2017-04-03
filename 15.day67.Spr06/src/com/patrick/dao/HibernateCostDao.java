package com.patrick.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.patrick.entity.Cost;


@Repository
@Scope
public class HibernateCostDao extends HibernateDaoSupport implements ICostDAO {

	@Resource // 接收注入的SessionFactory对象给daoSupport
	public void setFactory(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	
	@Override
	public void add(Cost cost) {
		super.getHibernateTemplate().save(cost);
		
	}

	@Override
	public List<Cost> find(String name, String desc) {
		String hql = "from Cost where name = ? and descr = ?";
		Object[] params = {name, desc};
		List<Cost> list = (List<Cost>) super.getHibernateTemplate().find(hql,params);
		return list;
	}

	@Override
	public void delete(Cost cost) {
		super.getHibernateTemplate().delete(cost);
	}

}
