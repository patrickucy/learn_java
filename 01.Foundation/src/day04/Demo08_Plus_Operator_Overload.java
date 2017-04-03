package day04;
/*
 * + 运算是java中唯一的一个"重载"运算符
 * "重载"是名字一样,功能不同的运算
 * + 名字一样,但是两种功能
 *  一种是数学运算,一个是字符串的连接
 */
public class Demo08_Plus_Operator_Overload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		System.out.println(c+'1');
		System.out.println(c+"1");
		System.out.println(1+2+"A");
		System.out.println(1+2+'A');
		System.out.println('1'+'2'+"A");
		System.out.println("1"+'2'+'A');
		System.out.println('1'+"2"+"A");
		// 这里把'X'去字符的这个符号看成int就好了,不要把它当成字符串了,实际上类型根本不同


	}

}
