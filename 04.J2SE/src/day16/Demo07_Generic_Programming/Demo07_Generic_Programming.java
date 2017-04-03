package day16.Demo07_Generic_Programming;
/**
 * Generic programming
 * and we have to use reference type!!!to be the generic type!!!
 * 
 *  dynamically specifying data types for our object
 *  
 *  in fact Generic programming is a fake !!!
 *  its core theory is still casting ! you just specify 
 *  what kind of data type you want to cast
 *  
 *  
 *  you can specify multiply generic types, the name should start with letters!
 *  
 * @author patrickyu
 * @param <X>
 * @param <Y>
 *
 */
public class Demo07_Generic_Programming {

	public static void main(String[] args) {
		Point<Integer> point = new Point<Integer>(1,2);
		System.out.println(point);
		
		
		Point<Double> point2 = new Point<Double>(1.2,3.2);
		System.out.println(point2);
		
		
		Point<String> point3 = new Point<String>("2.12","32.3");
		System.out.println(point3);
		
		
		Point point4 = new Point(1,2); 
		/**
		 *  even you don't specify data type, it still works, its default is "Object"
		 *  normally we will specify the data type
		 */
		
		
	}
}

class Point<E> {
	private E x;
	private E y;
	
	public Point(E x, E y) {
		super();
		this.x = x;
		this.y = y;
	}
	public E getX() {
		return x;
	}
	public void setX(E x) {
		this.x = x;
	}
	public E getY() {
		return y;
	}
	public void setY(E y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}


class Point2<X,Y> { // can specify respectively
	private X x;
	private Y y;
	@Override
	public String toString() {
		return "Point2 [x=" + x + ", y=" + y + "]";
	}
	public Point2(X x, Y y) {
		super();
		this.x = x;
		this.y = y;
	}
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	public Y getY() {
		return y;
	}
	public void setY(Y y) {
		this.y = y;
	}
	
	
}

