package day40.Demo01_XML;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.SAXResult;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class OrderUtil2 {
	
	public static void listToXml(List<Order> orders, OutputStream ops) throws IOException{
		Document doc = DocumentHelper.createDocument();
		
		Element root = doc.addElement("orders");

		for(Order order : orders){
			Element orderEle = root.addElement("order");
			orderEle.addAttribute("type", order.getType());
			orderEle.addElement("name").setText(order.getName());
			orderEle.addElement("flight").setText(order.getFlight());
			orderEle.addElement("time").setText(order.getTime());
			orderEle.addElement("dest").setText(order.getDest());
		}
		
	
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter out = new XMLWriter(ops,format);

		out.write(doc);
		out.close();
	}
	
	public static List<Order> xmlToList(InputStream ips) throws DocumentException{
		List<Order> orders = new ArrayList<Order>();
		SAXReader saxRdr = new SAXReader();
		Document doc = saxRdr.read(ips);
		Element root = doc.getRootElement();
		
//		Element orderEle = root.element("order"); // get only the first element

		List<Element> orderEles = root.elements("order");
		for(Element e : orderEles){
			String name = e.elementText("name"); // same as the line above		
			String flight = e.elementText("flight");
			String time = e.elementText("time");
			String dest = e.elementText("dest");
			
			String type = e.attribute("type").getValue();
			Order o = new Order();
			o.setDest(dest);
			o.setFlight(flight);
			o.setType(type);
			o.setName(name);
			o.setTime(time);
			
			orders.add(o);
		}
		
		
		return orders;
	}
}
