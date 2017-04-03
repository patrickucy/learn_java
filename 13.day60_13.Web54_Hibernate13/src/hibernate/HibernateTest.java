package hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
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
		
		
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		/**
		 * the default restriction is logic "AND"
		 * the third line shows how to do "OR"
		 */
		criteria.add(Restrictions.like("userName", "%User%"))
				.add(Restrictions.between("userId", 5,9))			
				.add(Restrictions.or(Restrictions.like("userName", "%User%"), Restrictions.between("userId", 5,9)));
		

		
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		
		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : users){
			System.out.println(user);			
		}
	}
}

























