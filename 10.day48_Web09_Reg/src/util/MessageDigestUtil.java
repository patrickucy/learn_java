package util;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.sun.mail.util.BASE64EncoderStream;
import javax.security.*;


public class MessageDigestUtil {

	
	private static void test1() throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("md5");
		String str = "I love you";
		byte[] buf = md.digest(str.getBytes());
		// byte array is always not convenient , usually we use string array
//		BASE64Encoder encoder = new BASE64Encoder();
//		String str2 = encoder = encoder.encode(buf);
	

		
		
	}
	
	public static String encrypt(String origStr) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("md5");
		String str = "I love you";
		byte[] buf = md.digest(origStr.getBytes());
		// byte array is always not convenient , usually we use string array
//		BASE64Encoder encoder = new BASE64Encoder();
		String str2 = null;
//		String str2 = encoder = encoder.encode(buf);
		return str2;
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		test1();
	}
}
