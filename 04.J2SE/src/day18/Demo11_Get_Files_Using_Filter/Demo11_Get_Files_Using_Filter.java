package day18.Demo11_Get_Files_Using_Filter;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * Get files using filter
 * 
 * you might have the need to get files that meet your needs, certain files
 * @author patrickyu
 *
 */
public class Demo11_Get_Files_Using_Filter {

	public static void main(String[] args) {
		/**
		 * FileFilter    this is an interface
		 */
		FileFilter filter = new FileFilter(){
			
			/**
			 * this method is to query if this file cater our need
			 */
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
//				System.out.println("FileFilter is filtering: "+ file.getName());
//				return file.getName().startsWith(".");
				return file.getName().endsWith(".txt");
			}
			
		};
		
		File dir = new File(".");
		File[] subFiles = dir.listFiles(filter);
		
		System.out.println(Arrays.toString(subFiles));
	}
}
