package day07;
/*
 * 移位运算
 * 
 * 移位运算的数学意义
 * 214343. 小数点向右移动两位,21434300.数值相当于增加了两个数量级,就是乘以了两个 10
 * 假设小数点不动,相当于数字向左移动!
 * 10 进制数字向左移动一次,就是原数字乘以一次10
 *
 * 二进制数字向左移动1次,就是原数字乘以一次基数2
 * 所以一位就是2的乘法,反之就是除法
 */
public class Demo13_Bit_Operation {

	public static void main(String[] args) {
		int num = -8;
		System.out.println(Integer.toBinaryString(num));
		int n = num<<1;
		System.out.println(Integer.toBinaryString(n));
		n = num>>1;
		System.out.println(Integer.toBinaryString(n));
		n = num>>>1;
		System.out.println(Integer.toBinaryString(n)); //这种情况并不是少了一位,而是这个数的前面补了一个零,然后不需要显示出来了
		// >>> 感觉两种位移没什么区别
		n = num << 20;
		System.out.println(Integer.toBinaryString(n));
		n = num >>> 20;
		System.out.println(Integer.toBinaryString(n));
		// 数学位移运算,符合数学规律!
		System.out.println(num<<1); // -16
		System.out.println(num<<2); // -32
		System.out.println(num>>1); // -4
		System.out.println(num>>2); // -2
		// >>> 是逻辑右移动,负数不符合数学规律!
		System.out.println(num>>>1); // -2
		//上面就是位运算的最大的不同和意义
		
		//经典面试题: 如何快速实现num*8
		//n = num << 3;
		System.out.println(5>>1); // -2

		
		
		

	}

}
