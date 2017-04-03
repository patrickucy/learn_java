package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * every entity has their own table in database, embeddable class doesn't
 * own a table in database
 * @author patrickyu
 *
 */

@Entity
public class Boat {

	@Id @GeneratedValue
	private int boatId;
	private String boatName;
	
	@ManyToOne 
	@JoinColumn (name="user_id")
	private UserDetails user;
	
	
	
	
	public int getBoatId() {
		return boatId;
	}
	public void setBoatId(int boatId) {
		this.boatId = boatId;
	}
	public String getBoatName() {
		return boatName;
	}
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	public Boat(String boatName) {
		super();
		this.boatName = boatName;
	}
	public Boat() {
		super();
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
}

