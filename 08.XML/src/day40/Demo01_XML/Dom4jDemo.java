package day40.Demo01_XML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jDemo {

	public static void test1() throws IOException {
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		// step 1: create a doc
		Document doc = DocumentHelper.createDocument();
		
		// step 2: design a Dom
		Element root = doc.addElement("point");
		Element xEle = root.addElement("x");
		Element yEle = root.addElement("y");
		xEle.setText(p.getX()+"");
		yEle.setText(p.getY()+"");
		
		// step 3: output
		FileOutputStream fos = new FileOutputStream("test.xml");
		
		// step 4: output with a format
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter out = new XMLWriter(fos,format);

		out.write(doc);
		fos.close();
		out.close();
		
	}
	
	
	public static void test2() throws IOException{
		Point2 p = new Point2();
		p.setX(10);
		p.setY(20);
		p.setType("common");
		
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("point");
		root.addElement("x").setText(p.getX()+"");
		root.addElement("y").setText(p.getY()+"");
		root.addAttribute("type", p.getType());
		
		FileOutputStream fos = new FileOutputStream("test2.xml");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter out = new XMLWriter(fos,format);

		out.write(doc);
		fos.close();
		out.close();	
	}
	
	public static void testOrder() throws IOException {
		Order order = new Order();
		order.setType("vip");
		order.setDest("Guangzhou");
		order.setFlight("JS1110");
		order.setName("patrick");
		order.setTime("2015-9-3-23-23");
		
		FileOutputStream fos = new FileOutputStream("testOrder.xml");
		OrderUtil.orderToXMl(order, fos);

	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		test1();
		test2();
		
		testOrder();
	}
}


















