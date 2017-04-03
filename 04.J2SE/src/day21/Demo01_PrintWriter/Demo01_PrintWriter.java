package day21.Demo01_PrintWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * has self-refresh buffer char IOStream
 * 
 * @author patrickyu
 *
 */
public class Demo01_PrintWriter {
	
	public static void main(String[] args) {
		PrintWriter writer = null;
		
		try {
			/**
			 * Approach #1 
			 * just use file object to initialize an object
			 * you don't have to initialize a FileInputOutputStream any more
			 */
//			File file = new File("PrintWriterDemo.txt");
//			writer = new PrintWriter(file);
			
			
			
			/**
			 * Approach #2
			 * PrintWriter(String filePath)
			 * using a path to create a char OutputStream for this file
			 */
//			writer = new PrintWriter("PrintWriterDemo.txt");
			
			
			
			/**
			 * Approach #3
			 * package FileIOSteam
			 * it supports override method
			 * 
			 * PrintWriter(OutputStream out)
			 * specify a byte IOStream to create printWriter
			 * 
			 * PrintWriter(OutputString out,boolean autoFlush)
			 * this "true" means it turn on its line refresh feature, it flush
			 * data out every single line of string. usually turning this option on
			 * would jeopardize our efficiency, but if you have do this need, then 
			 * you just turn this on
			 */
//			FileOutputStream fos = new FileOutputStream("PrintWriterDemo.txt");
////			writer = new PrintWriter(fos);
//			writer = new PrintWriter(fos,true);
			
			
			
			
			/**
			 * Approach #4
			 * package to be a char IOStream
			 * 
			 * PrintWriter(Writer writer)
			 * create a writer stream based on char IOStream
			 * usually we would do this because in China you will have the issue of 
			 * transferring charset back and fort
			 * 
			 * just like the second line of code, you now can specify the charset you need 
			 * "UTF-8" should be uppercase
			 * 
			 */
			FileOutputStream fos = new FileOutputStream("PrintWriterDemo.txt"); // byte IOStream
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8"); 		// package(byte IOStream) -> char IOStream
			writer = new PrintWriter(osw,true);									// package(package(byte IOStream)) -> PrintWriter
			
			
			
			/**
			 * if you don't close or flush, this string will be still in the buffer inside this
			 * writer object 
			 */
			writer.println("just say some shit");
					
					
					
			/**
			 * pay attention to flush()
			 * because later you might have the need of real-time data transferring
			 */
			writer.flush();
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			if (writer != null) {
				writer.close();
			}
		}
	
		
		
		
	}

}
