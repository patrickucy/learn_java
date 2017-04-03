package day15.Demo13_Big_Integer;

import java.math.BigInteger;

/**
 * factor
 * @author patrickyu
 *
 */
public class Demo13_Big_Integer {
	
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("1");
		sum = BigInteger.valueOf(1);
		for (int i = 2; i < 200; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		System.out.println(sum);
	}
}
