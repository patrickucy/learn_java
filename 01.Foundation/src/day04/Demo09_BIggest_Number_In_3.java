package day04;
/*
 * 三个数求最大值
 */
import java.util.Scanner;

public class Demo09_BIggest_Number_In_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,max;
		Scanner console = new Scanner(System.in);
		System.out.println("Input 3 integers(a,b,c): ");
		a = console.nextInt();
		b = console.nextInt();
		c = console.nextInt();
		
		max = a > b ? a : b;
		max = max > c ? max : c;
		System.out.println("Your maximum value is "+max);
	}

}
