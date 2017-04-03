package day09;
/*
 * 继承的时候,对象的初始化顺序
 */
public class Demo05_Initialization_sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coo c = new Coo();
		System.out.println(c.a+","+c.b+","+c.c);
	}

}


class Coo extends Boo{
	int c = 10;
	public Coo(){
		super();
		a=1;
		b=2;
		c=3;
		System.out.println("a="+a+","+"b="+b+"c="+c);

	}
}

class Boo extends Aoo{
	int b = 6;
	public Boo(){
		super(); //属性初始化
		this.a = 8;
		this.b = 9;
		System.out.println("a="+a+","+"b="+b);
	}
}

class Aoo{
	int a = 5;
	public Aoo(){
		this.a = 6; //属性初始化
		System.out.println("a="+a);
	}
}