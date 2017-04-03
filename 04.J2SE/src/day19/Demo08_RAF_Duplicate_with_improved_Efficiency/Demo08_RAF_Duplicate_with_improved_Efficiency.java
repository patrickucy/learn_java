package day19.Demo08_RAF_Duplicate_with_improved_Efficiency;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * 
 * @author patrickyu
 *
 */
public class Demo08_RAF_Duplicate_with_improved_Efficiency {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 *  copy file
		 */
		File src = new File("testCopyPic.jpg");
		// read the source file
		RandomAccessFile srcRaf = new RandomAccessFile(src, "r");

		File des = new File("testCopyPic_Copy.jpg");
		RandomAccessFile desRaf = new RandomAccessFile(des, "rw");

		
		
		

		/**
		 *  now copy content from source file to destined file
		 *  in a more efficient way
		 */
		Date startTime = new Date();
		System.out.println("Now copying ...");


		
		
		
		
		/**
		 *  old stupid way!
		 *  54227 milliseconds
		 */
//		int d = -1;
//		while((d = srcRaf.read()) != -1){
//			desRaf.write(d);
//			System.out.println("Completed: " + String.format("%.2f", (srcRaf.getFilePointer()/(double)srcRaf.length())*100) + "%");
//			
//		} 



		/**
		 * new efficient way
		 * 54 milliseconds
		 * 
		 * this tells you if you want to improve rw efficiency,
		 *  you have to cut down your rw frequency
		 *  
		 *  it also doesn't mean that better buffer better performance,
		 *  usually 10K is enough
		 */		
		byte[] buf = new byte[1024*10];		// create a byte[] with 10k
		int len = 0;
		/**
		 * int read(byte[] b)
		 * when it return -1, means it reaches the end of file content
		 */
		while((len = srcRaf.read(buf)) != -1 ){
			/**
			 * write(byte[] b, int start, int length)
			 * write a chunk of data starting from "start" with a length of "length"
			 */
			desRaf.write(buf, 0, len);
			System.out.println("Completed: " + String.format("%.2f", (srcRaf.getFilePointer()/(double)srcRaf.length())*100) + "%");
		}


	
		

		srcRaf.close();
		desRaf.close();
		Date endTime = new Date();
		System.out.println("duplicate file complete! Takes "+(endTime.getTime() - startTime.getTime())+" total milliseconds" );

	}

}
