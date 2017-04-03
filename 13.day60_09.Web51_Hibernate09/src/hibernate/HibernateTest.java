package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.FourWheeler;
import entity.TwoWheeler;
import entity.UserDetails;
import entity.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		
		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		
		/**
		 * if you don't do this process, hibernate will not save this data to db for you
		 * thus it will be a transient object, if you save it. then it will be a persisted 
		 * object
		 */
		session.save(user);
		
		user.setUserName("1 Another tested user");
		user.setUserName("2 Another tested user");
		user.setUserName("3 Another tested user");
		user.setUserName("4 Another tested user");

		/**
		 * hibernate will update this change for us automatically; what if you have multiple 
		 * modifications here? in fact the hibernate will only save the last operation to database.
		 * it will not do every alteration while you modifying the object
		 */
		user.setUserName("last Another tested user");
		
		session.getTransaction().commit(); 
		session.close(); 
		


		/*
		 *  once close, it it will be a detached object, it was persisted before, now it is no longer it.
		 *  right now it just the same as transient object
		 */
		user.setUserName("After session close test user");
		

		
		
		
		
	}
}
