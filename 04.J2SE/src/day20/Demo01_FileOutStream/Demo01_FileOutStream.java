package day20.Demo01_FileOutStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutStream
 * this is a byte stream, and it's a low-level stream
 * it is very boring, and all it does just a couple write methods
 * but this is the fundamental theory of all data transferring
 *  
 * @author patrickyu
 *
 */
public class Demo01_FileOutStream {

	public static void main(String[] args) throws IOException {
		/**
		 * create a file to manipulate
		 */
		File file = new File("fos.txt");
		// create a fos 
//		FileOutputStream fos = new FileOutputStream(file); 		// write data from start
//		FileOutputStream fos = new FileOutputStream(file,true);	// append more data, 
		FileOutputStream fos = new FileOutputStream("."+File.separator+"fos1.txt",true); // give it a filePath
		
		
		/**
		 *  sometimes you might a problem that the file path didn't create when you are trying 
		 *  to write data to a file path, so it's better to use File file = new File("xxxx") to 
		 *  make sure that path is really available
		 */
		
		
		/**
		 * using fos write data
		 */
		fos.write('A'); // write 1 byte, just like before
		fos.write('b');
		
		/**
		 * fos doesn't support writing a int value directly
		 * if you want to write an int value, then you have to do it 4 times
		 * you have to write the corresponding byte every single time
		 */
		int max = Integer.MAX_VALUE;
		fos.write(max>>24);
		fos.write(max>>16);
		fos.write(max>>8);
		fos.write(max);
		
		
		/**
		 * ROS doesn't support index! 
		 */

		fos.close();
	}
}
