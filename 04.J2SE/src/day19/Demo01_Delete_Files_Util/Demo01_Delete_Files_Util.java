package day19.Demo01_Delete_Files_Util;
/**
 * BIG Warning!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * don't be stupid and delete all your work!!!!!
 * 
 */
import java.io.File;

/**
 * 
 * @author patrickyu
 *
 */
public class Demo01_Delete_Files_Util {

	public static void main(String[] args) {
		// don't be stupid and delete all your work!!!!!
		// never used new File(".") here!!!!!!!!
		File file = new File("/Users/patrickyu/Desktop/Desktop Demo Folder");
		deleteFile(file);
	}



	/**
	 * delete certain File, including files and directories and contents in directories
	 * do it recursively
	 */
	public static void deleteFile(File file){
		if (file.isDirectory()) {
			for(File subFile : file.listFiles()){
				deleteFile(subFile);
			}
		}
		file.delete();
	}
}

