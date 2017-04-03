package hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.FourWheeler;
import entity.TwoWheeler;
import entity.UserDetails;
import entity.Vehicle;

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
		 *  #1. -------------------------------------------------------------------------------
		 */
		// Query query = session.createQuery("from UserDetails where userId > 5"); // HQL use object name and property name
		
//		Query query = session.createQuery("from UserDetails"); // this is a list of strings 
//		/**
//		 * how you to do pagination
//		 */
//		query.setFirstResult(0); 
//		query.setMaxResults(4);
//		List<UserDetails> users = (List<UserDetails>) query.list();
//				
//		session.getTransaction().commit();
//		session.close();
//		
//		for(UserDetails user: users){
//			System.out.println(user);		
//		}
		
		
		
		/**
		 *  #2. -------------------------------------------------------------------------------
		 */
		/**
		 * this time it is a list of String 
		 */
//		Query query = session.createQuery("select userName from UserDetails");
//		// Query query = session.createQuery("select new map(userId, userName) from UserDetails");		
//		// Query query = session.createQuery("select max(userId) from UserDetails");
//
//
//		/**
//		 * how you to do pagination
//		 */
//		query.setFirstResult(0); 
//		query.setMaxResults(4);
//		List<String> userNames = (List<String>) query.list();
//				
//		session.getTransaction().commit();
//		session.close();
//		
//		for(String userName: userNames){
//			System.out.println(userName);		
//		}
		
		
		
		
		/**
		 *  #3. -------------------------------------------------------------------------------
		 */
		int minUserId = 5;
		
//		Query query = session.createQuery("from UserDetails where userId > ?");
//		query.setInteger(0, Integer.valueOf(minUserId)); // start with 0, just like the PrepareStatement
		
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName ");
		query.setInteger("userId", Integer.valueOf(minUserId));
		query.setString("userName", "User_8");
		
		
		List<UserDetails> users = (List<UserDetails>) query.list();
				
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(users);		
		}
	}
}

























