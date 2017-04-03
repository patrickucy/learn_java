package day04;
/*
 * 排序 a b 
 */
public class Demo12_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 3;
		if (a > b) {
			int t = a;
			a = b;
			b = t;
		}
		
		System.out.println(a+","+b);
	}

}
