package hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.FourWheeler;
import entity.TwoWheeler;
import entity.UserDetails;
import entity.Vehicle;

/**
 * query cache
 * second-level cache
 * 
 * @author patrickyu
 *
 */
public class HibernateTest {

	public static void main(String[] args) {

		
		
		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data	
		
		for( int i=0; i< 10; i++){
			UserDetails userInit = new UserDetails();
			userInit.setUserName("User_"+i);
			session.save(userInit);
		}

		Query query = session.createQuery("from UserDetails user where user.userId = 1");
		query.setCacheable(true);
		List<UserDetails> users = query.list();
		
		
		
		session.getTransaction().commit();
		session.close();
		

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		Query query2 = session2.createQuery("from UserDetails user where user.userId = 1");
		query2.setCacheable(true);
		List<UserDetails> users2 = query2.list();
		
		session2.getTransaction().commit();
		session2.close();
		
		
	}
}

























