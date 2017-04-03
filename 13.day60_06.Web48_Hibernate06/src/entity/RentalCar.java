package entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RentalCar {

	@Id
	@GeneratedValue
	private int rentalCarId;
	private String rentalCarName;
	
	
	/**
	 * once we declare mapped by here, manyToMany map will not generate two different relationship
	 * table
	 * 
	 * this mapped by value is from the userDetail
	 * in terms of ManyToMany you just need to declare one of the mapped by
	 * Thus, we will have just one mapping table
	 */
	@ManyToMany (mappedBy="retalCars")  
	private Collection<UserDetails> users = new ArrayList<UserDetails>();

	
	
	
	
	
	public int getRentalCarId() {
		return rentalCarId;
	}

	public void setRentalCarId(int rentalCarId) {
		this.rentalCarId = rentalCarId;
	}

	public String getRentalCarName() {
		return rentalCarName;
	}

	public void setRentalCarName(String rentalCarName) {
		this.rentalCarName = rentalCarName;
	}

	public Collection<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}

	
	
	

	
}
