package com.patrick.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.patrick.entity.Cost;

@Repository
public class HibernateCostDAOImpl extends HibernateDaoSupport implements ICostDAO {

	@Resource
	public void setMySessionFactory(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	
	@Override
	public Integer count() throws DAOException {
		String hql = "select count(1) from Cost ";
		Integer count = Integer.parseInt( super.getHibernateTemplate().find(hql).get(0).toString());	
		return count;
	}
	
	@Override
	public void delete(Cost cost) throws DAOException {
		super.getHibernateTemplate().delete(cost);
	}
	
	@Override
	public List<Cost> findAll() throws DAOException {
		String hql = "from Cost";
		List<Cost> list =  super.getHibernateTemplate().find(hql);
		return list;
	}
	
	@Override
	public Cost findById(Integer id) throws DAOException {
		Cost cost = super.getHibernateTemplate().get(Cost.class, id);
		return cost;
	}
	
	@Override
	public void save(Cost cost) throws DAOException {
		super.getHibernateTemplate().save(cost);
		
	}
	
	@Override
	public void update(Cost cost) throws DAOException {
		super.getHibernateTemplate().update(cost);
	}
	
	public List<Cost> findPage(int page, int pageSize) throws DAOException{
		Session session = super.getSession();
		Query query = (Query) session.createQuery("from Cost");
		int begin = (page-1)*pageSize;
		int end = pageSize*page + 1;
		query.setFirstResult(begin);
		query.setMaxResults(end);
		session.close(); // 因为你手动进来了,所以需要你手关一下
		return query.list();
		
	}
	
	public List<Cost> findPage2(final int page, final int pageSize){ // 最好用template,因为可以自动的管理Session的关闭
		List list =  (List) super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				// template 自动管理关闭Session的操作,而且还支持lazy initialization
				Query query = (Query) session.createQuery("from Cost");
				int begin = (page-1)*pageSize;
				int end = pageSize*page + 1;
				query.setFirstResult(begin);
				query.setMaxResults(end);
				return query.list();
			}
		});
		return list;
	}
}
