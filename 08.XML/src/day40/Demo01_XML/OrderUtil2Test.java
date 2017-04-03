package day40.Demo01_XML;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.junit.Test;

public class OrderUtil2Test {

	@Test
	public void testListToXml() throws IOException {
		List<Order> orders = new ArrayList<Order>();
		
		Order order = new Order();
		order.setType("vip");
		order.setDest("Guangzhou");
		order.setFlight("JS1110");
		order.setName("patrick");
		order.setTime("2015-9-3-23-23");
		
		Order order2 = new Order();
		order2.setType("com");
		order2.setDest("Beijing");
		order2.setFlight("BJ9012");
		order2.setName("Android");
		order2.setTime("2015-9-10-11-20");
		
		orders.add(order);
		orders.add(order2);
		
		FileOutputStream fos = new FileOutputStream("testOrders.xml");
		OrderUtil2.listToXml(orders, fos);
		
		
	}
	@Test
	public void testXmlToList() throws FileNotFoundException, DocumentException {
		FileInputStream fis = new FileInputStream("testOrders.xml");
		System.out.println(OrderUtil2.xmlToList(fis));
	}

}
