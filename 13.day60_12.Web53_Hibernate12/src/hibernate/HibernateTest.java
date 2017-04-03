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
		
		
		Query query = session.getNamedQuery("UserDetails.byId");
		// Query query = session.getNamedQuery("UserDetails.byName");
		// query.setString(0,"User_8");

		query.setInteger(0, 4);
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : users){
			System.out.println(user);			
		}
	}
}

























