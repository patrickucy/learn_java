package day04;

import java.util.Scanner;

/*
 * 闰年判断
 * 年份能被4整除,且不能被100整除的是闰年,
 * 年份能被400整除的是闰年
 */
public class Demo11_Leap_Year {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Input your year");
		int year = console.nextInt();
		boolean isLeapYear;
		
		isLeapYear =  ( (year%4 == 0 && !(year % 100 == 0)) || (year % 400 == 0));
		if (isLeapYear) {
			System.out.println(year + " is a leap year");
		}else {
			System.out.println(year + " is not a leap year");
		}
		
	}

}
