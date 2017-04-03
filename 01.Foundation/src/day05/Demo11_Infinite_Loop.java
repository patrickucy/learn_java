package day05;

import java.util.Scanner;

/*
 * 控制台输入
 * 死循环版本
 */
public class Demo11_Infinite_Loop {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int score;
		while (true) {
			System.out.println("Input your fraction:");
			score = console.nextInt();
			if (score >= 0 && score <= 100) {
				break;
			}
			System.out.println("Opps wrong!");
		}
		System.out.println("Score:" + score);
	}
}
