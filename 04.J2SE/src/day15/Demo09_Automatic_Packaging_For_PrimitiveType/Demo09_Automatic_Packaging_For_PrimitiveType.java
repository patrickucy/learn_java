package day15.Demo09_Automatic_Packaging_For_PrimitiveType;
/**
 * After java 1.5, java can automatically package and un-package primitive type
 * 
 * @author patrickyu
 *
 */
public class Demo09_Automatic_Packaging_For_PrimitiveType {

	public static void main(String[] args) {
		Integer integer = 1; 	// package    just like this!
		// here in fact call a Interger.valueOf(1) for you automatically !
		int i = integer; 		// un=package  
		/**
		 * here looks pretty similar to OC, using special way to do this kind of primitive type conversion
		 */
		
		doss(i);
		
		integer = 1 + 2; // it first calculate the result of such expression, then convert it into package
		
		
	}
	
	public static void doss(Object obj){
		
	}
	
}
