package day20.Demo08_OutputStreamWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter
 * write character stream
 * this high-level IOStream has it own buffer inside
 * @author patrickyu
 *
 */
public class Demo08_OutputStreamWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("osw.txt"));
		
		/**
		 * write(int i)
		 * now it doesn't mean write 1 byte any more, 
		 * here it means write an actual int value,
		 * because you are using character IOStream
		 * 
		 * write(char[] c)
		 * write the array of chars all at once, not 1 byte as before
		 * 
		 * write(char[] c, int begin, int len)
		 * write an array of char, from the position at "begin" with a length "len"
		 * 
		 * write(String str)
		 * write a certain string 
		 * 
		 * write(String str, int begin, int len)
		 * write a String from index begin with a length of "len"
		 */
		
		
		/**
		 * the second parameter can't be negative
		 * the second parameter + the third parameter can't be longer than the length of this string
		 */
		writer.write("thinking in java",9,7);
		writer.close();
	}

}
