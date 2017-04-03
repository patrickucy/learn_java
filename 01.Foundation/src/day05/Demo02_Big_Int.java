package day05;

import java.math.BigInteger;
/*
 * 大整数处理
 */
public class Demo02_Big_Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num1 = new BigInteger("1234");
		BigInteger num2 = new BigInteger("7489127498327498127348937294178923748912374972134987480000000000");
		BigInteger num3 = num1.add(num2);
		System.out.println(num3);
		
		System.out.println(num2.multiply(num3));

	}

}
