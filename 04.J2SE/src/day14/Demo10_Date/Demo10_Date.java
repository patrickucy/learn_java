package day14.Demo10_Date;
/**
 * manipulating date
 */
import java.util.Date;

public class Demo10_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.currentTimeMillis();
		Date now = new Date();
		System.out.println(now); // there is a time difference here, you need to somehow adjust it to your location
		long millisecond = now.getTime(); // getting a millisecond
		System.out.println(millisecond);
		millisecond += 1000 * 60 *60 *24;
		now.setTime(millisecond);
		System.out.println(now);
		// get data, alter data, put back data
		
	}
}
