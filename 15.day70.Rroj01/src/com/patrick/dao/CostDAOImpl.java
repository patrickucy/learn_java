package com.patrick.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.patrick.entity.Cost;
import com.patrick.entity.CostMapper;

/**
 * 企业里面的开发,是不会去继承的,而是通过下面这种注入的方式
 * @author patrickyu
 *
 */

@Repository
public class CostDAOImpl implements ICostDAO {
	
	private HibernateTemplate hibernateTemplate;
	public void setSessionFactory(SessionFactory sessionFactory){
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	
	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Cost> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cost findByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cost findByName(String name) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Cost> findByPage(final int currentPage, final int pageSize)
			throws DAOException {
		// 分页: spring整合Hibernate, 必须使用回调
		// 调用Hibernate中的Session对象, 使用Hibernate的分页
		//  spring对Hibernate分页没有很好进行整合
		// 回调基本上就是为了用Session
		
		return (List<Cost>) hibernateTemplate.executeFind(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				final String hql = "from Cost";
				// FirstResult: 放入本页的第一条数据,下标从0开始
				return session.createQuery(hql).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}
	@Override
	public int findTotalPages(int pageSize) throws DAOException {
		String hql = "select count(*) from Cost";
		long totalSize = (Long) hibernateTemplate.find(hql).get(0);
		// find: 返回值, 是list, 如果只有一个结果的话,必须使用 
		// get(0): 获得当前第一个元素
		// 返回结果是Object, 可以强制转化为一个long类型,
		// long类型可以自动转转化数据long
		if(totalSize%pageSize == 0){
			return (int)totalSize/pageSize;
		}else{
			return (int)totalSize/pageSize + 1;
		}
	}
	@Override
	public void insert(Cost cost) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Cost cost) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	











	
	
}
