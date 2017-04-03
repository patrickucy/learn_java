package day07;

import java.util.Arrays;

/*
 * Arrays.binarySearch()
 * 在未排序的数组上就不应该用二分查找!
 * 
 */
public class Demo04_Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Arrays.binarySearch(a, key)
		String[] motels = {"Tom","Andy","John","Jerry","Nemo"};
		// 在未排序的数组上使用binary search 是不对的!找不到就返回负数
		Arrays.sort(motels);
		int index = Arrays.binarySearch(motels, "Andy");
		System.out.println(index); //但是你这个时候查到的index是排序后的index而不是排序前的那个index

	}

}
