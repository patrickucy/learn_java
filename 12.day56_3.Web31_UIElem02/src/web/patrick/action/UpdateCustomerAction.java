package web.patrick.action;

import web.patrick.entity.Customer;

public class UpdateCustomerAction {

	// input 
	private Customer customer;

	public String execute(){
		System.out.println(customer);
		
		return "success";
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
