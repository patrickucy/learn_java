package day17.Demo13_Map_Enumerating_AllKeys;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * enumerate all keys
 * @author patrickyu
 *
 */
public class Demo13_Map_Enumerating_AllKeys {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		
		/**
		 * Set keySet()
		 * get all keys from current Map and assign it to a set collection
		 */
		Set<Integer> keySet = map.keySet();
		for(Integer num: keySet){
			System.out.println("key: " + num);
		}
		

	}
}
