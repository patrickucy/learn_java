package day07;

public class Demo12_Fibonacci_Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(10);
		System.out.println(f(10));
	}
	
	public static long f(int n){
		long f1, f2, fn;
		f1 = f2 = fn = 1;
		for (int i = 3; i < n; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}
		return fn;
	}
	
	// 虽然优雅,但是性能比较差
	// 你会发现 递归会有大量冗余的和反复的计算,而上面的循环就没有,就是 O(n) 的时间复杂度度
	public static long f1(int n){
		if(n==1 || n ==2){
			return 1;
		}
		return f1(n-1) + f1(n-2);
	}
}
