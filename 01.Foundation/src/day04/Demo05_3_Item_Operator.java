package day04;

import java.util.Scanner;

public class Demo05_3_Item_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("input you quantity for searching results");
		int rows = console.nextInt();
		int size = 10;
		int pages;
		
		pages = rows%size == 0 ? rows/size : rows/size+1;
		System.out.println("pages:"+pages);
		
	}

}
