package day15.Demo07_Method_Argument_Issue;

import java.util.Date;

public class Demo07_Method_Argument_Issue {

	public static void main(String[] args) {
		String str = "";
		doSomething(str);
		
		Date date = new Date();
		doSomething(date);
		
		int i = 0;
		Integer in = new Integer(i); // this is how you convert a primitive type to a Object type
		doSomething(in); 
		/** 
		 *  in fact, in previous version, this primitive type 
		 *  is not a object! however, after java 1.6, it has 
		 *  already convert primitive type to be the subclass 
		 *  of Object. So this is no longer a issue now. 
		 *  
		 *  you need to understand why this is necessary, for polymorphism 
		 *  but now it's already been packaged !! no need to worry about it any more
		 *  
		 *  However, in still have to realize that primitive type is still primitive type
		 *  and Integer type is just a Object-Oriented package for such primitive type
		 */
		
	}
	
	public static void doSomething(Object obj){
		
	}
}


class Integer{ // it's like putting a Obejct type shell to primitive type
	int i;
	public Integer(int i){
		this.i = i;
	}
	
	public int intValue(){
		return this.i;
	}
}