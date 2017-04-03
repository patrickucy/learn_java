package day06;
/*
 * Fibonacci 数列 第n项
 * 第n项等于前两项和,
 * 1 1 2 3 4 8 12 21 ...
 * 你也会发现前面一项除以后面一项是0.618,也就是黄金比例
 * 
 * 第n项 等于 前两项和
 * 1	1	2	3	5	8	12	21 ...
 * 1	2	3	4	5	5	7	8 ...
 * f1	f2	fn
 * 		f1	f2	fn
 * 			f1	f2	fn
 * 				f1	f2	fn
 * 					f1	f2	fn
 * 						f1	f2	fn 
 * 							...
 * 
 */
public class Demo04_Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(8));
		System.out.println((double)fibonacci(50)/fibonacci(51));
	}
	
	
	//计算Fibonacci数列的第n项
	public static long  fibonacci(int n) {
		long f1, f2, fn;
		f1 = f2 = fn = 1;
		for (int i = 3; i <= n; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
			
			
		}
		return fn;
	}

}
