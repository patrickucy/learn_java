package day17.Demo11_Map_Practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * count the occurrence of those numbers
 * @author patrickyu
 *
 */
public class Demo11_Map_Practise {
	
	public static void main(String[] args) {
		String str = "123,456,543,234,654,543,123,455,456,234,654,543";
		/**
		 *  create a Map to count these numbers
		 *  key: every number
		 *  value: occurrence
		 *  
		 *  1. split strings to an array
		 *  2. put every number into map as a key, there will be two cases!
		 *  	2.1: this key doesn't exist in this map, which means this is the first time
		 *  		 then we set its value as 1
		 *  	2.2: this key does exist before, then we get the value of this key and add one, then put back
		 */
		// #1
		String[] array = str.split(",");
		System.out.println(Arrays.toString(array));
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		// #2
		for(String key : array){
			// #2.1
			if(!map.containsKey(key)){
				map.put(key, 1);
			}else{
				// #2.2
				map.put(key, map.get(key)+1);
			}
		}
		
		System.out.println(map);
		/**
		 *  map has override its toString() method
		 *  {key1.toString()=value1.toString, ...}
		 */
		
	}
}
