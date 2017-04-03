package day04;

public class Demo02_Logic_Operator2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'B';

		if ((c>='A' && c<='Z') || (c>='a' && c <= 'z')) {
			System.out.println(c+" is an English character");
		}else {
			System.out.println(c+" is not an English character");
		}
	}
}
