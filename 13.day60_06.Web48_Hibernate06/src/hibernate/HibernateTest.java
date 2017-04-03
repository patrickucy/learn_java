package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Address;
import entity.Boat;
import entity.RentalCar;
import entity.UserDetails;
import entity.Vehicle;

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
		user.setUserName("test username");
		
		// 1->1
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Ford fusion");
		
		
		Boat boat1 = new Boat("Titanic");
		Boat boat2 = new Boat("Aurora");
		Boat boat3 = new Boat("Atlantica");
		 
		// 1->x
		user.setVehicle(vehicle);
		user.getBoats().add(boat1);
		user.getBoats().add(boat2);
		user.getBoats().add(boat3);
		boat1.setUser(user);
		boat2.setUser(user);
		boat3.setUser(user);
		
		
		// x->x
		UserDetails user1 = new UserDetails();
		user1.setUserName("First");
		UserDetails user2 = new UserDetails();
		user2.setUserName("second");
		UserDetails user3 = new UserDetails();
		user3.setUserName("thrid");
		
		RentalCar rentalCar1 = new RentalCar();
		rentalCar1.setRentalCarName("Mercedes-Benz");
		RentalCar rentalCar2 = new RentalCar();
		rentalCar2.setRentalCarName("BMW");
		RentalCar rentalCar3 = new RentalCar();
		rentalCar3.setRentalCarName("Porshce");
		
		user1.getRetalCars().add(rentalCar1);
		user1.getRetalCars().add(rentalCar2);
		
		user2.getRetalCars().add(rentalCar2);
		user2.getRetalCars().add(rentalCar3);
		
		user3.getRetalCars().add(rentalCar1);
		user3.getRetalCars().add(rentalCar3);
		
		rentalCar1.getUsers().add(user1);
		rentalCar1.getUsers().add(user3);
		
		rentalCar2.getUsers().add(user1);
		rentalCar2.getUsers().add(user2);
		
		rentalCar3.getUsers().add(user2);
		rentalCar3.getUsers().add(user3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		session.save(user);
		session.save(vehicle);
		session.save(boat1);
		session.save(boat2);
		session.save(boat3);
		session.getTransaction().commit(); 
		session.close(); // 
		
		

		
		
		
		
	}
}
