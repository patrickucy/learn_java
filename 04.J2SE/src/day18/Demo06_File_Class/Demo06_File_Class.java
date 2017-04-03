package day18.Demo06_File_Class;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java.io.File
 * use it to describe a file or a directory
 * you can get the properties of this file, but not the content
 * 
 * 
 * you create yourself a "MyFile.txt" on your relative path instead of Absolute Path
 * because in order to have cross-platform feature, you have to do this
 *
 * @author patrickyu
 *
 */
public class Demo06_File_Class {

	public static void main(String[] args) {
		/**
		 *  create a file instance, to describe your file at desktop
		 *  MyFile.txt
		 *  
		 *  
		 *  ****************************************************************************************
		 *  "." denotes current directory, this means the root directory of current program
		 *  E:\Patrickucy\Desktop\MyFiles.txt     this is what a path looks like in windows
		 *  /Users/patrickyu/Desktop              this is what a path looks like in Mac OS and Linux
		 *  
		 *  You could use File.separator to prevent this directory issue happening in the future
		 *  because the java could adapt separator automatically for different OS
		 *  
		 *  
		 */
		File file = new File("."+File.separator+"MyFile.txt"); // this file must be at the directory of J2SE
		
		long length = file.length();
		/**
		 *  long length()
		 *  get the Bytes of this file
		 */
		System.out.println("file size: "+length);
		
		
		/**
		 * file.getName();
		 */
		System.out.println("file name: " + file.getName());
		
		/**
		 * file.getPath()
		 * file.getAbsolutePath()
		 */
		System.out.println("file path: " + file.getPath());
		System.out.println("file absolute path: " + file.getAbsolutePath());
		
		
		/**
		 * file.latModifed()
		 * last modified time
		 */
		long lastm = file.lastModified();
		System.out.println(lastm);
		Date date = new Date();
		date.setTime(lastm);
		SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy MM-dd, HH:mm:ss");
		String timeString = timeFormatter.format(date);
		System.out.println("last modified: "+ timeString);
		
		
		
		/**
		 * boolean exists()
		 * query if there such file exists in our hard disk
		 */
		if (file.exists()) {
			System.out.println("exists");
		}else{
			System.out.println("not exist");
		}
			
		/**
		 *  boolean.isFile()
		 */
		if (file.isFile()) {
			System.out.println("is file");
		}
		if (file.isDirectory()){
			System.out.println("is directory");
		}
		
		/**
		 * read write
		 */
		if (file.canRead()) {
			System.out.println("file can read");
		}
		if (file.canWrite()) {
			System.out.println("file can write");
		}
		
		
		
		
		
	}
}





















