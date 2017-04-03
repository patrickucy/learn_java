package day10;
/*
 * instance variable 属性访问时绑定到变量类型,与对象类型无关 -> 也就是说属性是什么,访问出来就是什么
 * override 重写的方法是绑定到对象类型 -> 也就是说动态的观察引用的类型是什么,方法调用出来的就是什么
 * 这里的奇葩的现象是父子类型都具有一模一样的属性,但是属性是不支持override的
 * 
 * 实际上这里的这种现象是极少发生的
 * 
 */
public class Demo02_Property_Method_Binding_Difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cheater c = new Cheater();
		Person p = c;
		System.out.println(p.name +","+ c.name); //直接查真实的属性
		p.whoru(); //只是通过方法来取属性
		c.whoru();
	}

}


class Person{
	String name = "wolf";
	public void whoru(){
		System.out.println(this.name);
	}
}

class Cheater extends Person{
	String name = "lamb";
	public void whoru(){
		System.out.println(this.name);
	}
}