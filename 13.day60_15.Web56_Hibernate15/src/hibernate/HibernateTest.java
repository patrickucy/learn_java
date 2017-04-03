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
 * Cache
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

				
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Update user");
		/**
		 * hibernate will notice in fact you are fetching the exactly same object here.
		 */
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
		
		
		session.getTransaction().commit();
		session.close();
		System.out.println(user);
		
		
		
		/**
		 * if the session you close previously, the cache will also be closed.
		 * this is why the following session will start a new query 
		 */
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails user3 = (UserDetails) session2.get(UserDetails.class, 1);
		
		
		session2.getTransaction().commit();
		session2.close();
		
		
	}
}

























