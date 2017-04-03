package day16.Demo02_List_more;

import java.util.logging.Logger;

/**
 * Tesing "toString()" in "Object" class
 * @author patrickyu
 *
 */
public class Point {
	private int x;
	private int y;
	
	// pay attention, the main function here must be at the top of all functions !!!!
	public static void main(String[] args){
		Point p = new Point(1,2);
		// why this method can print anything?
		// because it always call the toString() method of such object
		System.out.println(p);
		
		Point p1 = new Point(1,2);
		boolean tf = p.equals(p1);
		System.out.println(tf);
		


	}

	// you don't need to declare return type for your constructor
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}



	// just like the description() in OC
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	/**
	 *  here the parameter is "Object", in the method, the real work is "toString" method
	 * @param obj
	 * if you use "Object: as the parameter type, you can gain the maximum flexibility
	 * 
	 */
	public static void println(Object obj){
		String str = obj.toString();
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		/**
		 *  if you are ovrriding  an equal method, you first need to know if this "obj" is the 
		 *  same class as current obj,if not, you don't even bother to compare them 
		 */
		 if(obj instanceof Point){
			 Point p = (Point)obj;
			 return p.x == this.x && p.y==this.y;
			 
		 }
		 return false;
	}
	/**
	 * once you comment out this method, you will get a false, that means java will not write "equals()"
	 * for you automatically. you would have to write it by youself. 
	 * 	
	 * public boolean equals(Object obj) {
			return this == obj;
		}
		
		this is what java would write for you automatically > comparing the real reference 
		
		However, Java API has overriden all their "equals", don't worry about it
		
	 */
	
	
	

}
