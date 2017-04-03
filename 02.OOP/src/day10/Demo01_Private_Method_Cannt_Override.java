package day10;
/*
 * 私有的方法是不可以重写的
 * 
 * 当你看到结果你就会发现,私有的superclass的Method被调用了,
 * 实际上this就是就近原则的先调本类的private,再去调public的方法
 * 这也是为什么重写一定要父子类都要声明称public的方法
 * 
 * 这也就说明私有的方法并没有被重写,还是可以被调用的
 * 
 * 重写的方法都是调用被引用对象的方法也就是这里的t()
 * 
 */
public class Demo01_Private_Method_Cannt_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Sub();
		s.demo();
	}

}


class Super{
	public void demo(){
		this.test();
		this.t();
	}
	
	
	public void t(){
		System.out.println("Super.t()");
	}
	
	
	private void test(){ //其实this就是就近原则的调用,优先调用private的方法,然后调用public的方法
		System.out.println("Super.test()");
	}
}

class Sub extends Super{
	
	public void t(){
		System.out.println("Sub.t()");
	}
	
	public void test(){
		System.out.println("Sub.test()");
	}
}