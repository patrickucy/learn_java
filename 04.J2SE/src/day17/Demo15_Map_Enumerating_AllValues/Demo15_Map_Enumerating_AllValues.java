package day17.Demo15_Map_Enumerating_AllValues;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * this situation is really rare
 * @author patrickyu
 *
 */
public class Demo15_Map_Enumerating_AllValues {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		Collection<String> collec = map.values();
		/**
		 * because we can have duplicate values!
		 */
		for (String value: collec) {
			System.out.println(value);
		}
	}
}
