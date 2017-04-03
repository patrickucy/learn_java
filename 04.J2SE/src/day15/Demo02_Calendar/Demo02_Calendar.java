package day15.Demo02_Calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * using Calendar to calculate time
 * @author patrickyu
 *
 */
public class Demo02_Calendar {
	public static void main(String[] args) {
		/**
		 *  creating a Calendar instance according to user's local time zone
		 *  java.util.Calendar
		 *  default description is current time of our system
		 */
		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar);// too much information
		// also singleton
		
		// this getTime() of calendar has a return type Date, describing current time 
		Date date = calendar.getTime();
		System.out.println(date);
		
		
		/**
		 *  void setTime(Date date)
		 *  
		 */
		calendar.setTime(date);
		
	}
}
