package day04;

import java.util.Scanner;

/*
 * 个人所得税计算
 */
public class Demo15_Tax_Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Input your salary before taxed :");
		double salary = console.nextDouble();
		double income;
		double tax = 0;
		double taxIncome;
		taxIncome = salary - 3500;
		if (taxIncome<=0) {
			tax = 0;
		}else if (taxIncome <= 1500) {
			tax = taxIncome * (3.0/100);
		}else if (taxIncome <= 4500) {
			tax = taxIncome * 0.1 - 105;
		}else if (taxIncome <= 9000) {
			tax = taxIncome * 0.2 - 555;
		}else if (taxIncome <= 35000) {
			tax = taxIncome * 0.25 - 1005;
		}else if (taxIncome <= 55000) {
			tax = taxIncome * 0.3 - 2755;
		}else if (taxIncome <= 80000) {
			tax = taxIncome * 0.45 - 13505;
		}
		
		income = salary-tax;
		System.out.println("tax: "+ tax +" income: " + income);
	}

}
