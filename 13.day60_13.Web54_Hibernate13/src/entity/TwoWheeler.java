package entity;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

	private String steeringHanle;

	public String getSteeringHanle() {
		return steeringHanle;
	}

	public void setSteeringHanle(String steeringHanle) {
		this.steeringHanle = steeringHanle;
	}
	
}
