package day20.Demo02_FileInputStream;
import java.io.FileInputStream;
/**
 * file input stream
 */
import java.io.IOException;

public class Demo02_FileInputStream {

	public static void main(String[] args) throws IOException {
		/**
		 * FileInputStream(File file)
		 * FileInputStream(String filePath)
		 */
		FileInputStream fis = new FileInputStream("fos.txt");
		
		/**
		 * int read()
		 * read 1 byte at a time
		 * return a int, but only its low 8 bit is valid
		 * if returns -1, then it reaches the end of that file
		 * 
		 * byte b = -1 byte -1 ==> 11111111
		 * 00000000 00000000 00000000 11111111 = 127
		 * 11111111 11111111 11111111 11111111 = -1
		 * using int is to describe the end of content as -1
		 */
//		int d = fis.read();
		char a = (char)fis.read();
		char b = (char)fis.read();
		System.out.println(a);
		System.out.println(b);
		fis.close();             
	}
}
