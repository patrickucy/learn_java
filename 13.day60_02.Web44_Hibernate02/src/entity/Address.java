package entity;

import javax.persistence.Embeddable;

@Embeddable // tells hibernate it's gonna be a component with an object
public class Address {

	private String street;
	private String city;
	private String state;
	private String zipcode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
