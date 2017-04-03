package day07;

import java.util.Arrays;

/*
 * Arrays.sort() 排序方法
 */
public class Demo03_Arrays_sort {

	public static void main(String[] args) {
		String[] names = {"Tom","Andy","John","Jerry","Nemo"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
	}

}
