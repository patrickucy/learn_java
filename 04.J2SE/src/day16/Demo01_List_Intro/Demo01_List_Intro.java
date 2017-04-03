package day16.Demo01_List_Intro;

import java.util.ArrayList;
import java.util.List;

/**
 * collection
 * used for store a package of data
 * ArrayList is ordered and can has repeated elements
 * 
 * @author patrickyu
 *
 */
public class Demo01_List_Intro {

	public static void main(String[] args) {
		/**
		 * java.util.List
		 * java.util.ArrayList
		 */
		List list = new ArrayList(); // polymorphism
		
		// adding elements to collection
		list.add("one");
		list.add("two");
		list.add("three");
		
		System.out.println("size: "+ list.size());
		/**
		 * ArrayList override toString()
		 * the format is as follow
		 * [element1.toString(),element2.toString(),...]
		 * 
		 */
		System.out.println(list);
		
		// clear elements in a collection
		list.clear();
		System.out.println("size: " + list.size());
		System.out.println(list);
		System.out.println(list.isEmpty());
		
		

		
	}
	
}
