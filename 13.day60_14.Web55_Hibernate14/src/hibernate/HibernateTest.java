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
 * criteria  API
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

				
		/**
		 * projects ----------------------------------------------------
		 */
//		Criteria criteria = session.createCriteria(UserDetails.class)
//							.setProjection(Projections.property("userId"))
//							.addOrder(Order.asc("userId"));
//		
		
		/**
		 * query by example
		 */
		
		UserDetails exampleUser = new UserDetails();
		
		/**
		 * hibernate will ignore null and primary when it comes to example object
		 */
		exampleUser.setUserId(5);
//		exampleUser.setUserName("User_5");
//		Example example = Example.create(exampleUser).excludeProperty("userName");
		
		exampleUser.setUserName("User_1%");
		Example example = Example.create(exampleUser).enableLike();

		
		Criteria criteria = session.createCriteria(UserDetails.class)
				.add(example);
		
		

		
		List<Object> users = (List<Object>) criteria.list();
		
		
		session.getTransaction().commit();
		session.close();
		for(Object user : users){
			System.out.println(user);			
		}
	}
}

























