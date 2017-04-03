package day07;

import java.util.Random;
import java.util.Arrays;
/*
 * Array API
 * toString() 方法是变数组为字符串
 * 这个方法可以便捷的输出数组的内容
 */
public class Demo01_Array_toString {

	public static void main(String[] args) {
		int[] ary = {1,2,3,4,5,6,7,8};
		Random r = new Random();
		for (int i = ary.length - 1; i >=1 ; i--) {
			int j = r.nextInt(i);
			int t = ary[i];
			ary[i] = ary[j];
			ary[j] = t;
		}
		String str = Arrays.toString(ary);
		System.out.println(str);
		
	}

}
