package com.patrick.dao.cost;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.patrick.dao.DAOException;
import com.patrick.entity.Cost;

@Repository
public class HibernateCostDaoImpl extends HibernateDaoSupport implements ICostDAO {

	@Resource // 将Spring容器中的SessionFactory给注入进来
	public void setMySessionFactory(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	
	@Override
	public List<Cost> findAll() throws DAOException {
		String hql = "from Cost";
		List list =  super.getHibernateTemplate().find(hql);
		return list;
	}

//	@Override
//	public List<Cost> findByPage(int currentPage, int pageSize)
//			throws DAOException {
//		
//		// hibernate 对分页查询的封装并不好
//		Session session =  super.getSession();
//		String hql = "from Cost ";
//		
//		Query query = session.createQuery(hql);
//		int begin = (currentPage-1)*pageSize;
//		query.setFirstResult(begin);
//		query.setMaxResults(pageSize);
//		List list = query.list();
//		session.close();
//		
//		return list;
//	}
	
	@Override
	public List<Cost> findByPage(final int currentPage,final int pageSize)
			throws DAOException {
		
		// 这种方式就不需要你去手动的关闭Session了,template自动关闭(推荐这个)
		List list = (List) super.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from Cost ";
				
				Query query = session.createQuery(hql);
				int begin = (currentPage-1)*pageSize;
				query.setFirstResult(begin);
				query.setMaxResults(pageSize);
				List<Cost> list = (List<Cost>) query.list();
				return list;
			}
		});
		
		
		return list;
	}
	
	
	

	@Transactional //spring 事务
	@Override
	public int findTotalPages(int pageSize) throws DAOException {
		String hql = "select count(*) from Cost";
		List list = super.getHibernateTemplate().find(hql);
		int rows = Integer.valueOf(list.get(0).toString());
		// 根据总记录数计算最大页
		if( rows %pageSize == 0){
			return rows/pageSize;
		}else {
			return rows/pageSize + 1;
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Cost cost) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cost findByName(String name) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cost findByID(int id) throws DAOException {	
		return super.getHibernateTemplate().load(Cost.class, id);
	}

	@Override
	public void update(Cost cost) throws DAOException {
		super.getHibernateTemplate().update(cost);
	}

	
}
