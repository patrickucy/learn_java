package day14.Demo12_SimpleDateFormat_Reverse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * do the reverse operation of SimpleDateFormat
 * @author patrickyu
 *
 */
public class Demo12_SimpleDateFormat_Reverse {
	public static void main(String[] args) throws ParseException { // here you have to have this, you will lean it later 
		String str = "2013/12/30 15:22:45";
		/**
		 * "2013/12/30 15:22:45"
		 * "yyyy/MM/dd HH:mm:ss"
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date time = formatter.parse(str);
		System.out.println(time);
	}
}
