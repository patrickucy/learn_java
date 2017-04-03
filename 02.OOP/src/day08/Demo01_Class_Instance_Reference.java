package day08;
/*
 * class, instance, reference
 * declaration of a class
 * create a object
 * declare variables and assign 
 */
public class Demo01_Class_Instance_Reference {

	public static void main(String[] args) {
		Cell c1 = new Cell(); 	// new Cell() 创建了对象
		// 实际作用就是在内存中分配内存大小,跟OC里面的alloc init 一模一样
		// 实际上就是根据对象的属性类型来分配内存空间,并且都赋上初始值,然后返回对象的首地址,通常也就是赋给一个引用变量
		// java把指针完全封装起来了,只有引用可以用
		// 然后这个引用变量一旦被引用了,那么他的属性里面的变量,就变成了我们的instance variable
		
		Cell c2 = new Cell();	// 赋值 = 是将对象的首地址赋值给变量
		// c1 c2 是引用类型变量,分别引用了两个对象
		
		c1.row = 2;
		c1.column = 3;
		c1.color = 0x0000ff; 	//blue
		c2.row = 2;
		c2.column = 4;
		c2.color = 0xff0000;	//red
		System.out.println(c1.row + "," + c2.row);
		
		c1.drop();	// 方法的调用 call a message
		c2.drop();	// 使用引用变量调用对象的方法
		System.out.println(c1.row + "," + c2.row);
		
		c1.drop(2);	// 重载方法的调用
		c2.drop(2);
		System.out.println(c1.row + "," + c2.row);

	}
	
}

//你不能在上面那个Demo01的class 里面定义你自己的这个Cell class
//declare a "Cell" class
class Cell{
	// Properties: variables declared within a class
	int row;
	int column;
	int color;
	
	public void drop(){	//Method declaration
		this.row++;		// 方法, 在这里其实也是算法,只不过很简单而已
	}
	
	public void drop(int step){//这样一来就是实现了方法的重载,(只是参数的区别) 实际上跟C++的实现原理是一模一样的
		this.row += step;
	}
	
	
}














