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
		
		for( int i=0; i< 10; i++){
			UserDetails userInit = new UserDetails();
			userInit.setUserName("User_"+i);
			session.save(userInit);
		}
		
		UserDetails user =(UserDetails) session.get(UserDetails.class, 1);		
		
		
		session.getTransaction().commit(); 
		session.close(); 
		
		
		user.setUserName("Updated username after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		user.setUserName("Change again after update");
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}
}
