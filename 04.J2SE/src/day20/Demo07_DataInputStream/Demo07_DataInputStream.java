package day20.Demo07_DataInputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * DataInputStream
 * 
 * usually used to transfer primitive data type
 * 
 * using high-level IOStream in multiple layers!!!!!!
 * 
 * @author patrickyu
 *
 */
public class Demo07_DataInputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("data.txt"); 		// raw
		BufferedInputStream bis = new BufferedInputStream(fis); 	// package(raw) -> provide Buffer
		DataInputStream dis = new DataInputStream(bis); 			// morePackage( package(raw) )
		
		int i = dis.readInt();
		double d = dis.readDouble();
		String str = dis.readUTF();
		
		
		/**
		 * byte -> data 	(de-serialization)
		 * 
		 */
		System.out.println(i);
		System.out.println(d);
		System.out.println(str);
		dis.close();
	}

}
