package day04;
/*
 * 逻辑运算符,短路与非短路判断运算
 */
public class Demo03_Logic_Operator_In_Detail {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char sex = 'M';
		int age = 25;
		
		if (sex == 'F' && age++ >= 60) { //这里就是短路逻辑,如果第一个false,age肯定没有执行过
			System.out.println("Welcome to our gym");
		}else {
			System.out.println("Capacity is full, see you tomorrow");
		}
		System.out.println(age);
		
		
		/*********************(非短路逻辑)****************************/
		if (sex == 'F' & age++ >= 60) { //这里就是短路逻辑,如果第一个false,age肯定没有执行过
			System.out.println("Welcome to our gym");
		}else {
			System.out.println("Capacity is full, see you tomorrow");
		}
		System.out.println(age);
		//从console你就会发现最后的结果是不一样的,这里就可以看出短路逻辑和非短路逻辑的不同
	}
}
