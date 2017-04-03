package day08;
/*
 * java的类中一定有构造器
 */
public class Demo05_Constructor_Default_and_Customized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo foo = new Foo();
//		Koo koo = new Koo(): //这里有编译错误,证明系统就把默认构造器给剔除了
		Koo koo = new Koo(5);
			
	}

}

//Javac 会自动添加默认构造器 Foo()
class Foo{
	//不写构造器,就有默认构造器
}


//Koo() 中没有默认构造器Koo()
class Koo{
	//写了自己的构造器,语言就不提供默认构造器了
	public Koo(int a){
		System.out.println("Koo(int)");
	}
}