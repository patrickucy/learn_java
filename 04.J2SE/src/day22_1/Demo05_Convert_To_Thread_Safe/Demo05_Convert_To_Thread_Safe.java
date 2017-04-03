package day22_1.Demo05_Convert_To_Thread_Safe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * convert to thread safe data structure
 * @author patrickyu
 *
 */
public class Demo05_Convert_To_Thread_Safe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		
		/**
		 * convert ArrayList to a thread safe data structure
		 */
		List<String> synList = Collections.synchronizedList(list);
		System.out.println(synList);
		
		Set<String> set = new HashSet<String>();
		set = Collections.synchronizedSet(set);
		
		Map<String,String> map = new HashMap<String, String>();
		map = Collections.synchronizedMap(map);
				

	}

}
