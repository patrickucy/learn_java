package day05;
/*
 * 计算
 * y  = 9 + 99 + 999 + 9999  ...
 * i  = 1   2      3    4    n
 * n  = 9   99    999   9999 ...
 *      9  9*10+9  99*10+9  ... (n-1)*10 +9
 *       
 *       */
public class Demo05_For_Loop_Application {

	public static void main(String[] args) {
		int n = 6;
		long num = 9;
		long sum = 0;
		for (int i = 1 ; i <= n; i++) {
			num = num* 10 +9;
			sum += num;
			//跟踪语句,用于跟踪运行期间变量的值,说白了就是把每一步都给输出出来就好了,这样方便查找
			System.out.println(i+","+num+","+sum);
		}
		System.out.println(sum);
	}

}
