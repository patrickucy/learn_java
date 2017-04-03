package day17.Demo09_Formal_hashCode_equals_Override;

import java.util.HashSet;
import java.util.Set;

/**
 * if you want to override equals() you have to override hashCode
 * if equals() returns true, then these two objects must return the same hashCode!
 * @author patrickyu
 *
 */
public class Demo09_Formal_hashCode_equals_Override {

	public static void main(String[] args) {
		
		Set<Point> set = new HashSet<Point>();
		set.add(new Point(1,2));
		set.add(new Point(1,2));
		set.add(new Point(2,2));
		set.add(new Point(2,2));
		System.out.println(set);
		System.out.println(set.size());
		/**
		 *  now you get the expected results !
		 *  because this time you override the equals() and hashCode()
		 *  
		 */
		
		
		Point p1 = new Point(3,2);
		/**
		 * when you are using hashSet, after putting elements into a hashSet, 
		 * just don't change any properties. Because it will affect your hashCode().
		 * otherwise, this element will be added twice or more
		 */
		set.add(p1);
		p1.setX(5);
		set.add(p1);
		System.out.println(set.size());
	}
	
}


class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	// this is how you implement hashCode() and equals();
	// if you comment out this method things will change!!!!
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	/**
	 *  if you don't change your properties then you hashCode() should never be changed
	 *  it's like a identity, 
	 *  you can see that, if you change your properties, you hashCode() will definitely change!
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}