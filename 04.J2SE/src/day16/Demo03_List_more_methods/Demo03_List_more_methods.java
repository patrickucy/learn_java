package day16.Demo03_List_more_methods;

import java.util.ArrayList;
import java.util.List;

/**
 * methods in collection
 * @author patrickyu
 *
 */
public class Demo03_List_more_methods {

	public static void main(String[] args) {
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
		
		list1.add("one");
		list1.add("two");
		list1.add("three");
		
		list2.add("four");
		list2.add("five");
		
		list3.add("one");
		list3.add("two");
		
		System.out.println("list1: "+list1);
		System.out.println("list2: "+list2);
		System.out.println("list3: "+list3);
		
		list1.addAll(list2);
		System.out.println("list1: "+list1);
		list1.removeAll(list3); // removing elements in list3 from list 1
		System.out.println("list1: "+list1);
		
		/**
		 * only retain elements that they both contain,and delete all other elements
		 * retain intersection elements
		 */
		list1.retainAll(list2);
		System.out.println(list1);
		
	}
}
