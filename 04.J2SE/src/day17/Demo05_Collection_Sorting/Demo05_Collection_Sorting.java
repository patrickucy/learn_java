package day17.Demo05_Collection_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * sorting collection
 * 
 * @author patrickyu
 *
 */
public class Demo05_Collection_Sorting {

	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,5));
		list.add(new Point(3,4));
		list.add(new Point(2,2));
		
		
		/**
		 * attention here this sort only works on "List"
		 * it doesn't work on "Set"
		 * because "Set" in nature is not a ordered collection
		 * 
		 */
		Collections.sort(list);
		System.out.println(list);
	}		
}
