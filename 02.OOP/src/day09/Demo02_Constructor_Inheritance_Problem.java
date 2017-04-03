package day09;
/*
 * 构造器是不能继承的 
 */
public class Demo02_Constructor_Inheritance_Problem {

	public static void main(String[] args) {
//		Foo foo = new Foo(); //编译错误,Foo没有定义构造器Foo()
		//也说明Foo 类没有继承Koo的无参数构造器 Koo()
		Foo foo = new Foo(3);
		
	}

}




class Koo{
	public Koo(){
		
	}
}

class Foo extends Koo{
	public Foo(int a){
		
	}
}