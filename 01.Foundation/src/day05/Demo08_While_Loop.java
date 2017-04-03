package day05;
/*
 * while 语句
 * while 语句 一般用来处理和次数无关的训话
 *  while ( 循环条件({
 *  }
 */
public class Demo08_While_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 65721;
		int sum = 0;
		while (num != 0) {
			int last = num % 10;
			sum = sum*10 + last;
			num /= 10;
			System.out.println(num + "," +last+","+sum);
		}
		System.out.println(sum);
	}

}
