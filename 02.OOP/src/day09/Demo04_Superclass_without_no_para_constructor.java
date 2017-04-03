package day09;

public class Demo04_Superclass_without_no_para_constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subclass2 sub = new Subclass2();
	}

	
	
}

class Subclass2 extends Superclass2{
	//编译错误,父类没有无参数构造器,所以就没办法默认调用了,
	
	//当你用super 这样子就可以调用父类的构造器了,
	Subclass2(){
		super(8);//而且必须写在子类构造器的第一行,只能子类调用,并在
	}
}

class Superclass2{
	public Superclass2(int a){
		System.out.println("superclass("+a+")");
	}
}