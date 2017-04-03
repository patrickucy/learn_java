package day20.Demo13_FileReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * file reader and writer
 * 
 */
public class Demo13_FileReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("fileWriterDemo.txt");
		
		fw.write("I love united states of america");
		
		fw.close();
		
		
		/**
		 * this method doesn't support different charset like "GBK"
		 * its default is to use OS charset, and it can not be changed  
		 * 
		 * if you still want to use your own charset, please use InputStreamReader and OutputStreamWriter
		 */
		FileReader fr = new FileReader("fileWriterDemo.txt");
		
		int c = -1;
		while((c = fr.read()) != -1){
			System.out.print((char)c);
		}
		fr.close();
	}
}
