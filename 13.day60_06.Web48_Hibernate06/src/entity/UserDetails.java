package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity (name="user_details")
//@Table (name="user_details")  // this is a table alone
public class UserDetails {

	@Id
	@Column (name="user_id")
	@GeneratedValue (strategy=GenerationType.AUTO)   	
	private int userId; // treat this as primary key
	private String userName;
	
	
	@OneToOne
	@JoinColumn (name="vehicle_id")
	private Vehicle vehicle;
	
	
	@OneToMany (mappedBy="user")
	private Collection<Boat> boats = new ArrayList<Boat>();
	
	
	@ManyToMany
	private Collection<RentalCar> retalCars = new ArrayList<RentalCar>();
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Collection<Boat> getBoats() {
		return boats;
	}
	public void setBoats(Collection<Boat> boats) {
		this.boats = boats;
	}
	public Collection<RentalCar> getRetalCars() {
		return retalCars;
	}
	public void setRetalCars(Collection<RentalCar> retalCars) {
		this.retalCars = retalCars;
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
