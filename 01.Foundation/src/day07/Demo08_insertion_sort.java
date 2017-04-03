package day07;

import java.util.Arrays;

/*
 * 插入排序
 * 
 * 
 *  10	4	6	5	3	8
 *  0	1	2	3	4	5
 *  就像玩牌的时候,把小的牌往左面排
 *  4	10	6	5	3	8
 *  0	1	2	3	4	5
 *  
 *  4	6	10	5	3	8
 *  0	1	2	3	4	5
 *  
 *  4	5	6	10	3	8
 *  0	1	2	3	4	5
 *  i 代表现在在右边待插入元素的位置,
 *  j 代表已经排好的数
 *  k 作为一个临时存储
 * 
 * 
 */
public class Demo08_insertion_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,4,6,5,3,8};
		System.out.println(Arrays.toString(arr));
		Demo08_insertion_sort.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	// 插入排序(经典插入式排序,基本上完全不用改直接可以用
	public static void insertionSort(int[] arry){
		int i,j,k;
		for (i = 1; i < arry.length; i++) { //因为你要从第二个元素开始比较
			k = arry[i]; //取出
			for (j = i-1; j >= 0 && arry[j] > k; j--) { //中间是终止条件
				arry[j+1] = arry[j];
			}
			arry[j+1] = k;
		}
	}

}
