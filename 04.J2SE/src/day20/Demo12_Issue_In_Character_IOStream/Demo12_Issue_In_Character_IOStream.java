package day20.Demo12_Issue_In_Character_IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * write String to file and read it back
 * @author patrickyu
 *
 */
public class Demo12_Issue_In_Character_IOStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("charset.txt");
		String str = "I still prefer USA";
		fos.write(str.getBytes("utf-8")); //  pay attention here, you can use your own Standard charset like "GBK"
		fos.close();
		
		/**
		 * the OS default is UTF-8 now, no longer using GBK !!!
		 * InputStreamReader(InputStream in)
		 * 
		 * also you can still use your own charset like "GBK"
		 * InputStreamReader(InputStream in,String charset) like "StandardCharsets.UTF_8"   
		 * 
		 * when transferring string data, you need to make sure both side using the same charset
		 */
		InputStreamReader reader = new InputStreamReader(new FileInputStream("charset.txt"),StandardCharsets.UTF_8);
		int i = -1;
		while ((i = reader.read()) != -1) {
			System.out.print((char)i);
		}
		reader.close();
	}

}
