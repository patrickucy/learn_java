package day20.Demo11_BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * using BufferedReaderWriter to duplicate file
 * 
 * @author patrickyu
 *
 */
public class Demo11_BufferedReaderWriter {

	public static void main(String[] args) throws IOException{
		/**
		 * duplicate current source file to root directory
		 */
		
		/**
		 * byte IOStream
		 */
		FileInputStream fis = new FileInputStream(
				"src"+File.separator+"day20"+File.separator+"Demo11_BufferedReaderWriter"+File.separator+"Demo11_BufferedReaderWriter.java"
				);
		
		FileOutputStream fos = new FileOutputStream("copy Demo11_BufferedReaderWriter.java");
		
		
		/**
		 * package byte IOStream to Character IOStream
		 */
		InputStreamReader isr = new InputStreamReader(fis);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		
		/**
		 * it doesn't support byte IOStream, only character IOStream is supported
		 * then we have to transform our FileIOStream to IOStreamReaderWriter!
		 */
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(osw);
		
		/**
		 * readLine()
		 * read exactly one line of text! not include the return character
		 * and return exactly one line of txt as a string 
		 * if it returns null, then it reach the end of file
		 */
		String strLine = null;
		while((strLine = br.readLine()) != null){ 
			System.out.println(strLine);
			bw.write(strLine);
			bw.newLine(); // it will as an return character for you automatically
		}
		br.close();
		bw.close();
		
	}
}
