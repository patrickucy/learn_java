package dms.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *  normally util class is always using static method
 * @author patrickyu
 *
 */
public class Utils {

	/**
	 * read string and transform it to int from certain file 
	 * @param file this file should have only one line of content, and it is suppose to be a string 
	 * @return
	 */
	public static int readInt(File file){
		BufferedReader reader = null;
		
		// fileReader doesn't support different coding 
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			reader = new BufferedReader(isr);
			
			String number  = reader.readLine();
			return Integer.parseInt(number);			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(reader !=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * save your current position number to file 
	 * @param file
	 * @param num
	 */
	public static void saveInt(File file, int num){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			writer.println(num);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
			
		} finally {
			if(writer != null){
				writer.close();

			
			}
		}
	}
	
	// read our binary data to String data
	public static String toString(byte[] arry, int offset, int length){
		try {
			String str = new String(arry, offset, length, "iso8859-1");
			return str.trim();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public static int toInt(byte[] ary, int offset){
		
		// read basic data type, advanced input stream
		DataInputStream in = null;
		
		try {
			/**
			 * input stream for reading data from byte array
			 */
			ByteArrayInputStream bais = new ByteArrayInputStream(ary);
			in = new DataInputStream(bais);
			
			/**
			 * skip certain bytes in order to achieve the goal of offset 
			 */
			in.skipBytes(offset);
			
			
			//read 4 byte of data and convert it to int value
			int i = in.readInt();
			return i;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static short toShort(byte[] ary, int offset){
		DataInputStream in = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(ary);
			in = new DataInputStream(bais);
			in.skip(offset);
			short s = in.readShort();
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} finally {
			if( in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	/**
	 * given every element in a certain collection, we write them to file
	 */
	public static void saveList(File file, List list) throws IOException {
		PrintWriter writer = new PrintWriter(file);
		for(Object obj : list){
			writer.println(obj.toString());
		}
		writer.close();
	}
	
	
	
	
}
