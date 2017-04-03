package day07;

import java.util.Arrays;
import java.util.Random;


/*
 * 排序性能比较
 */

public class Demo10_sort_efficiency {

	public static void main(String[] args) {
		int[] array1 = new int[10000]; //十万的数组就已经很大了啊!
		Random random = new Random();

		for (int i = 0; i < array1.length; i++) {
			array1[i] = random.nextInt();		
		}
		System.out.println(Arrays.toString(array1));
		int[] array2 = Arrays.copyOf(array1, array1.length);
		int[] array3 = Arrays.copyOf(array1, array1.length);

		System.out.println(Arrays.equals(array1, array2));
		
		long time1 = System.currentTimeMillis();
		System.out.println(time1);
		Arrays.sort(array1);
		long time2 = System.currentTimeMillis();
		System.out.println(time2);
		Demo09_bubble_sort.bubbleSort(array2);
		long time3 = System.currentTimeMillis();
		System.out.println(time3);
		Demo08_insertion_sort.insertionSort(array3);
		long time4 = System.currentTimeMillis();

		
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);

		//以后就可以通过运行时间来比较方法的运行性能
		System.nanoTime();
		//也可以通过纳秒级来比较方法之间的性能
		
	}

}
