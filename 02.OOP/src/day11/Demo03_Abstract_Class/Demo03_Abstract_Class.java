package day11.Demo03_Abstract_Class;
/**
 * 
 * @author patrickyu
 * you can use abstract class, protecting your class from instantiation
 * 
 * the purpose of having abstract class is to be inherited !
 */
public class Demo03_Abstract_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		FlyingObject uf0 = new FlyingObject();
		// there will be compile error here, this is the property of abstract class
		
		FlyingObject obj = new Bomb(3, 4, 5);
		System.out.println(obj.shootBy(1, 1));
	}

}


/**
 *  this is a subclass of FlyingObject
 *	inheriting a abstract class, implementing abstract method
 *  The whole purpose of having this is because of business logic
 */
class Bomb extends FlyingObject{
	int radius;
	
	public Bomb(int x, int y,int radius) {
		super.x = x;
		super.y = y;
		this.radius = radius;
	}

	
	/**
	 *  if you don't override this abstract method from your super class
	 *  there will be a compile error
	 */
	@Override
	public boolean shootBy(int x, int y) {
		// TODO Auto-generated method stub
		int a = this.x - x;
		int b = this.y - y;
		return Math.sqrt(a*a + b*b) <= this.radius;
	}
	// it can automatically generate for you in this IDE,
	
	
}







/** FlyingObject is an abstract concept 
 *	then how do we know whether to define it as an abstract class?
 *  when you thinking about something that is really hard to confirm, then it must be an abstract class 
 */
abstract class FlyingObject{
	int x;
	int y;
	
	
	/** you add a "abstract" keyword here, then you don't need to implement the detail of such method
	 *  what it means is that this is the feature we need to have, however, we just can't specify it
	 *  right here at super class, you might need to implement the details when you create a subclass 
	 *  from this one
	 * 
	 */
	public abstract boolean shootBy(int x, int y);
	
	
	/**
	 *  in abstract class, you can also define a specific method with implementation
	 */
	public void moveTo(int x, int y){
		this.x = x;
		this.y = y;
	}
}