package day15.Demo04_Overflow_Problem_For_SettingTime;

import java.util.Calendar;

public class Demo04_Overflow_Problem_For_SettingTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 32);
		
		/**
		 *  as you can see here, even though you set a overflow value for a month, it's still valid
		 *  the algorithm behind it can handle this situation, it will automatically jumps to the 
		 *  corresponding position of the next month. And of course, it works for year, weak,day and etc
		 *  
		 */
		System.out.println(calendar.getTime());
	}

}
