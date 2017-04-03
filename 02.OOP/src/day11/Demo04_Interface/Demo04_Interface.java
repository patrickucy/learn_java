package day11.Demo04_Interface;
/*
 * interface semantic
 *   1) java is a programming language, inheriting only one superclass. 
 *   every class can only have one superclass
 *   
 *   2) java is using interface achieving the goal of multiple-inheritance. it indicates a concept, is this and is that
 *   example: Cat is a Hunter and a Runner
 *   
 *   3) when you defining a property in an interface, that property must be a constant
 *   it automatically ignores "public static final", however, you can still add it there with no errors 
 *  
 *   4) when you defining a method in an interface, that method must be a abstract method 
 *   -> just declaration, no implementation 
 *   it automatically ignores "public abstract". you can still add it there 
 *  
 *   
 *   5) interface can be used as a super class type defining a variable referring a subclass -> Polymorphism 
 *   
 *   6) when calling interface methods, we can just do it" as overriding principles", 
 *   implement its subclass methods
 *   
 *   7) you can just create a new instance of an interface, because basically, it's an abstract class
 *     
 */
public class Demo04_Interface {

	public static void main(String[] args) {
//		Hunter h = new Hunter(); 
		// there will be compile error here, because abstract class can't be instantiated
		
		Cat cat = new Cat();
		Hunter hunter = cat;
		Runner runner = cat;
		hunter.hunt();
		System.out.println(runner.maxSpeed());

	}

}

/** interface == abstract class
 */
interface Runner{
	// we always use uppercase words to indicate constant
	
	// even though you don't specify these three description, they are still there
	/*public static final */int DEFAULT_SPEED = 100; //
	// even thout you don't specify these two description, they are still there
	/*public abstract */int maxSpeed();
	
}


/** interface can be inherited
 */
interface Hunter extends Runner{
	void hunt();
}

/** here it means Car is a specific class, implementing  both interfaces from "Hunter" and "Runner"
 *  it indicates that Cat is Hunter and can be Runner, thus, we achieve the concept of multiple-inheritance
 */
class Cat implements Hunter,Runner{// just like OC, conforming multiple protocols

	@Override
	public int maxSpeed() {
		// TODO Auto-generated method stub
		return DEFAULT_SPEED;
	}

	@Override
	public void hunt() {
		// TODO Auto-generated method stub
		System.out.println("Cat catches mouse");

	}
	
}