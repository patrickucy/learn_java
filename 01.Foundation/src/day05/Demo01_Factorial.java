package day05;
/*
 * 计算阶乘
 *  y = 1*2*3...n
 */
public class Demo01_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		long y = 1; //如果这里用int就会数据溢出
		//for循环可以定义一个序列变量
		for (int i = 1; i <= n; i++) {
			y *= i;
		}
		System.out.println(y);
		
	}
}
