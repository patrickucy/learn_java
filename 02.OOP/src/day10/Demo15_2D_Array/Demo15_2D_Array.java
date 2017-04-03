package day10.Demo15_2D_Array;
/*
 * 2-D array
 * 		1) in java, there is no 2-D array per se! 
 * 		In fact, 2-D array in java is an one dimensional array consisting 1-D arrays as its elements.
 */
public class Demo15_2D_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {4,5,6};
		int[] a2 = {5,6,7};
		int[] a3 = {7,8,9,10};
		
		// 2-D array
		int[][] ary = {a1,a2,a3}; //static initialization
		int[][] ary2 = new int[][]{a1,a2,a3}; // dynamic initialization
		int[][] ary3 = new int[3][2];
		// in fact, there is no such 2-D arrays in java, they are per se, 1-D arrays !!!!
		
	}

}

