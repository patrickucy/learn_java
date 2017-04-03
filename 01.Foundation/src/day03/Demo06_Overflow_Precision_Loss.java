package day03;
/*
 * 
 */
public class Demo06_Overflow_Precision_Loss {

	public static void main(String[] args) {
		long l = 5;
//		int i = l; //编译错误,long变量不能直接赋值int, 也就是大类型不能转换成小类型
		int i = (int)l; //除非你做这种强制类型转换,直接把精度给丢失了这样子赋值过去
		System.out.println(i);
		//注意溢出的问题 
		l = 0xfae00000005L;
		i = (int)l; //这样子就是高位消掉,削足适履
		System.out.println(i);
		
		
		// 精度损失
		double pi = 3.1415926535897932384;
		float f = (float)pi;
		System.out.println(pi);
		System.out.println(f);
	
		//从上面就知道了 溢出就是砍掉头, 精度损失就是砍掉尾
	}

}
