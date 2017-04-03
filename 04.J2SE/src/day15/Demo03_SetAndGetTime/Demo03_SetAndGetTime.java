package day15.Demo03_SetAndGetTime;

import java.util.Calendar;

/**
 * set and get time
 * @author patrickyu
 *
 */
public class Demo03_SetAndGetTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		/**
		 *  Setting properties !!!!!
		 *  
		 *  set the year of this time to 1995
		 *  using Class constant to select our field
		 */
		calendar.set(Calendar.YEAR, 1995);
		System.out.println(calendar.getTime());
		// you can see that the weekday is also changed ! 
		
		calendar.set(Calendar.MONTH, 4);
		System.out.println(calendar.getTime());
		// for counting month, you can see here, it starts from index Zero
		
		calendar.set(Calendar.DATE, 5);
		System.out.println(calendar.getTime());
		// Here date is the real date of every month
		/**
		 *  set current date as 5
		 *  Calendar.DATE				->		denoting a day of a month
		 *  Calendar.DAY_OF_MONTH		->		exactly the same as above
		 *  Calendar.DAY_OF_WEEK		->		day in a week
		 *  Calendar.DAY_OF_YEAR		->		day in a year
		 *  Calendar.HOUR				->		12 hours
		 *  Calendar.HOUR_OF_DAY		->		24 hours
		 *  
		 */

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		System.out.println(calendar.getTime());
		
		
		
		
		
		/**
		 *  getting properties !!!!
		 */
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("week: " + (dayOfWeek == 1 ? "sunday":dayOfWeek -1));
		// here Sunday is the first day of a week for american people, this is why it looks weird
				
		/**
		 *  checking may 5th in 1995 is what day in that year
		 */
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("it's the "+ dayOfYear + " day of that year");
	}

}
