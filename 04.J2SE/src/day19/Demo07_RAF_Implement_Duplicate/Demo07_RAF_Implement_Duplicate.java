package day19.Demo07_RAF_Implement_Duplicate;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * combine all you learn from RAF read write to implement a copy operation like OS.
 * @author patrickyu
 *
 */
public class Demo07_RAF_Implement_Duplicate {

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
		 */
		int d = -1;
		while((d = srcRaf.read()) != -1){
			desRaf.write(d);
		}
		
		srcRaf.close();
		desRaf.close();
		System.out.println("duplicate file complete!");
	}

}
