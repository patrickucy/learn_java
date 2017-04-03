package day17.Demo08_Set_Get_Element;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Get elements from Set
 * Set doesn't support get() like List, because it doesn't have an index
 * the only way to enumerate is to use iterator
 * 
 * @author patrickyu
 *
 */
public class Demo08_Set_Get_Element {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		/**
		 *  approach #1
		 *  get an iterator for HashSet collection
		 * 
		 */
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println(str);
		}
		/**
		 * 
		 * the order of elements in set is fixed, but the order 
		 * you put these elements in and get them is different
		 */
		
		/** 
		 * approach #2
		 * use new for loop
		 * the Only drawback of this approach is that you can't have the index
		 */
		for(String str : set){
			System.out.println(str);		
		}
		
	}
}
