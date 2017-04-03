package day16.Demo04_List_Index_Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * List, index operation on elements
 * @author patrickyu
 *
 */
public class Demo04_List_Index_Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			/**
			 * when you get this element, it's still an object
			 */
		}
		Object obj = list.set(2, "3");
		System.out.println(list);
		
		/**
		 *  as you can see, this method can replace the original element with a new one
		 *  and at the same time return the original one
		 */
		System.out.println(obj);
		String str = (String) obj;
		System.out.println(str);
		
		/**
		 * change collection as [one,2,three];
		 * 
		 */
		
		list.add(1, "2"); // only list has this index operation
		System.out.println(list);
		
		/**
		 *  delete the element at index 2
		 *  
		 */
		list.remove(2);
		System.out.println(list);
		
		
	}

}
