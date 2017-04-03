package day19.Demo04_RandomAccessFile_Read_String;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * techniques to Read string
 * @author patrickyu
 *
 *
 * write data
 * 
 * write data here is always writing data from scratch,
 * it will not continue where you leftover, continue at the last breakpoint 
 * this will be discuss in the next demo
 *
 */
public class Demo04_RandomAccessFile_Read_String {

	public static void main(String[] args) throws Exception {
		// this throws Exception is for tutorial only  !!!,in real work, you can't do this!

		File file = new File("testStr.txt");
//		if (!file.exists()) {
//			file.createNewFile();
//		} // in fact RandomAccessFile can create this file for us, which means we don't have to write this block of code
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		String str = "Before I met you, I thought you were an angle, but I just realize how stupid I was, "
				+ "in fact you are a Greentea. what the hell";
		byte[] data = str.getBytes("utf-8");
		
		
		
		raf.writeInt(data.length);
		raf.write(data);
		/**
		 * if you mix Int and string together, it will be a pain to read this String data back!
		 * because, how do people know how long of a String really is ?
		 * 
		 * this is why, when you writing a string, you better write a int value telling how long of 
		 * the following string, then you will know how long to read 
		 */
		String str1 = "ki ki ki uv";
		byte[] data2 = str1.getBytes("utf-8");
		raf.writeInt(data2.length);
		raf.write(data2);
		
		/**
		 *  in fact writeUTF() has defined the data length of the following string, 
		 *  then you could make reading this string back more easily!
		 */
		raf.writeUTF("now testing utf-8 right now");
		
		
		raf.close();
	}

}
