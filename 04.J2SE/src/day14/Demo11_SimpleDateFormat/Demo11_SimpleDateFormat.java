package day14.Demo11_SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * using SimpleDateFormat to convert time to current string
 * @author patrickyu
 *
 */
public class Demo11_SimpleDateFormat {
	public static void main(String[] args) {
		/**
		 *  set a format as follow
		 *  2015-04-12 08:51:25
		 *  yyyy-MM-dd HH:mm:ss					// "-" as its original meaning
		 */
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		String timeString = format.format(now);
		System.out.println(timeString);
		/**
		 * String format(Date date)
		 * format current time to certain format
		 */
		
	}
}
