package day03;
/*
 *  同种类型数据参与运算,结果为同种类型.
 如果类型不一致,会自动类型转换,再计算
 小于32位数byte.short,chart 按照int计算 

 */
public class Demo08_Auto_Type_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 6;
		int c = a + b; //java是不检查是否溢出的,要避免
		System.out.println(c);
		a = 0x7fffffff;
		
		a = 5;
		b = 2;
		System.out.println(a/b);
		
		double d = 5D/2; //这里把5转成double类型的,这样子才可以正常工作
		System.out.println(d);
		
		double price = 5.99;
		System.out.println(price*(80/100));
		System.out.println(price*(80.0/100));
		
		int max = 0x7fffffff;
		long l = max + 1;
		System.out.println(l);
		l = max +1L;
		System.out.println(l);
		
		byte b1 = 4;
		byte b2 = 8;
//		byte b3 = b1 + b2; //编译错误,int 不能转换为byte
//		byte b3 = (byte)b1 + b2;
		
		byte b3 = (byte)(b1 + b2);//小于32位数( byte
	}

}
