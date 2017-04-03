package day17.Demo14_Map_Enumerating_AllKeyAndValues;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * enumerating all key-value
 * @author patrickyu
 *
 */
public class Demo14_Map_Enumerating_AllKeyAndValues {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		
		/**
		 * HashMap store several Entry instance, key,value are its properties!
		 * So Entry = [key,value]
		 * here generic type still can has a generic type
		 */
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for(Entry<Integer,String> entry : entrySet){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key +"=" + value);
		}
		
	}
}
