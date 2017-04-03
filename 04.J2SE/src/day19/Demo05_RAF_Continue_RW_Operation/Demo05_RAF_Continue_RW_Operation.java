package day19.Demo05_RAF_Continue_RW_Operation;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * using RandomAccessFile to continue your read write operation from your last breakpoint
 * 
 * @author patrickyu
 *
 */
public class Demo05_RAF_Continue_RW_Operation   {

	public static void main(String[] args) throws IOException  {
		
			File file = new File("demo.txt");

			RandomAccessFile raf = new RandomAccessFile(file,"rw");

			System.out.println( raf.getFilePointer() );					
			// filePointer starts from 0
			raf.write('A');
			System.out.println( raf.getFilePointer() );	// move 1 byte				

			raf.write('B');
			System.out.println( raf.getFilePointer() );	// move another 1 byte				

			raf.writeInt(123);
			System.out.println( raf.getFilePointer() );	// move another 4 bytes				

			
			
			raf.seek(0); // reset our index of RAF, in order to read our file from start
			// reset filePointer to 0 in order to read file from start
			
			/**
			 * int read()
			 * read 1 byte, and return int, only lower 8 bits is valid
			 * if returns -1, it means we reach the end of our content!!!!!
			 */
			char a = (char) raf.read(); 
			/**
			 * In fact, you are now reading from the current FilePointer
			 * OFException:
			 *  end of file exception,reaching the end of file,meaning we are not 
			 *  suppose to continue reading 
			 * 
			 */
//			System.out.println(raf.read());
			
			System.out.println(a);

			char b = (char) raf.read();
			System.out.println(b);

			int i = raf.readInt();
			System.out.println(i);

			

			raf.close();
		
	}
}
