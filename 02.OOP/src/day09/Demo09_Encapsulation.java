package day09;
import day09.sub.Demo10_Properties_Access_Scope;
/*
 * 访问控制与权限
 */
public class Demo09_Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doo doo = new Doo();
//		System.out.println(doo.a);  //这里就已经出现编译错误了,a不可见
//		System.out.println(doo.x);  //x is not a field
		System.out.println(doo.b);  //b 在同一个package里面,所以是可以访问的
		System.out.println(doo.c);  //c 可以看见,同上
		System.out.println(doo.d);  //d 就是那里都可见的,任意可见
		System.out.println(doo.getA()); //虽然a是不可见的,但是getA()的这个方法是可见的,只能读,不能写了这样子写
		
		//java 建议私有属性,公有访问方法 getA setA,这样子就可以通过方法来达到读写限制分开的目的

		//b c 这里还是没有体现出区别出来 
		
		
		Demo10_Properties_Access_Scope foo = new Demo10_Properties_Access_Scope();
//		System.out.println(foo.a);  //因为私有外部不可见
//		System.out.println(foo.b);  //这里也有编译错误了,因为跨package了,所以出现错误
//		System.out.println(foo.c);  //这里也是因为出现了跨package了,所以出现了编译错误
		System.out.println(foo.d);  //公共的,就是到处可见
		System.out.println(doo.getA()); 

	}

}

class Eoo extends Demo10_Properties_Access_Scope{
	public void test(){
		//使用super访问 在父类 Demo10 中定义的 abcd
//		System.out.println(super.a);  //因为私有->编译错误
//		System.out.println(super.b);  //因为Eoo 和 Demo10 不在一个包
		System.out.println(super.c);  //这里可见是因为子类就是能够看到父类protected的属性
		System.out.println(super.d);  

	}
}





class Doo{
	private int a = 3;
	int b = 4;
	protected int c = 5;
	public int d = 6;
	
	public int getA(){
		return a;
	}
}

