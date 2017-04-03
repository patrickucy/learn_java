package day10.Demo09_Final_Method;
/*
 * final method can't be override by any subclasses
 * 
 * however this is very rare in real implementation 
 */
public class Demo09_Final_Method {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


class Xoo{
	final void t1(){
		
	}
	
	void t2(){
		
	}
}


class Yoo extends Xoo{
//	void t1(){  //compile error here!!!
//		
//	}
	
	void t2(){
		
	}
}