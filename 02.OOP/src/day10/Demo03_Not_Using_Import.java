package day10;
/*
 * 使用全限定名访问 类/属性
 * java.util.Random -> 全限定名  包名.类名
 * 
 * 使用全限定名就不需要使用import语句了
 * 如果,使用import语句,可以省略包名
 * 如果不能区分当钱包的类,和其他包的同名类,就不能省略全限定名
 */
public class Demo03_Not_Using_Import {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//################
		java.util.Random random = new java.util.Random();
		System.out.println(random.nextInt(5));
		//这么做就是不需要import
		
		
		java.util.Timer t1 = new java.util.Timer();
		javax.swing.Timer t2;
		//基本上,上面这样的事情是不会发生的
		//这也是全限定名的优势
		
		day10.Koo koo = new day10.Koo();
		
	}

}


class Koo{
	int a;
	public Koo(){
		//day10.Koo.this.a 是属性变量的全限定名,
		//只有当区别不开的时候才用这样的名字,一般情况下当然是能区别开的
		System.out.println(day10.Koo.this.a);
	}
}