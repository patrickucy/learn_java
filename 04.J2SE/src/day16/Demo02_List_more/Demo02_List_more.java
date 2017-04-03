package day16.Demo02_List_more;

import java.util.ArrayList;
import java.util.List;

/**
 * collection methods
 * @author patrickyu
 *
 */
public class Demo02_List_more {
	public static void main(String[] args) {
		List list = new ArrayList(); // there will always a compile warning here, it will be explained later
		/**
		 * adding Point instance to our collection
		 */
		list.add(new Point(1,2));
		list.add(new Point(1,2));
		list.add(new Point(5,6));
		System.out.println(list);
		
		Point p = new Point(1,2);
		if (list.contains(p)) {
			System.out.println("exist"); // it exists !
		}else{
			System.out.println("not exist");
		}
		
		/**
		 *  what contains() really does?
		 *  it uses equals() to determine if such object exist in our collection,
		 *  why the result is exist? because, you've override the equals() in Point!!!
		 *  if not, it will output not exist, because, in fact, you have never put that
		 *  exact object in your collection before, even though their properties are the same
		 *  just like the demo above
		 *  
		 *  the method contains() really depends on equals() !!!!!
		 *  
		 *  
		 *  when do we have to override equals() ??????
		 *  it really depends on your project needs
		 */
		
		list.remove(p);
		/** 
		 * remove() really depends on equals()!
		 * and it just removes the first element it encouters
		 * just like this demo, it just remove the first Point(1,2)!!!!
		 */
		System.out.println(list);
	}
}
