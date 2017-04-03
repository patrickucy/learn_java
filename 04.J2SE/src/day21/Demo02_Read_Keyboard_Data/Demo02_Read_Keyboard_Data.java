package day21.Demo02_Read_Keyboard_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * read keyboard data
 * just like scanner
 * 
 * @author patrickyu
 *
 */
public class Demo02_Read_Keyboard_Data {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/**
		 *  what is "system.in" ?
		 *  just a byte inputStream from keyboard
		 *  
		 *  
		 *  what is "FileInputStream" ?
		 *  just a byte inputSteam from a file
		 *  
		 *  
		 *  they are all byte InputStream, just have different data source
		 */
		InputStream in = System.in;
		
		
		/**
		 * convert it into char stream
		 */
		InputStreamReader reader = new InputStreamReader(in);
		
		BufferedReader br = new BufferedReader(reader);
		
		String str = null;
		
		
		while (true) {
			str = br.readLine();
			if ("exit".equals(str)) {
				System.out.println("goodbye~");
				break;
			}
			System.out.println("you just type in: "+ str);
		}
		
		
		/**
		 * you can use the code above to write a Scanner to collect use keyboard input
		 */
		
	}

}
