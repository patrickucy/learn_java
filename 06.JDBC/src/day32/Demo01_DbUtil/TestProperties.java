package day32.Demo01_DbUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	// Class c = Person.class; // you can know what is in this Person class;
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();

		/** 
		 * read the file under ClassPath and return a InputStream. 
		 * (you put db.properties file under the package, not the main directory)
		 * The benefit of using this method is that it will only read file under the directory "src" - relative file path
		 */
		InputStream is = TestProperties.class.getClassLoader().getResourceAsStream(""
				+ ""
				+ ""); 
		// sometimes people use    this.getClassLoader().getResourceAsStream();


		props.load(is);
		// pass Key and get Value 
		String url = props.getProperty("url");
		
		System.out.println(url);
		
		String driver = props.getProperty("driver");
		System.out.println(driver);
	}
}
