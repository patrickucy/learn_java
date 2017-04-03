package day17.Demo17_Template_Pattern;
/**
 * Template pattern
 * -> just abstract class
 * @author patrickyu
 *
 */
public abstract class Person {
	/**
	 *  say hello, we just define the process
	 *  and let subclass to implement this method, of course, 
	 *  some uniform operations can be implemented here
	 *  
	 */
	public void sayHello() {
		System.out.println("hello everyone");
		sayName();
		sayInfo();
		System.out.println("good bye");
	}
	
	public abstract void sayName();
	public abstract void sayInfo();
	

}
