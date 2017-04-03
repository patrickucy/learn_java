package day19.Demo04_RandomAccessFile_Read_String;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * techniques to Read string
 * @author patrickyu
 * 
 * read data
 */
public class Reader {

	public static void main(String[] args) throws Exception {
		File file = new File("testStr.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		
		int dataLength = raf.readInt();
		byte[] data = new byte[dataLength];
		
		
		/**
		 * this d the return value tells you how many data actually have been read!
		 * let's say here you declare 123 length, but you might just receive 5
		 * 
		 * int read(byte[] d0
		 * program try to read 128 bytes here, and return those newly read data to you via an array,
		 * the return value here in fact is telling you how much of data you actually read
		 * attention:
		 * in fact, after the method is done. elements from index [0] to the return value(here is d)
		 * are valid elements
		 */
		int d = raf.read(data); 
		System.out.println(d);	
		String str = new String(data,"utf-8");
		System.out.println(str);
		
		
		/**
		 * having the length of a string to read, then is's become very convenient to read those data back!
		 * 
		 */
		byte[] data2 = new byte[raf.readInt()];
		raf.read(data2);
		String str2 = new String(data2,"utf-8");
		System.out.println(str2);
		
		
		
		
		/**
		 * what is above is the theory of readUTF!!!
		 * just define an data length at the header of the real String
		 * using readUTF() is very convenient
		 */
		String strUtf = raf.readUTF();
		System.out.println(strUtf);
		
		raf.close();
		
		
	}
}
