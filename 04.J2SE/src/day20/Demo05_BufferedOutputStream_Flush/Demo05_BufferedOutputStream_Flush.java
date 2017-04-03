package day20.Demo05_BufferedOutputStream_Flush;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStream Flush
 * @author patrickyu
 *
 */
public class Demo05_BufferedOutputStream_Flush {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("flush.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		/**
		 * if don't close, in fact nothing was written to file!!!
		 * because the data is still in the buffer, still waiting for 
		 * more data to write all at once
		 */
		bos.write('A');
		
		/**
		 * flush data in buffer
		 * here is just telling you, you can do this
		 */
//		bos.flush();
		
		
		/**
		 * close() will call flush() before it close
		 */
		
		bos.close();
	}
}
