package day19.Demo06_RAF_Continue_from_ContentEnd;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Add more content to an existing file 
 * 
 * @author patrickyu
 *
 */
public class Demo06_RAF_Continue_from_ContentEnd  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		raf.seek(file.length()); // continue writing at the end of this file
		raf.writeUTF("hello");
		raf.close();
	}

}
