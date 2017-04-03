package day07;

import java.util.Arrays;

/*
 * bubble sort
 */
public class Demo09_bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,4,6,5,3,8};
		System.out.println(Arrays.toString(arr));
		Demo09_bubble_sort.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

		
	}
	
	public static void bubbleSort(int[] arry){
		for (int i = 0; i < arry.length - 1; i++) {
			for (int j = 0; j < arry.length - i -1; j++) {
				if (arry[j] > arry[j+1]) {
					int temp;
					temp = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = temp;
				}
			}
		}
	}

}

