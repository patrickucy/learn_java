package day07;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * Array.equals() 比较两个数字序列是否相同
 */
public class Demo02_Array_equals {

	public static void main(String[] args) {
		char[] answer = {'A','B','D'};
		char[] input = {'A','B','C','D'};
		boolean pass = answer.equals(input);
		System.out.println(pass); //false
		
		input = new char[]{'A','B','D'};
		pass = Arrays.equals(answer, input);
		System.out.println(pass);
		
		input = new char[]{'A','D','B'};
		pass = Arrays.equals(answer, input);
		System.out.println(pass);
		
		Arrays.sort(input);
		pass  = Arrays.equals(input, answer);
		System.out.println(pass);
		
	}

}
