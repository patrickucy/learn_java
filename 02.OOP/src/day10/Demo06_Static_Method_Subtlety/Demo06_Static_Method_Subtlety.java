package day10.Demo06_Static_Method_Subtlety;
/*
 * static method belongs to class method
 * 
 * using class name directly to send message
 * 
 * unrelated to current object, no "this" pointer available, 
 * can't access properties and methods of current object
 * 
 * static method has been widely used as  "tool method", factory method
 * examples:
 * 		Math.sqrt(); Math.sin(); Arrays.sort(); Arrays.toString(); Integer.toHexString(); etc
 * 
 * randomOne() is factory method. it just generates an object for us 
 * 
 * none-static method belongs to object method, there is "this" pointer you can use
 * used for methods that closely related to current object. you can manipulate properties of current object
 * 
 * 
 * just remember one thing that static method just doesn't allow you to use this pointer
 */
public class Demo06_Static_Method_Subtlety {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(3,4);
		Point p2 = new Point(6,8);
		
		//object method
		System.out.println(p1.distance(p2));
		// class method 
		// this static method doesn't have a latent argument this
		// in fact here it creates its own references p1 p2(the same as before) to implement its method
		System.out.println(Point.distance(p1, p2));
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// calculate the distance between this point to other point
	public double distance(Point other){
		int a = this.x - other.x;
		int b = this.y - other.y;
		
		return Math.sqrt(a*a + b*b);
	}
	
	// calculate the distance of such two points
	// static method can't use this pointer!!! -> I think this is how you implement class method
	// as long as the method doesn't relate to your object, you can define it as a static method
	public static double distance(Point p1, Point p2){
		int a = p1.x - p2.x;
		int b = p1.y - p2.y;
		return Math.sqrt(a*a + b*b);
	}
}