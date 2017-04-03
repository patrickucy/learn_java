package day40.Demo01_XML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 * private String type;  // vim, com, vvip
	private String name;
	private String flight;
	private String time;
	private String dest;
 * @author patrickyu
 *
 */

public class OrderUtil {

	public static void orderToXMl(Order order,OutputStream ops) throws IOException{
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("order");
		root.addAttribute("type", order.getType());
		root.addElement("name").setText(order.getName());
		root.addElement("flight").setText(order.getFlight());
		root.addElement("time").setText(order.getTime());
		root.addElement("dest").setText(order.getDest());
	
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter out = new XMLWriter(ops,format);

		out.write(doc);
		out.close();	
	}
	
	
	public static Order xmlToOrder(InputStream ips) throws DocumentException{
		Order o = null;
		// step 1: construct a dom tree here
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(ips);
		
		// step 2: access nodes in this dom tree
		Element root = doc.getRootElement();
		String name = root.element("name").getText();
		name = root.elementText("name"); // same as the line above
		
		String flight = root.elementText("flight");
		String time = root.elementText("time");
		String dest = root.elementText("dest");
		
		String type =root.attribute("type").getValue();
		type = root.attributeValue("type"); // same as the line above 
		o = new Order();
		o.setDest(dest);
		o.setFlight(flight);
		o.setType(type);
		o.setName(name);
		o.setTime(time);
		
		return o;
		
	}
}













