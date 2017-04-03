package day04;
/*
 * else if 语句
 */
public class Demo14_If_Else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 68;
		if (score >= 90) {
			System.out.println("A");
		}else if (score >= 80) {
			System.out.println("B");
		}else if (score >= 70) {
			System.out.println("C");
		}else if (score >= 60) {
			System.out.println("D");
		}else{
			System.out.println("E");
		}
	}

}
