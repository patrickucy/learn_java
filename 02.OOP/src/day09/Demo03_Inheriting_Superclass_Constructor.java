package day09;
/*
 * 1) 类一定有构造器
 * 2) 子类一定调用父类的构造器
 *  2.1) 子类默认调用父类的无参数构造器
 *  2.2) 子类可以使用super()调用父类构造器
 */
public class Demo03_Inheriting_Superclass_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subclass sub = new Subclass();
		// 输出结果: A.无  B.Moo() C.运行异常  D.编译错误
	}

}


class Subclass extends Superclass{
//	public Subclass(){ //这些都是默认添加的
//		super(); // 也就是说这个super()的父类构造器是自动调用的,如果你不写自己的constructor的话
//		// 这也是很正常的,假设你不告诉子类应该怎么初始化,然后java又必须初始化,那么它就只有调用父类的初始化
//	}
}

class Superclass{
	public Superclass(){
		System.out.println("Superclass()");
	}
}


