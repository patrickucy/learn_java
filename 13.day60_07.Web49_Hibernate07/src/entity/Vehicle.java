package entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   // this annotation is not mandatory
@DiscriminatorColumn(name="vehicle_type",discriminatorType=DiscriminatorType.STRING) // specify different class name with is annotation
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@NotFound (action=NotFoundAction.IGNORE)  // this is just a handy way to ignore exception
	private UserDetails user;
	
	
	
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
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}
	public Vehicle() {
		super();
	}
	
	
	
}
