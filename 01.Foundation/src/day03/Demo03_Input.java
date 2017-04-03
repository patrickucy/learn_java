package day03;

import java.util.Scanner;

/*
 * 已知距离,还是求重力题
 */
public class Demo03_Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.print("input your fall distance: ");
		
		
		double s = console.nextDouble();
		double g = 9.8;
		double t = Math.sqrt(2*s/g);
		System.out.println("your falling time is " + t + " Seconds");
	}

}
