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
		user.getVehicles().add(new Vehicle("Porsche"));
		user.getVehicles().add(new Vehicle("Mercedes-Benz"));
		user.getVehicles().add(new Vehicle("BMW"));
		user.getVehicles().add(new Vehicle("Audi"));
		
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHanle("Bike steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche steering wheel");
		

		
		
		
		
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); // begin to create table and insert data
		
		session.persist(user);
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		
		session.getTransaction().commit(); 
		session.close(); // 
		
		

		
		
		
		
	}
}
