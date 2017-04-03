package day19.Demo03_RandomAccessFile_Read;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * read data from file
 * @author patrickyu
 *
 */
public class Demo03_RandomAccessFile_Read {

	public static void main(String[] args) {
		File file = new File("raf.dat");
		if (!file.exists()) {
			return; // because you are reading a file
		}
		
		RandomAccessFile raf = null;
		/**
		 *  you have to do it like this, otherwise, 
		 *  you can't use this reference in finally block
		 */
		
		try {
			raf = new RandomAccessFile(file, "r");
			/**
			 *  int read()
			 *  read 1 byte every time, and return a int value
			 *  but this int value only has a 8 bits valid
			 */
			
			
			char a = (char) raf.read();
			char b = (char) raf.read();
			System.out.println(a);
			System.out.println(b);
			
			/**
			 *  how does it work ?
			 *  file 
			 *  01111111 11111111 11111111 11111111
			 *  
			 *  we define a sum as 
			 *  00000000 00000000 00000000 00000000
			 *  
			 *  sum
			 *  00000000 00000000 00000000 00000000
			 *  i = raf.read() i<<24
			 *  01111111 00000000 00000000 00000000
			 *  ->
			 *  01111111 00000000 00000000 00000000
			 *  
			 *  
			 *  
			 *  i << 16
			 *  01111111 00000000 00000000 00000000
			 *  00000000 11111111 00000000 00000000
			 *  ->
			 *  01111111 11111111 00000000 00000000
			 *  
			 *  i << 8
			 *  01111111 11111111 00000000 00000000
			 *  00000000 00000000 11111111 00000000
			 *  ->
			 *  01111111 11111111 00000000 00000000
			 *  
			 */
			
			int sum = 0;
			int i = raf.read();
			sum = sum | i << 24;
			
			i = raf.read();
			sum = sum | i << 16;
			
			i = raf.read();
			sum = sum | i << 8;
			
			i = raf.read();
			sum = sum | i;
			
			System.out.println(sum);
			
			int num = raf.readInt();
			System.out.println(num);
			
			long lnum = raf.readLong();
			System.out.println(lnum);
			
			float fnum = raf.readFloat();
			System.out.println(fnum);
			
			/**
			 *  read string
			 *  but how long a String you read??????
			 *  in primitive type, the system knows how long they are, but length of a string is dynamic!
			 *  
			 */
//			String str = raf.readUTF(); ?
//			System.out.println(str);
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		/**
		 * this finally block is very necessary!,just write it this way!
		 * 
		 */
	}
}
