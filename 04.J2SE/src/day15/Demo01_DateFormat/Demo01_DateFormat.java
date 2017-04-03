package day15.Demo01_DateFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat 
 * Super class of SimpleDateFormat
 * @author patrickyu
 *
 */
public class Demo01_DateFormat {
	public static void main(String[] args) {
		// create a Date object
		Date now = new Date();
		DateFormat formatter = DateFormat.getDateInstance();
		// why not new yourself an instance ?
		// in fact this is a factory method
		// why using a factory method over new a new object?
		// in fact some instance, if you just new it, it doesn't have any initial value, which means
		// you have to do initialization yourself! however, if you use factory method, you could get 
		// the basic initialization automatically when you use factory method. This is why factory 
		// method is valuable right now
		
		/**
		 *  and in fact this is a singleton
		 */
		
		
		/**
		 *  converting time zone to string according to US
		 */
		DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US);
		String str = format.format(now);
		System.out.println(str);
		
		format = DateFormat.getDateInstance(DateFormat.LONG,Locale.CHINA);
		str = format.format(now);
		System.out.println(str);
	}
}
