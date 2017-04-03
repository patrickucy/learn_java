package day03;
/*
 * ++ --运算
 */
public class Demo10_PlusPlus_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		a++;
		System.out.println(a);
		++a;
		System.out.println(a);
		//表达式的值不一样(a++) 这个整体成为表达式
		// 变量是a
		a = 1;
		System.out.println(a++);//输出a++表达式的值
		System.out.println(a); //输出变量a的值
		
	}
}
