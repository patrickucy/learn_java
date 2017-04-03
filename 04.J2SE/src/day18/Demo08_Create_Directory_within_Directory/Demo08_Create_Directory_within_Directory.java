package day18.Demo08_Create_Directory_within_Directory;

import java.io.File;

/**
 * create directory within directory
 * @author patrickyu
 *
 */
public class Demo08_Create_Directory_within_Directory {

	public static void main(String[] args) {
		/**
		 * create directory as a/b/c/s
		 * 
		 */
		File dir = new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"d");
		if (!dir.exists()) {
			dir.mkdirs(); 
			/**
			 *  with this mkdirs, we can create directories recursively!
			 *  the whole purpose of doing this is to create the "d" directory
			 */
		}
		
		
		
		System.out.println("compeple!");
	}
}
