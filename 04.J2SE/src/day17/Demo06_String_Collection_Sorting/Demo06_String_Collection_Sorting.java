package day17.Demo06_String_Collection_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author patrickyu
 *
 */
public class Demo06_String_Collection_Sorting {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("able");
		list.add("Ellen");
		list.add("Eve");
		list.add("boss");
		list.add("killer");
		list.add("Mary");
		list.add("Ada");
		
		System.out.println(list);
		Collections.sort(list); // according to ASCII!!
		System.out.println(list);
		/**
		 *  as you can see it sort name according to ASCII!!
		 *  what if you want to sort according to length???
		 *  
		 */
		
		
		
		
		/**
		 * approach #1
		 * fast way!
		 * Collections offers a Override sorting method
		 * Collections.sort(List l, Comparator c);
		 * 
		 */
		Comparator<String> comparator = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {				
				return o1.length() - o2.length();
			}
		}; // Anonymous internal class, temporary subclass of Comparator
		Collections.sort(list, comparator);
		System.out.println(list);
		
		
		
		
		
		/**
		 *  approach #2
		 *  formal way
		 */
		MyComparator comp = new MyComparator();
		Collections.sort(list, comp);
		System.out.println(list);
	}
}



class MyComparator implements Comparator<String> {
	/**
	 *  this is the formal way of defining a specific comparator for myself
	 *  
	 *  just the same as before, return value determines which one is bigger
	 *  here you can define your own rules to do comparison
	 *  
	 */
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return - o1.length() + o2.length();
	}
	
}
