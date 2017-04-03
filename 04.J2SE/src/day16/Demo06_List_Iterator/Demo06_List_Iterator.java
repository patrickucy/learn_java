package day16.Demo06_List_Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * using iterator to iterate elements in collections
 * @author patrickyu
 *
 */
public class Demo06_List_Iterator {

	public static void main(String[] args) {
//		Collection collection = new ArrayList();
		Collection collection = new LinkedList();
		// how to use them is exactly the same !!!!
		
		collection.add("1");
		collection.add("#");
		collection.add("2");
		collection.add("#");
		collection.add("3");
		collection.add("#");
		collection.add("4");
		collection.add("#");
		collection.add("5");
		collection.add("#");
		collection.add("6");
		collection.add("#");
		collection.add("7");
		collection.add("#");
		collection.add("8");
		System.out.println(collection);
		
		/**
		 * traditional way of enumerating elements
		 */
		List list = (List)collection;
		for (int i = 0; i < collection.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println("");
		
		/**
		 * using iterator to enumerate
		 * it's designed specifically for while loop
		 * 
		 *  you can't just use it.next() more than once, because it will just jumps to the next of next
		 *  these guys are nodes! this is why just just jumps more than once
			 
		 */
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			String str = (String) it.next();
			if ("#".equals(str)) {
				it.remove(); // iterator will just remove current object in collection,just use it once
//				it.remove(); // never use remove twice when using iterator
				// don't use collection.remove(); // when you using iterator, don't use remove() of collection
				
			}
		}
		System.out.println(collection);

	}
}
