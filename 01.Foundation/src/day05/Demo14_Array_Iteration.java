package day05;
//数组迭代
public class Demo14_Array_Iteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] score = {66.5,75.7,88,93};
		double sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			
		}
		System.out.println("Sum " + sum);
	}

}
