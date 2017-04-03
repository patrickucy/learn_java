package day18.Demo10_Remove_Directory_or_File_More;

import java.io.File;
import java.util.Arrays;

/**
 * get all contents from a directory
 * 
 * @author patrickyu
 *
 */
public class Demo10_Remove_Directory_or_File_More {

	public static void main(String[] args) {
		File dir = new File(".");
		if (dir.exists() && dir.isDirectory()) {
			String[] listedFiles = dir.list();
			System.out.println(Arrays.toString(listedFiles));
			/**
			 * list is not quite useful, because it only tells you the names
			 */
		}
		
		
		
		if (dir.exists() && dir.isDirectory()) {
			File[] subs = dir.listFiles();
			for(File sub: subs){
				System.out.println(sub.isFile() ? 
						"File: "+ sub.getName() + "\t\t" + "Length: " + sub.length():
							"Dir: "+ sub.getName() + "\t\t" +"Length: "+ sub.length());
				
				
			}
			System.out.println("*********************************************");
			for (File sub: subs) {
				System.out.print(sub.isFile() ? "File: ":"Dir: ");
				System.out.print(sub.getName()+"\t\t");
				System.out.println(sub.length()+" Bytes");
			}
			
		}
	}
}
