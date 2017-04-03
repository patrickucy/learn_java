package day40.Demo01_XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathDemo {
	
	public static void test1() throws FileNotFoundException, DocumentException{
		
		// 1. find by root
		SAXReader saxRdr = new SAXReader();
		FileInputStream fis = new FileInputStream("testOrders.xml");
		Document doc = saxRdr.read(fis);
		List<Element> elements = doc.selectNodes("/orders/order/time");
		for(Element e : elements){
//			System.out.println(e.getText());
		}
		
		
		// 2. find by index. begin with 1
		List<Element> elements2 = doc.selectNodes("/orders/order[1]/time");
		for(Element e : elements2){
//			System.out.println(e.getText());
		}
		
		// 3. find by attribute value
		List<Element> elements3 = doc.selectNodes("/orders/order[@type='vip']/name");
		for(Element e : elements3){
//			System.out.println(e.getText());
		}
		
		// 4. find randomly
		List<Element> elements4 = doc.selectNodes("//name");  // return all "name"s for you automatically
		for(Element e : elements4){
//			System.out.println(e.getText());
		}
		
		// 5. find nodes under certain condition
		List<Element> elements5 = doc.selectNodes("/orders/order[dest='Guangzhou']/time");  // return all "name"s for you automatically
		for(Element e : elements5){
			System.out.println(e.getText());
		}
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException  {
		// TODO Auto-generated method stub

		test1();
	
	}

}
