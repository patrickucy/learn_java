package day40.Demo01_XML;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.Test;

public class OrderUtilTest {

	@Test
	public void testOrderToXMl() throws IOException {
		Order order = new Order();
		order.setType("vip");
		order.setDest("Guangzhou");
		order.setFlight("JS1110");
		order.setName("patrick");
		order.setTime("2015-9-3-23-23");
		
		FileOutputStream fos = new FileOutputStream("testOrder.xml");
		OrderUtil.orderToXMl(order, fos);
	}
	
	@Test
	public void testXmlToOrder() throws FileNotFoundException, DocumentException{
		FileInputStream fis = new FileInputStream("testOrder.xml");
		Order o = OrderUtil.xmlToOrder(fis);
		System.out.println(o);
	}

}
