package day05;
/*
 * 计算PI
 * PI = 4*(1/1 -1/3 + 1/5 -1/7 ... )
 */
public class Demo04_Calculate_PI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000000;
		double sum = 0;
		for (int i = 1; i <= n; i+=4) {
			sum += 1.0/i - 1.0/(i+2);
		}
		double pi = sum * 4;
		System.out.println(pi);
	}

}
