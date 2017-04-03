package day20.Demo09_InputStreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader 
 * this high-level IOStream has it own buffer inside
 * @author patrickyu
 *
 */
public class Demo09_InputStreamReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(new FileInputStream("osw.txt"));
		
		/**
		 * now the same shit happens!
		 * you don't know how long your string is
		 * 
		 * int read()
		 * read 2 bytes every time 
		 * if reruns -1, it mean EOF (end of file)
		 */
		
		int d = -1;
		while((d = reader.read()) != -1 ){
			System.out.print((char)d);		
		}
		
		reader.close();
	}

}
