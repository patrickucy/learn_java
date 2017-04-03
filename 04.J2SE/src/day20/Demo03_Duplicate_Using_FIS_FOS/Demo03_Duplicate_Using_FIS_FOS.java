package day20.Demo03_Duplicate_Using_FIS_FOS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Duplicate using FIS FOS
 * 
 * fis fos are low-level IOStream
 * 
 * @author patrickyu
 *
 */
public class Demo03_Duplicate_Using_FIS_FOS {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("testCopyPic.jpg");
		FileOutputStream fos = new FileOutputStream("testCopyPic copy.jpg");
		
//		int d = -1;
//		while((d = fis.read()) != -1){
//			fos.write(d);
//		}
		//slow stupid way
		
		int sum = 0;
		byte[] buf = new byte[1024*10];
		while ((sum = fis.read(buf)) != -1) {
			fos.write(buf,0,sum);

		}
		
		fis.close();
		fos.close();
		
	}
}
