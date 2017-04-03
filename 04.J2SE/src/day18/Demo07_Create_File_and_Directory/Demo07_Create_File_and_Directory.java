package day18.Demo07_Create_File_and_Directory;

import java.io.File;
import java.io.IOException;

/**
 * create file and directory
 * 
 * @author patrickyu
 *
 */
public class Demo07_Create_File_and_Directory {

	public static void main(String[] args) {
		/**
		 * create sub directory within current directory
		 * 
		 * 
		 * ./demo
		 * demo
		 * the default setting of java to create a file is doing that in current directory
		 */
		//		File file = new File("." + File.separator+ "demo");
		File file = new File("demo"); // same as above
		if (!file.exists()) {
			file.mkdir();
		}
		System.out.println("Complete creating file");


		/**
		 * this is the absolute path of your file in whatever OS
		 * it requires you to throws IOException
		 * and usually you need to make sure such file or directory does exist,
		 * if not, then its not a good way
		 */
		try{
			System.out.println(file.getCanonicalPath());
		}catch(IOException e){
			System.out.println(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		}



		/**
		 * create file test.txt in directory demo
		 */
		//		File test = new File("demo"+ File.separator+"test.txt");
		File test = new File(file,"test.txt"); // because file is describing demo directory! not a file !!
		if (!test.exists()) {
			try{
				test.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}
}
