package day04;
/*
 * 
 */
public class Demo01_Logic_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = '5';
		boolean isDigit = c>='0' && c<='9';
		if (isDigit) {
			System.out.println(c+" is a digit character");
		}else {
			System.out.println(c+" is not a digit character");
		}
	}
}
