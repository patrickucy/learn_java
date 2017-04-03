package day16.Demo05_List_toArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * converting list to array 
 * @author patrickyu
 *
 */
public class Demo05_List_toArray {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		int index = list.indexOf("two");
		System.out.println("index of \"two\" in list: "+index);
				
		// approach #1
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = (String) list.get(i);
		}
		System.out.println(Arrays.toString(array));
		
		
		// approach #2
		String[] array2 = (String[]) list.toArray(new String[0]); // toArray() always returns a Object array
		/**
		 * here the argument is "new String[0]", this is not the real array will be using
		 * it just tells "toArray()" we want to return a String[], that's it!
		 * you can declare whatever length you want, but normally we use 0
		 * 
		 */
		System.out.println(Arrays.toString(array2));
		
	}
}
