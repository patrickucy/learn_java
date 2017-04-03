package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserId(1);
		user1.setUserName("First User");
		user1.setAddress("california");
		user1.setJoinedDate(new Date());
		user1.setDescription("Description for First user");
		
		UserDetails user2 = new UserDetails();
		user2.setUserId(2);
		user2.setUserName("Second User");
		user2.setAddress("Arizona");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description for second user");
		
		UserDetails user3 = new UserDetails();
		user3.setUserId(3);
		user3.setUserName("First User");
		user3.setAddress("texas");
		user3.setJoinedDate(new Date());
		user3.setDescription("Description for third user");
		
		/**
		 * session object is very expensive, just use the factory to get it, and
		 * user over and over again, just don't create your own session 
		 */
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.getTransaction().commit(); 
		session.close(); // 
		
		
		UserDetails queriedUser1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		/**
		 * get the id=1 from db,and we have specify the @id, in fact this is a "select" sql.
		 * this id is in fact the primary key
		 * 
		 */
		queriedUser1 = (UserDetails) session.get(UserDetails.class, 1); //  
		System.out.println("the record just retrived: "+queriedUser1);
		
		
	}
}
