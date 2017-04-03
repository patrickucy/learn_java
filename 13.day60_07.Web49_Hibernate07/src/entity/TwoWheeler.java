package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike") // basically it just change the name in our database
public class TwoWheeler extends Vehicle {

	private String steeringHanle;

	public String getSteeringHanle() {
		return steeringHanle;
	}

	public void setSteeringHanle(String steeringHanle) {
		this.steeringHanle = steeringHanle;
	}
	
}
