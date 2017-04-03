package day04;
/*
 * 短路 或运算
 */
public class Demo04_Short_Cut_Or_Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char sex = 'F';
		int age = 66;
		if (sex == 'F' || age++ >= 60) {
			System.out.println("Welcome");
		}else {
			System.out.println("Thank you");
		}
		System.out.println(age); //66 表示发生了短路运算
		
		
		
		/********************/
		if (sex == 'F' | age++ >= 60) {
			System.out.println("Welcome");
		}else {
			System.out.println("Thank you");
		}
		System.out.println(age); //67 表示发生了短路运算
		
		
		
		
		
		
	}

}
