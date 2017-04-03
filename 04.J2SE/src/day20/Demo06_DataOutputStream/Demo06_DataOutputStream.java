package day20.Demo06_DataOutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream another high-level IOStream
 * @author patrickyu
 *
 */
public class Demo06_DataOutputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("data.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		
		/**
		 * write 4 bytes consecutively, int value
		 * 
		 * the process of transforming primitive-data-type data to corresponding bytes 
		 * we call: serialization of primitive-data-type data
		 *  data -> byte 	(serialization)
		 *  data -> storage (persistence)
		 */
		dos.writeInt(123);
		dos.writeDouble(12312.123);
		dos.writeUTF("what the hell man!");
		dos.close();
	}

}
