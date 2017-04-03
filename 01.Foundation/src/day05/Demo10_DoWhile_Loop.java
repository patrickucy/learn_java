package day05;

import java.util.Scanner;

/*
 * do while
 */
public class Demo10_DoWhile_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		int score;
		do {
			System.out.println("Input you percentage: ");
			score = console.nextInt();
		} while (score <0 || score > 100);
		System.out.println("Input percentage" + score);
	}

}
