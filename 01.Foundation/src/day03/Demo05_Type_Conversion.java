package day03;
/*
 * 自动类型转换
 */
public class Demo05_Type_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		long l = i; //内存中,实际上是把32位的数字的前面所有的零都加上了变成了64位的数据
		i = -1;
		l = i;
		//上面的都是自动类型转换,按照符号位进行填充
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Long.toBinaryString(l));
		//toBinaryString(long l) 在参数传递的时候,自动类型转换
		//隐式数据类型转换
		System.out.println(Long.toBinaryString(i));

		byte b = -2;
		System.out.println(Integer.toBinaryString(b));
	}

}
