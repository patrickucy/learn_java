package day05;

import java.math.BigInteger;

/*
 * 计算的大整数 阶乘
 * 这个就是当你的数据超过long的时候来使用这个类
 */
public class Demo03_Big_Int_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		BigInteger y = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			//转换int 类型的i成为bigInteger类型, 以你为bigInteger之间需要运算的话,是需要同一种类型的
			BigInteger iBig = BigInteger.valueOf(i); // 直接用类方法转
			y = y.multiply(iBig);
		}
		System.out.println(y);
	}

}
