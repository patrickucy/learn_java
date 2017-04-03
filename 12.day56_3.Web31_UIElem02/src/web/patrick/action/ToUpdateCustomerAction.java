package web.patrick.action;

import java.util.List;

import web.patrick.dao.CustomerDAO;
import web.patrick.entity.City;
import web.patrick.entity.Customer;

public class ToUpdateCustomerAction {

	// output
	private Customer customer;
	private List<City> cities;

	public String execute(){
		CustomerDAO dao = new CustomerDAO();
		customer = dao.findByID();
		cities = dao.findCities();
		return "success";
		
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
