package day03;
/*
 * 浮点精度不够高
 */
public class Demo01_Float {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0x7fffffff;
		int b = 0x7ffffff0;
		System.out.println(max-b);

		float f = max;
		float fb = b;
		
		System.out.println(f-fb);
		System.out.println(max);
		System.out.println(b);
		System.out.println(f);
		System.out.println(fb);

		double d = max;
		double db = b;
		System.out.println(d-db);
		//默认的小数,字面量(直接量)都是double型
		//直接量(字面量):直接写出的常数!
		//如 3.14 5 8.8 'a' 3.14F
		//以f后缀为结尾的是float字面量
		//以d后缀为结尾的是double字面量
		//以1后缀为结尾的是long字面量
		double pi = 3.1415926535897;
		float f1 = 3.14f;
		
		
		System.out.println(pi); //精度比float高2倍
		System.out.println(f1);
		
		double dx=2.6;
		System.out.println(dx-2); //不精确的结果,浮点数特性
		
		double y = Math.sin(pi);
		System.out.println(y); //接近于0的数
		System.out.println(y==0); // false
		System.out.println(y<0.00000000001); // true 比较结果是零
	}

}
