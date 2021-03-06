package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Address;
import entity.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
//		UserDetails user1 = new UserDetails();
//		user1.setUserName("First User");
//		user1.setHomeAddress(new Address("Delaeare", "San francisco", "CA", "05050"));
//		user1.setOfficeAddress(new Address("water", "los angels", "CA", "04020"));
//		user1.setJoinedDate(new Date());
//		user1.setDescription("Description for First user");
//		
//		UserDetails user2 = new UserDetails();
//		user2.setUserName("Second User");
//		user2.setHomeAddress(new Address("Yosemite", "Pheniex", "AR", "23451"));
//		user2.setOfficeAddress(new Address("porter", "Los vagas", "AR", "99922"));
//		user2.setJoinedDate(new Date());
//		user2.setDescription("Description for second user");
//		
//		UserDetails user3 = new UserDetails();
//		user3.setUserName("third User");
//		user3.setHomeAddress(new Address("Gum", "Huston", "TX", "55720"));
//		user3.setOfficeAddress(new Address("Frost", "Austin", "TX", "3490"));
//		user3.setJoinedDate(new Date());
//		user3.setDescription("Description for third user");
		
		
		UserDetails user = new UserDetails();
		user.setUserName("test");
		user.getListOfAddresses().add(new Address("Delaeare", "San francisco", "CA", "05050"));
		user.getListOfAddresses().add(new Address("water", "los angels", "CA", "04020"));
		user.getListOfAddresses().add(new Address("Yosemite", "Pheniex", "AR", "23451"));
		user.getListOfAddresses().add(new Address("porter", "Los vagas", "AR", "99922"));
		user.getListOfAddresses().add(new Address("Gum", "Huston", "TX", "55720"));
		user.getListOfAddresses().add(new Address("Frost", "Austin", "TX", "3490"));

	
		
		
		
		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		session.save(user);
		session.getTransaction().commit(); 
		session.close(); // 
		
		
		
		UserDetails queriedUser1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		queriedUser1 = (UserDetails) session.get(UserDetails.class, 1); //  
		System.out.println("the record just retrived: "+queriedUser1);
		
		
	}
}
