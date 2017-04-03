package day09;
/*
 * 这是一个非常经典的案例,把多态也展示出来了,
 * overload是根据参数类型调用,
 * override根据运行期间引用的类型调用
 */
public class Demo08_Override_And_Overload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Too too = new Too();
		
		Super obj = new Sub();
		
		//根据参数的变量类型,调用重载的t(Super) 方法 (obj的变量类型是super)
		//与obj引用的对象类型无关 (引用的类型是Sub)
		//也就是你声明成变量为什么类型,语言就根据对应的类型进行调用,不管这个变量具体引用了什么类型
		too.t(obj);
		
		
	}

	
	
}


class Too{
	public void t(Sub obj){
		System.out.println("Too.t(Sub)");
		obj.t();
	}
	
	//根据上面的内容,发现一定是执行这个方法,
	public void t(Super obj){
		System.out.println("Too.t(Super)");
		obj.t(); //!!!!!虽然这里变量的类型是super,但是它的引用的对象是sub类型的,所以真正调用的时候还是调用的sub类型的method
		//重写的方法:调用规则是执行运行期间对象类型饿方法
	}
	
	//这两个方法就是overload,重载
	
}



//重写就是父子类之间,重载是在同一个类里面
class Super{
	public void t(){
		System.out.println("Super.t()");
	}
}

class Sub extends Super{
	//这样就叫做override重写
	public void t(){
		System.out.println("Sub.t()");
	}
}
