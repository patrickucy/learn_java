package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * 
 * we can use joined(have foreign key to keep track, select * from vehicle join fourwheeler on ...) straty,
 * @author patrickyu
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)   // this annotation is not mandatory
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	

	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}
	public Vehicle() {
		super();
	}
	
	
	
}
