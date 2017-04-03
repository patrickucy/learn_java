package day20.Demo10_IOStreamReaderWriter_Duplicate_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * using character IOStream to duplicate file
 * @author patrickyu
 *
 */
public class Demo10_IOStreamReaderWriter_Duplicate_File {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/**
		 * copy current source file to certain directory
		 */
		FileInputStream fis = new FileInputStream(
				"src"+File.separator+"day20"+File.separator+"Demo10_IOStreamReaderWriter_Duplicate_File"+File.separator+"Demo10_IOStreamReaderWriter_Duplicate_File.java");
		
		FileOutputStream fos = new FileOutputStream("copy Demo10_IOStreamReaderWriter_Duplicate_File.java");
		
		
		//package byte IOStream to Character IOStream
		InputStreamReader reader = new InputStreamReader(fis);
		OutputStreamWriter writer = new OutputStreamWriter(fos);
		
		
//		int c = -1;
//		while ((c = reader.read()) != -1) {
//			writer.write(c);
//			
//		}
		
		
		//manual buffer
		char[] buffer = new char[1024]; // now you need to define char[] not byte[] as before
		int len = -1;
		while( (len = reader.read(buffer)) != -1 ){
			writer.write(buffer,0,len);
		}
		reader.close();
		writer.close();
		
	}

}
