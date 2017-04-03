package day16.Demo09_Generic_Programming_In_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * iterator also supports generic programming
 * however, the generic type of iterator is depended on its collection
 * they should be consistent!
 * @author patrickyu
 *
 */
public class Demo09_Generic_Programming_In_Iterator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next(); // we don't need to cast right now, because you are using generic type
			System.out.println(str);
		}
	}
	
}
