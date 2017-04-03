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

		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		
		
		/**
		 *  data init
		 */
//		for(int i=0; i<10; i++){
//			UserDetails user = new UserDetails();
//			user.setUserName("User_"+i);
//			session.save(user);
//		}
		
		
		/**
		 * delete
		 */
		UserDetails user =  (UserDetails) session.get(UserDetails.class, 6);
		// session.delete(object);  
		
		
		/**
		 * update
		 */
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 8);
		user1.setUserName("updated user");
		session.update(user1);
		
		
		session.getTransaction().commit(); 
		session.close(); 
		


		
		

		
		
		
		
	}
}
