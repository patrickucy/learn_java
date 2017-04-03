package day17.Demo07_Set_Intro;

import java.awt.Insets;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * set collection, no duplicate elements
 * Set is also an interface
 * @author patrickyu
 *
 */
public class Demo07_Set_Intro {
	
	public static void main(String[] args) {
		/**
		 * just like List interface, you need to specify the generic type
		 */
		Set<String> set = new HashSet<String>();
		set.add("hello");
		set.add("hello");
		System.out.println(set);
		/**
		 *  things work fine
		 */
		
		
		
		
		Set<Point> pSet = new HashSet<Point>();
		pSet.add(new Point(1,2));
		pSet.add(new Point(2,2));
		pSet.add(new Point(1,2));
		pSet.add(new Point(2,2));
		System.out.println(pSet);
		/**
		 * the result is not our expected one!
		 * this is because HashSet is implemented by Hash Algorithm!!!!!
		 * normally, you override equals(), you also need to override hashCode!!! 
		 * this topic will be discuss later
		 */
		
		
		
		/**
		 * generate 20 random numbers that are not duplicates
		 */
		Set<Integer> intSet = new HashSet<Integer>();
		Random rand = new Random(); // don't put this in the while loop, it consumes more memory
		int sum = 0;
		while(intSet.size() < 20){
			intSet.add(rand.nextInt(100));
			sum ++;
		}
		System.out.println("it takes "+ sum + " times to generate this Set");
		// C method
		System.out.printf("it takes %d times to generate this Set \n",sum);
		System.out.println(intSet);
	}
}
