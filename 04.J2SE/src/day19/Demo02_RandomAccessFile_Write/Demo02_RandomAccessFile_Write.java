package day19.Demo02_RandomAccessFile_Write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * using RandomAccessFile to write data to file
 * 
 * @author patrickyu
 *
 */
public class Demo02_RandomAccessFile_Write {

	public static void main(String[] args) {
		/**
		 *  #1 create a file to receive data
		 *  suffix is random, you can define whatever you want
		 */
		File file = new File("raf.dat");
		if (!file.exists()) {
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("File creation failed!");
				return; // no file exist then what will be doing next is meaningless
			}
		}

		/**
		 *  create a RandomAccessFile to manipulate data in a file
		 *  the second parameter is to define you operation mode, only two modes supported
		 *  "r": 	read only
		 *  "rw":	read write
		 *  
		 */
		try{
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			/**
			 * write(int d)
			 * write 1 byte to the lower 8 bit of an int value
			 * 
			 * 00000000 00000000 00000000 00000001
			 * the rightmost 8 bit is our first 1 byte
			 * char
			 * 10100101 10100010 
			 */
			raf.write('A'); // write 1 byte;
			raf.write('B'); // write another 1 byte;
			
			
			/**
			 *  what if you want to write the max value of integer ?
			 *  Max Integer Value:  01111111 11111111 11111111 11111111
			 *  it you just write(max), in fact you just write the rightmost 8 bits to this file
			 *  
			 *  max						   vvvvvvvv (you are writing these 8 bits) 	
			 *  01111111 11111111 11111111 11111111
			 *  then how do you write the whole chunk?
			 *  you move bits!
			 *  
			 *  max >>> 24				   vvvvvvvv
			 *  00000000 00000000 00000000 01111111 -> (11111111 11111111 11111111) in bracket,these data just lost
			 *  now you can write, and you are writing the leftmost 8 bit
			 *  
			 *  max >>> 16				   vvvvvvvv
			 *  00000000 00000000 01111111 11111111 -> (11111111 11111111) lost data
			 *  write again
			 *  
			 *  max >>> 8				   vvvvvvvv
			 *  00000000 01111111 11111111 11111111 -> (11111111)
			 *  
			 *  max   					   vvvvvvvv
			 *  01111111 11111111 11111111 11111111
			 *  
			 *  then you are done writing data to file
			 *  
			 *  when you open it you see nothing about this int, that's because OS don't recognize this string
			 */
			
			int max = Integer.MAX_VALUE;
			raf.write(max >>> 24);
			raf.write(max >>> 16);
			raf.write(max >>> 8);
			raf.write(max);

			
			
			
			
			/**
			 * as you can see, writing all these stuff is so complicated
			 * in fact, you just need to use    
			 * raf.writeInt(max);
			 * this is equivalent to above 5 lines of code
			 * at the lower layer of writeInt(), it still writes data byte by byte
			 */
			raf.writeInt(max);
			raf.writeLong(123);
			raf.writeFloat((float) 232.12);
			
			/**
			 * above is how you write primitive data types
			 * what if you want to write a String?
			 */
			String str = "I love United States of America";
			
			byte[] data = str.getBytes("utf-8");
			
			
			/**
			 * write(byte[] data)
			 * write a chunk of data 
			 */
			raf.write(data);
			
			raf.writeUTF(" and I still love china "); // this is the default to write String as UTF-8 coding

			
			
			
			
			
			
			
			
			
			
			raf.close(); 
			/**
			 *  After your operation, you need to close, in order to let other application to access this file,
			 *  otherwise, it will just keep occupying writing to such file
			 *  
			 *  In fact, you need to put it at the finally block;
			 */
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}
}
