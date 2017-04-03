package day15.Demo05_Calendar_TimeCalculation;

import java.util.Calendar;

/**
 * time calculation in Calendar class
 * @author patrickyu
 *
 */
public class Demo05_Calendar_TimeCalculation {
	
	public static void main(String[] args) {
		// create a system time 
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/**
		 *  check a time in 2 days later
		 *  pay attention to the field you choose here
		 */
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		System.out.println(calendar.getTime());
		
		
		/**
		 * just use negative value, then you can get the time before now
		 */
		calendar.add(Calendar.DAY_OF_YEAR, -6);
		System.out.println(calendar.getTime());
	}
	
}
