package web.patrick.dao;

import java.util.ArrayList;
import java.util.List;


import web.patrick.entity.City;
import web.patrick.entity.Customer;

/**
 * similuate a dao here
 * @author patrickyu
 *
 */
public class CustomerDAO {

	
	
	public Customer findByID(){
		Customer c = new Customer();
		c.setName("patrick");
		c.setPassword("1234");
		c.setDesc("citizen of people's republic of china");
		c.setMarry(false);
		c.setSex("M");
		c.setHome("guangzhou");
		c.setLoveCity("shenzhen");
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("guangzhou");
		c.setTravelCities(list);
		return c;
	}
	
	public List<City> findCities(){
		List<City> list = new ArrayList<City>();
		City c1 = new City("北京", "beijing");
		list.add(c1);
		City c2 = new City("上海", "shanghai");
		list.add(c2);
		City c3 = new City("广州", "guangzhou");
		list.add(c3);
		City c4 = new City("深圳", "shenzhen");
		list.add(c4);
		City c5 = new City("杭州", "hangzhou");
		list.add(c5);
		return list;
	}
}
