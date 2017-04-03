package day04;
/*
 * 1970年到现在的毫秒数
 */
public class Demo10_Time_Since_1970 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Millisecond 毫秒
		long now = System.currentTimeMillis(); //1970 年到现在的毫秒数
		System.out.println(now);
		
		long year = now/1000/60/60/24/365 + 1970;
		System.out.println(year);
		long max = 0x7ffffffffffffffL;
		year = max / 1000/60/60/24/365 + 1970;
		System.out.println(max);
		
	}

}
