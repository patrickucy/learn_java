package day15.Demo06_Monitoring_SalesDateForAStrore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * this is a demo for date and time calculation, 
 * this is a very comprehensive demo, and this is 
 * a frequent used case
 * 
 * @author patrickyu
 *
 */
public class Demo06_Monitoring_SalesDateForAStrore {
	
	public static void main(String[] args) throws ParseException {
		System.out.println("please input your production date: ");
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
		System.out.println("please how many days it could stay fresh: ");
		int day = scanner.nextInt();
		scanner.close();
		String dat = getDate(date,day);
		System.out.println("The sales day is: " + dat);
	}
	
	/**
	 *  according the production date and sell-by date to calculate your sales date for such product
	 *  sales day always goes 2 or 3 weeks before sell-by date
	 *  @param date production date   yyyy-MM-dd
	 *  @param day difference between production date and sell-by date
	 *  @return salesDay   yyyy-MM-dd
	 *  @throws ParseException 
	 *  
	 */
	
	public static String getDate(String date, int day) throws ParseException{
		/**
		 *  1. using simple dateFormat to convert date string to real Date object
		 *  2. convert Date object to calendar
		 *  3. add 2 week before sell-by date
		 *  4. subtract 2 weeks off
		 *  5. set Calendar to be Wednesday to be our sales date
		 *  6. convert calendar to be Date object
		 *  7. Convert Date object to a SimpleDateFormat String and return
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateData = formatter.parse(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateData);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
//		calendar.add(Calendar.DAY_OF_YEAR, -14);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		dateData = calendar.getTime();
		String str = formatter.format(dateData);
		return str;
		
	}
}
