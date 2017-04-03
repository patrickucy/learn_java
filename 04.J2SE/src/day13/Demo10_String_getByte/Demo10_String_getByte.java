package day13.Demo10_String_getByte;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo10_String_getByte {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "??????java";
		byte[] gbk = str.getBytes("gbk");
		byte[] utf = str.getBytes("utf-8");

		System.out.println(Arrays.toString(gbk));
		System.out.println(Arrays.toString(utf));
	}

}
