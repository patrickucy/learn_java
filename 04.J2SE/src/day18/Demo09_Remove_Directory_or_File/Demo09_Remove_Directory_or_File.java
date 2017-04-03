package day18.Demo09_Remove_Directory_or_File;

import java.io.File;
import java.io.IOException;

/**
 * remove directory or files
 * @author patrickyu
 *
 */
public class Demo09_Remove_Directory_or_File {

	public static void main(String[] args) {
		File file = new File("MyFile.txt");
		if (!file.exists()) {
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			/**
			 * delete File in current directory
			 */
			file.delete();
		}
//		file.delete();
		/**
		 *  when you want to delete a directory, you have to make sure there are no content in it
		 */
		
	}
}
