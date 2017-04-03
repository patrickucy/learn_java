package day20.Demo04_Duplicate_Using_IOBufferedStream;
/**
 * high-level IOStream
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * duplicate file using IOBufferedStream
 * @author patrickyu
 *
 */
public class Demo04_Duplicate_Using_IOBufferedStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("testCopyPic.jpg");
		FileOutputStream fos = new FileOutputStream("testCopyPic copy2.jpg");
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);
		
		
		
		int d = -1;
		while ((d = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(d);
		}
		
		/**
		 * bufferedOutputStream has a important method called
		 * flush()
		 * it can output all data forcibly
		 */
		bufferedOutputStream.flush();
		
		
		/**
		 * in java you just need to close the high-level IOStream
		 * because they will close their corresponding low-level IOStream automatically
		 * 
		 */
		bufferedInputStream.close();
		bufferedOutputStream.close();
		
	}
}
